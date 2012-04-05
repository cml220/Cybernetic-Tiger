package dbprocess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** Removal database processes.
 * @author Colin
 */
public class RemovalProcess {
    /** db connection. */
    private final Connection conn;
    /** instance of class. */
    private static RemovalProcess instance;

    /** Constructor.
     * @param conn db connection
     * @throws SQLException sql method fail
     */
    protected RemovalProcess(
            final Connection conn) throws SQLException {
        this.conn = conn;
    }

    /** Singleton pattern RemovalProcess init.
     * @param conn db connection
     * @return    single instance of DatabaseProcess
     */
    protected static synchronized RemovalProcess getInstance(
            final Connection conn) {
        if (instance == null) {
            try {
                instance = new RemovalProcess(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    /** Remove a single book from the catalogue as well as all rentals.
     * @param bookIsbn         isbn of the book to be removed
     * @throws SQLException        failed sql methods
     */
    protected final void removeBookFromCatalogue(
            final long bookIsbn) throws SQLException {
        if (bookIsbn < 0) {
            return;
        }
        Statement stmt = conn.createStatement();
        Statement stmt2 = conn.createStatement();
        stmt.execute("DELETE FROM tblBook WHERE ISBN=" + bookIsbn + ";");
        stmt2.execute("DELETE FROM tblBookRental WHERE BookISBN="
                + bookIsbn + ";");
    }

    /** Remove a user from the db.
     * @param username    the user to be removed
     * @return true        if the user has been removed; false otherwise
     * @throws SQLException        failed sql methods
     */
    protected final boolean removeUser(
            final String username) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.execute("DELETE FROM "
                + "tblUser WHERE UserName=\""
                + username + "\"");
        stmt.execute("DELETE FROM "
                + "tblAccountInfo WHERE UserName=\""
                + username + "\"");

        DatabaseProcess db = DatabaseProcess.getInstance();
        //if the username is NOT in use, then the user was removed
        return !db.checkUser(username, null);
    }

    /** remove an existing user's shopping cart.
     * @param userName        user whose cart is to be removed
     * @return                true if removed; false otherwise
     * @throws SQLException        failed sql methods
     */
    protected final boolean removeShoppingCart(
            final String userName) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "
                + "tblShoppingCart WHERE UserName = \""
                + userName + "\"");
        Statement stmt2 = conn.createStatement();
        if (rs.next()) {
            stmt2.execute("DELETE FROM tblCartContent "
                    + "WHERE CartNumber = " + rs.getInt("CartNumber"));
            stmt2.execute("DELETE FROM tblShoppingCart "
                    + "WHERE CartNumber = " + rs.getInt("CartNumber"));
            return true;
        }
        return false;
    }

    /** Remove a book from a user's rentals.
     * @param username    the user
     * @param isbn        the book to be removed from the user
     * @return true       if the book has been removed from the user
     *                    ; false otherwise
     * @throws SQLException        failed sql methods
     */
    protected final boolean removeBookFromUser(
            final String username, final long isbn) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.execute("DELETE FROM tblBookRental "
                + "WHERE UserName=\"" + username
                + "\" AND BookISBN=" + isbn);

        DatabaseProcess db = DatabaseProcess.getInstance();
        return !db.userHasBook(username, isbn);
    }

    /** Remove the payment info for a given user.
     * @param username  the user for it to be removed from
     * @return  true if removed; false otherwise
     * @throws SQLException
     */
    protected final boolean removePaymentInfo(
            final String username) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.execute("DELETE FROM "
                + "tblPaymentInfo WHERE UserName=\""
                + username + "\"");
        ResultSet rs = stmt.executeQuery("SELECT * FROM "
                + "tblPaymentInfo WHERE UserName=\""
                + username + "\"");
        if(rs.next()) {
            return false;
        }
        else {
            return true;
        }
    }

    /** Remove the payment info for a given user.
     * @param username  the user for it to be removed from
     * @return  true if removed; false otherwise
     * @throws SQLException
     */
    protected final boolean clearCart(
            final String username) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.execute("DELETE FROM "
                + "tblCartContent WHERE CartNumber=(SELECT CartNumber FROM tblShoppingCart WHERE UserName=\"" + username + "\")");
    }


}
