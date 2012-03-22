package dbprocess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.NoUsernameOrPasswordException;
import exceptions.NullUserException;
import exceptions.UserAlreadyExistsException;

import model.Book;
import model.Cart;
import model.PaymentInfo;

/** Insertion database processes.
 * @author Colin
 */
public class InsertionProcess {
    /** db connection. */
    private Connection conn;
    /** instance of class. */
    private static InsertionProcess instance;

    /** Constructor.
     * @param conn db connection
     * @throws SQLException sql method fail
     */
    protected InsertionProcess(
            final Connection conn) throws SQLException {
        this.conn = conn;
    }

    /** Singleton pattern InsertionProcess init.
     * @param conn db connection
     * @return    single instance of DatabaseProcess
     */
    public static synchronized InsertionProcess getInstance(
            final Connection conn) {
        if (instance == null) {
            try {
                instance = new InsertionProcess(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    /** Add a book to a user's rentals.
     * @param isbn        isbn of book to be added
     * @param username    the user for it to be added to
     * @throws SQLException failed sql methods
     */
    protected final void addBookToUser(
            final long isbn, final String username) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT * FROM "
                + "tblBook WHERE ISBN=" + isbn + ";");
        if (rs.next()) {
            stmt.execute("INSERT INTO tblBookRental(BookISBN, UserName)"
                    + " VALUES (" + isbn + ",\"" + username + "\");");
        }
    }

    /** Add a book to the catalogue.
     * @param    b    book to be added to the catalogue
     * @throws SQLException        failed sql methods
     */
    protected final void addBookToCatalogue(final Book b) throws SQLException {
        if (b == null) {
            return;
        }
        Statement stmt = conn.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT * FROM"
                + " tblBook WHERE ISBN=\""
                + b.getBookISBN() + "\";");
        if (rs.first()) {
            return;    //book with this isbn already exists
        } else {
            stmt.execute("INSERT INTO tblBook"
                    + " (Title,Author,Price,Url,ISBN,picURL,Description) "
                    + "VALUES (\"" + b.getBookTitle()
                    + "\",\"" + b.getBookAuthor()
                    + "\"," + b.getBookPrice()
                    + ",\"" + b.getBookPdfURL() + "\",\""
                    + b.getBookISBN() + "\",\"" + b.getBookImg()
                    + "\",\"" + b.getBookDescription() + "\");");
            rs = stmt.executeQuery("SELECT * FROM "
                    + "tblBook WHERE ISBN=\"" + b.getBookISBN() + "\";");
            rs.first();
        }
    }

    /** Create a new user for the system.
     * @param userName    user to be added to the system
     * @param passWord    password to be given to user
     * @param email        email to be given to user
     * @postcond    user has been added to the system
     * @return      true if successful; exception thrown otherwise
     * @throws SQLException sql method fail
     * @throws NoUsernameOrPasswordException self-expl
     * @throws NullUserException self-expl
     * @throws UserAlreadyExistsException self-expl
     */
    protected final boolean createUser(
            final String userName, final String email, final String passWord)
                            throws SQLException,
                                    NoUsernameOrPasswordException,
                                    NullUserException,
                                    UserAlreadyExistsException {
        if (stringIsEmpty(userName) || stringIsEmpty(passWord)) {
            throw new
                NoUsernameOrPasswordException(
                "Please supply both a username and password.");
        }
        Statement stmt = conn.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT * FROM "
                + "tblUser WHERE UserName=\"" + userName + "\";");
        if (rs.next()) {
            //value in result set; user already exists
            throw new
                UserAlreadyExistsException(
                "A user with that name already exists.");
        } else {
            stmt.execute("INSERT INTO tblUser "
                    + "(UserName, PassWord, IsAdmin) "
                    + "VALUES (\"" + userName
                    + "\",\"" + passWord + "\",\""
                    + "N" + "\");");
            stmt.execute("INSERT INTO tblAccountInfo "
                    + "(UserName, FirstName, LastName, Email) "
                    + "VALUES (\"" + userName
                    + "\", \"\", \"\",\""
                    + email + "\")");
            rs = stmt.executeQuery("SELECT * FROM "
                    + "tblUser WHERE UserName=\""
                    + userName + "\";");
            rs.first();
            return true;
        }
    }

    /** Save a cart and its contents in the appropriate tables.
     * @param c            the cart to be saved
     * @param username    the user for it to be saved to
     * @param shopdate    the date in which it was saved
     * @throws SQLException        failed sql methods
     */
    protected final void saveShoppingCart(
            final Cart c, final String username,
            final String shopdate) throws SQLException {
        DatabaseProcess db = DatabaseProcess.getInstance();
        db.removeShoppingCart(username);
        Statement stmt = conn.createStatement();
        stmt.execute("INSERT INTO tblShoppingCart "
                + "(UserName, ShopDate) VALUES (\""
                + username + "\",\""
                + shopdate + "\")");
        ResultSet rs;
        rs = stmt.executeQuery("SELECT * FROM "
                + "tblShoppingCart WHERE UserName=\""
                + username + "\" AND ShopDate=\""
                + shopdate + "\"");
        rs.next();
        int cartNum = rs.getInt("CartNumber");
        for (int i = 0; i < c.size(); i++) {
            stmt.execute("INSERT INTO tblCartContent "
                    + "(CartNumber, BookISBN) VALUES ("
                    + cartNum + ","
                    + c.get(i).getBookISBN() + ")");
        }
    }
    
    /** Save a user's payment info to the db
     * @param info  the payment info to be saved incl all fields
     * @throws SQLException failed sql methods
     */
    protected final void savePaymentInfo(
            final String username, final PaymentInfo info) 
                    throws SQLException {
        DatabaseProcess db = DatabaseProcess.getInstance();
        db.removePaymentInfo(info.getName());
        Statement stmt = conn.createStatement();
        stmt.execute("INSERT INTO tblPaymentInfo "
                + "(UserName,CardNumber,Name,Country,Address,Address2"
                + ",ExpMonth,ExpYear,SecurityCode"
                + ",State,ZIP,Phone) VALUES "
                + "(\"" + username + "\",\""
                + info.getCardNumber()+ "\",\""
                + info.getName()+ "\",\""
                + info.getCountry() + "\",\""
                + info.getAddress() + "\",\""
                + info.getAddress2() + "\",\""
                + info.getExpiryMonth() + "\",\""
                + info.getExpiryYear() + "\",\""
                + info.getSecurityCode() + "\",\""
                + info.getState() + "\",\""
                + info.getZip() + "\",\""
                + info.getPhone() + "\")");
    }

    /** Helper method to validate that
     *  a string is not empty, null or "".
     * @param str    the string to check
     * @return        true if "not empty", otherwise false
     */
    private boolean stringIsEmpty(final String str) {
        if (str == null || str.isEmpty() || str.equals("")) {
            return true;
        }
        return false;
    }
}
