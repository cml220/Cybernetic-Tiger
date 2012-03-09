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
    public boolean checkUser(String username, String password) throws SQLException {
    	if(!username.equals("") && !password.equals("")) {
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery("SELECT * FROM tblUser WHERE Username = \"" + username + "\" AND passWord = \"" + password + "\";");
    		if(rs.next())
    			return true;
    	}
    	if(!username.equals("") && password.equals("")) {
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery("Select Username FROM tblUser WHERE UserName =\"" + username + "\";");
    		if(rs.next())
    			return false;
    		return true;
    	}
    	return false;
    }
    
    /**
     * Check to see if a user is registered in the system
     * @param	userName	the login name to be searched for
     * @param	password	the password to be searched for
     * @return 	true if username and password are registered to a user; false otherwise
     */
    //deprecated??
    public boolean checkLogin(String username, String password) throws SQLException {
        if(username==null || password==null) {
            return false;
        }
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblUser WHERE UserName=\"" + username + "\" AND PassWord=\"" + password + "\";");
        if(rs.first()) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Check to see if a username is available
     * @param	username	the username to check
     */
    //deprecated??
    public boolean checkNameAvailable(String username) throws SQLException {
    	if(username==null) {
            return false;
        }
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT UserName FROM tblUser");
        if(rs.first()) {
            return true;	//name available
        } else {
            return false;	//name unavailable
        }
    }

}
