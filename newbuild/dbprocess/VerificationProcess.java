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
     * Check to see if username is available, also used to see if user is registered in the system.
     * @param username  the login name to be searched for. Or the username to check 
     * @param password	the password to be searched for.
     * @return true		username is free, or also username and password match
     * To check if username is avail. db.checkUser("username", null)
     * To see if user is registered in system: db.checkUser("username", "password")
     */
    protected boolean checkUser(String username, String password) throws SQLException {
    	if(!username.equals("") && password == null) {
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery("Select Username FROM tblUser WHERE UserName =\"" + username + "\";");
    		if(rs.next())
    			return false;
    		return true;
    	}
    	if(!username.equals("") && !password.equals("")) {
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery("SELECT * FROM tblUser WHERE Username = \"" + username + "\" AND passWord = \"" + password + "\";");
    		if(rs.next())
    			return true;
    	}
    	return false;
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
