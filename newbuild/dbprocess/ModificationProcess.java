package dbprocess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;

public class ModificationProcess {
	/* name of the database */
	private static String dbname = "cmpt371group_CTiger";
    
	protected Connection conn;

    private static ModificationProcess instance;
    
    /**
     * Constructor
     */
    protected ModificationProcess() throws SQLException {
        initDatabaseConnection();
    }

    /**
     * Singleton pattern DatabaseProcess init
     * @return	single instance of DatabaseProcess
     */
    public static synchronized ModificationProcess getInstance() {
        if (instance == null) {
            try {
                instance = new ModificationProcess();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    /**
     * Initialize a connection to the database
     * @postcond	connection to the database initialized
     */
    private void initDatabaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url="jdbc:mysql://edjo.usask.ca/" + dbname + "?user=cmpt371gCT_user&password=TiggerTyger1";
            conn=DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    
    //TODO: Have to figure out how we handle users and what we want to change before this can be completed!
    public void editUserInfo(String oldname, User newinfo) throws SQLException {
    	RemovalProcess db = RemovalProcess.getInstance();
    	InsertionProcess idb = InsertionProcess.getInstance();
    	db.removeUser(oldname);
    	idb.createUser(newinfo);   	
    }
}
