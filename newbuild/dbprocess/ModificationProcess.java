package dbprocess;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;

public class ModificationProcess {
	protected Connection conn;
    private static ModificationProcess instance;
    
    /**
     * Constructor
     */
    protected ModificationProcess(Connection conn) throws SQLException {
        this.conn = conn;
    }

    /**
     * Singleton pattern DatabaseProcess init
     * @return	single instance of DatabaseProcess
     */
    public static synchronized ModificationProcess getInstance(Connection conn) {
        if (instance == null) {
            try {
                instance = new ModificationProcess(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
    
    /**
     * Update a user's profile image
     * @param	url			the url of the profile image
     * @param	username	the username of the user
     */
    //deprecated??
    public void editUserProfilePic(String url, String username)	throws SQLException {
        if(username==null || url==null) {
            return;
        }
        Statement stmt=conn.createStatement();
        stmt.execute("UPDATE tblUser SET Img=\"" + url + "\" WHERE UserName=\"" + username + "\";");
        conn.close();
    }
    
    //TODO: Have to figure out how we handle users and what we want to change before this can be completed!
    public void editUserInfo(String oldname, User newinfo) throws SQLException {
    	RemovalProcess db = RemovalProcess.getInstance(conn);
    	InsertionProcess idb = InsertionProcess.getInstance(conn);
    	db.removeUser(oldname);
    	idb.createUser(newinfo, "");   	
    }
}
