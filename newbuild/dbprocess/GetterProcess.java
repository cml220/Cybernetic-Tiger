/*
 * @author Colin Larson
 * TO BE COMPLETED
 */

package dbprocess;

import java.sql.Connection;
import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Book;
import model.User;

public class GetterProcess {
	Logger log = Logger.getLogger(DatabaseProcessJUnit.class);
    protected Connection conn;
    private static GetterProcess instance;
    
    /**
     * Constructor
     */
    protected GetterProcess(Connection conn) throws SQLException {
        this.conn = conn;
    }

    /**
     * Singleton pattern DatabaseProcess init
     * @return	single instance of DatabaseProcess
     */
    public static synchronized GetterProcess getInstance(Connection conn) {
        if (instance == null) {
            try {
                instance = new GetterProcess(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
    
    /**
     * Get the the user's data as html in a string
     * @param user	the user whose assoc. data is to be found
     * @return	the data (as a string) if found, otherwise null
     */
    protected User getUserInfo(String username) throws SQLException {
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblUser WHERE UserName = " + "\"" + username + "\"");
        Statement stmt2 = conn.createStatement();
        ResultSet rs2 = stmt2.executeQuery("SELECT * FROM tblAccountInfo WHERE UserName = " + "\"" + username + "\"");
        if(rs.next()) {
        	rs2.next();
        	User u = new User(rs.getString("UserName"), false, rs2.getString("email"));
        	if(rs.getString("isAdmin").equals("Y")) { u.isAdmin = true; }
        	else { u.isAdmin = false; }
            return u;
        } else {
            return null;
        }
    }
    
  
    /**
     * Find books by specified query, using specific option
     * @param	option	Define parameters of search (eg. search by Title, Author, Username or Catalogue)
     * @param	query	Define what to search for.
     * @return			A list of books that satisfy the search parameters.
     * To get books by title: db.getBookBy("Title", "A Clockwork Orange");
     * To get books by Author: db.getBookBy("Author", "Bob Loblaw");
     * To get a user's book library: db.getBookBy("Username", "colin");
     * To get entire catalogue: db.getBookBy("Catalogue", "");
     */  
	protected ArrayList<Book> getBooksBy(String option, String query) throws SQLException {
    	ResultSet rs = null;
    	Statement stmt = conn.createStatement();
    	if(option.equals("Author") && !query.equals("")) {
    		rs = stmt.executeQuery("SELECT * FROM tblBook WHERE Author LIKE \"%" + query + "%\" ORDER BY Title;");
    	}
    	else if(option.equals("Title") && !query.equals("")) {
    		rs = stmt.executeQuery("SELECT * FROM tblBook WHERE Title LIKE \"%" + query + "%\" ORDER BY Title;");
    	}
    	else if(option.equals("Catalogue") && query.equals("")) {
    		rs = stmt.executeQuery("SELECT * FROM tblBook ORDER BY Title;");
    	}
    	else if(option.equals("Username") && !query.equals("")) {
    		rs=stmt.executeQuery("SELECT tblBook.* FROM tblBook, tblBookRental WHERE tblBook.ISBN=tblBookRental.BookISBN AND tblBookRental.UserName=\"" + query + "\";");
    	}
    	else {
    		return null;
    	}
    	ArrayList<Book> bookList = new ArrayList<Book>();
    	while(rs.next()) {
    		bookList.add(new Book(rs.getString("Title"), rs.getString("Author"), rs.getDouble("Price"), rs.getString("Url"), rs.getInt("ISBN"), rs.getString("picUrl"), rs.getString("Description")));
    	}
    	if(bookList.size() == 0)
    		return null;
    	return bookList;    		
    }
    
    /**
     * Find a book by isbn (exact)
     * @param	ISBN	ISBN to search for
     * @return	the book with the given ISBN if found; otherwise null
     */
    protected Book getBookByIsbn(int isbn) throws SQLException {
        if(isbn<0) {
            return null;
        }
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblBook WHERE ISBN=" + isbn + ";");
        if (rs.next()) {
            return new Book(rs.getString("Title"), rs.getString("Author"), rs.getDouble("Price"), rs.getString("Url"), 
            		rs.getInt("ISBN"), rs.getString("picURL"), rs.getString("Description"));
        } else {	//no book found
        	log.debug("return null");
            return null;
        }
    }
    
    /**
     * Get the admin status of a user
     * @param	username	the username of the user
     */
    protected String getAdminStatus(String username) throws SQLException {
        if(username==null) {
            return "false";
        }
        Statement stmt=conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT IsAdmin FROM tblUser WHERE UserName=\"" + username + "\";");
        if(rs.first()) {
        	log.debug(rs.getString("IsAdmin"));
            return rs.getString("IsAdmin");
        } else {
            return "false";
        }
    }
    
    /**
     * Get pertinent book info
     * @param isbn	of the book to be gotten
     * @return	the info as a string
     */
    protected String getBookInfo(int isbn) throws SQLException {
        String info;
        if(isbn < 0) {
            return null;
        }
        Statement stmt=conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM tblBook WHERE (ISBN=" + isbn + ") LIMIT 1;");
        if(rs.first()) {
            info = "<html>Title: " + rs.getString("title") + "<br>Author: " + rs.getString("author") + "<br>ISBN: " + rs.getString("isbn")  + "<br>Description: <br>" + rs.getString("description");
        } else {
            return "No info found!";
        }
        return info;
    }
    
    
}
