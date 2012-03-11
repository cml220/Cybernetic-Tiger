package dbprocess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VerificationProcess { 
	protected Connection conn;
    private static VerificationProcess instance;
    
    /**
     * Constructor
     */
    protected VerificationProcess(Connection conn) throws SQLException {
        this.conn = conn;
    }

    /**
     * Singleton pattern DatabaseProcess init
     * @return	single instance of DatabaseProcess
     */
    public static synchronized VerificationProcess getInstance(Connection conn) {
        if (instance == null) {
            try {
                instance = new VerificationProcess(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
    
    /**
     * Check if a user with the given login info is registered
     * @param username  the login name to be searched for
     * @param password	the password to be searched for
     * @return	true if a user with that info is registered; false otherwise
     */
    protected boolean checkUser(String username, String password) throws SQLException {
    	Statement stmt = conn.createStatement();
    	ResultSet rs = stmt.executeQuery("SELECT * FROM tblUser WHERE Username = \"" + username + "\" AND passWord = \"" + password + "\";");
    	if(rs.next())
    		return true;
    	return false;
    }
    
    /**
     * is the provided username available?
     * @param username	the username to search for
     * @return	true if the username is available; false otherwise
     */
    protected boolean isNameAvailable(String username) throws SQLException {
    	if(username == null) return false;
    	Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("Select Username FROM tblUser WHERE UserName =\"" + username + "\";");
		if(rs.next())
			return false;
		return true;
    }
    
    /**
     * Check if a user has a book in their rentals
     * @param username	the user to check
     * @param isbn		the book to check for
     * @return	true 	if the user has the book; false otherwise
     */
    protected boolean userHasBook(String username, int isbn) throws SQLException {
    	Statement stmt = conn.createStatement();
    	ResultSet rs = stmt.executeQuery("SELECT * FROM tblBookRental WHERE UserName=\"" + username + "\" AND BookISBN=" + isbn);
    	if(rs.next())
    		return true;
    	return false;
    }
}
