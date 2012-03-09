package dbprocess;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RemovalProcess {
	Logger log = Logger.getLogger(DatabaseProcessJUnit.class);
	protected Connection conn;
    private static RemovalProcess instance;
    
    /**
     * Constructor
     */
    protected RemovalProcess(Connection conn) throws SQLException {
        this.conn = conn;
    }

    /**
     * Singleton pattern DatabaseProcess init
     * @return	single instance of DatabaseProcess
     */
    protected static synchronized RemovalProcess getInstance(Connection conn) {
        if (instance == null) {
            try {
                instance = new RemovalProcess(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
    
    /**
     * Remove a single book from the catalogue as well as all rentals
     * @param bookIsbn	the isbn of the book to be removed
     */
    protected void removeBookFromCatalogue(int bookIsbn) throws SQLException {
        if(bookIsbn < 0) {
            return;
        }
        log.debug("RemoveBookFromCatalogue entered");
        Statement stmt=conn.createStatement();
        Statement stmt2=conn.createStatement();
        stmt.execute("DELETE FROM tblBook WHERE ISBN=" + bookIsbn + ";");
        stmt2.execute("DELETE FROM tblBookRental WHERE BookISBN=" + bookIsbn + ";");
    }
    
    /**
     * Remove a user from the db
     * @param username	the user to be removed
     * @return true		if the user has been removed; false otherwise
     */
    protected boolean removeUser(String username) throws SQLException {
    	Statement stmt=conn.createStatement();
    	stmt.execute("DELETE FROM tblUser WHERE UserName=\"" + username + "\"");
    	stmt.execute("DELETE FROM tblAccountInfo WHERE UserName=\"" + username + "\"");
    	
    	DatabaseProcess db = DatabaseProcess.getInstance();
    	return !db.checkUser(username, null);	//if the username is NOT in use, then the user was removed
    }
    
    /**
     * Remove a book from a user's rentals
     * @param username	the user
     * @param isbn		the book to be removed from the user
     * @return true		if the book has been removed from the user; false otherwise
     */
    protected boolean removeBookFromUser(String username, int isbn) throws SQLException {
    	Statement stmt=conn.createStatement();
    	stmt.execute("DELETE FROM tblBookRental WHERE UserName=\"" + username + "\" AND BookISBN=" + isbn);
    
    	DatabaseProcess db = DatabaseProcess.getInstance();
    	return !db.userHasBook(username, isbn);
    }
}
