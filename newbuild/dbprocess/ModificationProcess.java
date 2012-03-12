package dbprocess;

import java.sql.Connection;
import org.apache.log4j.Logger;
import java.sql.SQLException;

import model.User;

public class ModificationProcess {
	protected Connection conn;
    private static ModificationProcess instance;
	Logger log = Logger.getLogger(DatabaseProcessJUnit.class);

    
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
     * Edit an existing user's information incl. password, email, admin status
     * @param newInfo		user obj containing new info incl. email, admin status
     * @param passWord		original password for verification
     * @param newPassWord	new password; pass original password to keep this unchanged
     */
    protected void editUserInfo(User newInfo, String passWord, String newPassWord) throws Exception {
    	RemovalProcess db = RemovalProcess.getInstance(conn);
    	InsertionProcess idb = InsertionProcess.getInstance(conn);
    	VerificationProcess vdb = VerificationProcess.getInstance(conn);
    	if(vdb.checkUser(newInfo.getUserName(), passWord)) {
    		db.removeUser(newInfo.getUserName());
    		idb.createUser(newInfo.getUserName(), newInfo.getEmail(), newPassWord);
    	} else {
    		log.debug("Invalid username/password.");
    	}
    }
}
