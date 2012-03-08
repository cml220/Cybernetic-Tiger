package dbprocess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RemovalProcess {
	/* name of the database */
	private static String dbname = "cmpt371group_CTiger";
    
	protected Connection conn;

    private static RemovalProcess instance;
    
    /**
     * Constructor
     */
    protected RemovalProcess() throws SQLException {
        initDatabaseConnection();
    }

    /**
     * Singleton pattern DatabaseProcess init
     * @return	single instance of DatabaseProcess
     */
    public static synchronized RemovalProcess getInstance() {
        if (instance == null) {
            try {
                instance = new RemovalProcess();
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
     * Remove a single book from the catalogue as well as all rentals
     * @param bookid	the id of the book to be removed
     */
    public void removeBookFromCatalogue(int bookid) throws SQLException {
        if(bookid < 0) {
            return;
        }
        Statement stmt=conn.createStatement();
        Statement stmt2=conn.createStatement();
        stmt.execute("DELETE FROM books WHERE books.id=" + bookid + ";");
        stmt2.execute("DELETE FROM userRentals WHERE userRentals.bookID=" + bookid + ";");
    }
    
    /**
     * Remove a user from the db
     * @param username	the user to be removed
     */
    protected void removeUser(String username) throws SQLException {
    	Statement stmt=conn.createStatement();
    	stmt.execute("DELETE FROM tblUser WHERE UserName=\"" + username + "\")");
    }

}
