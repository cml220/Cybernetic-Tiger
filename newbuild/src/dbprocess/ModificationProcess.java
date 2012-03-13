package dbprocess;

import java.sql.Connection;
import org.apache.log4j.Logger;
import java.sql.SQLException;

import model.User;

/** Modification database processes.
 * @author Colin
 */
public class ModificationProcess {
    /** db connection. */
    private Connection conn;
    /** instance of class. */
    private static ModificationProcess instance;
    /** log4j logger. */
    private Logger log = Logger.getLogger(DatabaseProcessJUnit.class);

    /** Constructor.
     * @param conn db connection
     * @throws SQLException sql method fail
     */
    protected ModificationProcess(
            final Connection conn) throws SQLException {
        this.conn = conn;
    }

    /** Singleton pattern DatabaseProcess init.
     * @param conn  db connection
     * @return  single instance of DatabaseProcess
     */
    public static synchronized ModificationProcess getInstance(
            final Connection conn) {
        if (instance == null) {
            try {
                instance = new ModificationProcess(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    /** Edit an existing user's information incl. password, email, admin status.
     * @param newInfo            user obj containing new info
     *                        incl. email, admin status
     * @param passWord        original password for verification
     * @param newPassWord     new password;
     *                        pass original password to keep this unchanged
     * @throws Exception      failed sql methods
     */
    protected final void editUserInfo(
            final User newInfo, final String passWord,
            final String newPassWord) throws Exception {
        RemovalProcess db = RemovalProcess.getInstance(conn);
        InsertionProcess idb = InsertionProcess.getInstance(conn);
        VerificationProcess vdb = VerificationProcess.getInstance(conn);
        if (vdb.checkUser(newInfo.getUserName(), passWord)) {
            db.removeUser(newInfo.getUserName());
            idb.createUser(newInfo.getUserName(),
                    newInfo.getEmail(), newPassWord);
        } else {
            log.debug("Invalid username/password.");
        }
    }
}
