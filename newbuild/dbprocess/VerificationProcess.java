package dbprocess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** Verification database processes.
 * @author Colin
 */
public class VerificationProcess {
    /** db connection. */
    private Connection conn;
    /** instance of class. */
    private static VerificationProcess instance;

    /** Constructor.
     * @param conn db connection
     * @throws SQLException sql method fail
     */
    protected VerificationProcess(
            final Connection conn) throws SQLException {
        this.conn = conn;
    }

    /** Singleton pattern VerificationProcess init.
     * @param conn db connection
     * @return    single instance of DatabaseProcess
     */
    public static synchronized VerificationProcess getInstance(
            final Connection conn) {
        if (instance == null) {
            try {
                instance = new VerificationProcess(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    /** Check if a user with the given login info is registered.
     * @param username  the login name to be searched for
     * @param password    the password to be searched for
     * @return    true if a user with that info is registered; false otherwise
     * @throws SQLException        failed sql methods
     */
    protected final boolean checkUser(
            final String username,
            final String password) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT * FROM "
                + "tblUser WHERE Username = \""
                + username + "\" AND passWord = \""
                + password + "\";");
        if (rs.next()) {
            return true;
        }
        return false;
    }

    /** is the provided username available?
     * @param username    the username to search for
     * @return    true if the username is available; false otherwise
     * @throws SQLException        failed sql methods
     */
    protected final boolean isNameAvailable(
            final String username) throws SQLException {
        if (username == null) {
            return false;
        }
        Statement stmt = conn.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("Select Username FROM "
                + "tblUser WHERE UserName =\""
                + username + "\";");
        if (rs.next()) {
            return false;
        }
        return true;
    }

    /** Check if a user has a book in their rentals.
     * @param username    the user to check
     * @param isbn        the book to check for
     * @return    true     if the user has the book; false otherwise
     * @throws SQLException        failed sql methods
     */
    protected final boolean userHasBook(
            final String username, final long isbn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "
                + "tblBookRental WHERE UserName=\""
                + username + "\" AND BookISBN=" + isbn);
        if (rs.next()) {
            return true;
        }
        return false;
    }
}
