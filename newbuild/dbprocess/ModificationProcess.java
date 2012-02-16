package dbprocess;

import java.sql.SQLException;
import java.sql.Statement;

import model.User;

public class ModificationProcess extends DatabaseProcess {
    /* name of the database */
    private static String dbname = "cmpt370group04";
    
    private ModificationProcess() throws SQLException {
    	super();
    }
    
    /**
     * Update a user's profile image
     * @param	url			the url of the profile image
     * @param	username	the username of the user
     */
    public void editUserProfilePic(String url, String username)	throws SQLException {
        if(username==null || url==null) {
            return;
        }
        Statement stmt=conn.createStatement();
        stmt.execute("UPDATE tblUser SET Img=\"" + url + "\" WHERE UserName=\"" + username + "\";");
    }
    
    public void editUserInfo(User u) throws SQLException {
    	//TODO
    }
}
