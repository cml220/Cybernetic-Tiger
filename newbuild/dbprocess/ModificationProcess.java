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
    
    //TODO: Have to figure out how we handle users and what we want to change before this can be completed!
    protected void editUserInfo(String oldname, User newInfo, String passWord) throws Exception {
    	RemovalProcess db = RemovalProcess.getInstance(conn);
    	InsertionProcess idb = InsertionProcess.getInstance(conn);
    	VerificationProcess vdb = VerificationProcess.getInstance(conn);
    	if(vdb.checkUser(oldname, passWord)) {
    		db.removeUser(oldname);
    		idb.createUser(newInfo, passWord);
    	} else {
    		log.debug("Invalid username/password.");
    	}
    }
}
