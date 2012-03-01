package dbprocess;

import java.sql.SQLException;
import java.sql.Statement;

public class RemovalProcess extends DatabaseProcess {
	/* name of the database */
    private static String dbname = "cmpt370group04";
    
    private RemovalProcess() throws SQLException {
    	super();
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
        stmt.execute("DELETE FROM " + dbname + ".books WHERE books.id=" + bookid + ";");
        stmt2.execute("DELETE FROM " + dbname + ".userRentals WHERE userRentals.bookID=" + bookid + ";");
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
