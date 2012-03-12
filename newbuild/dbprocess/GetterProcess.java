/*
 * @author Colin Larson
 * TO BE COMPLETED
 */

package dbprocess;

import java.sql.Connection;
import org.apache.log4j.Logger;

import exceptions.CartException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Book;
import model.Cart;
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
     * Admin only. Return password of a given user.
     * @param userName		User whose password is needed
     * @return				User password
     */
    protected String getUserPassWord(String userName) throws SQLException {
    	Statement stmt = conn.createStatement();
    	ResultSet rs = stmt.executeQuery("SELECT PassWord FROM tblUser WHERE UserName = \"" + userName + "\"");
    	if(rs.next()) {
    		return rs.getString("PassWord");
    	}
    	return null;
    }
    
    protected Cart getUserCart(String userName) throws SQLException, CartException {
    	Cart c = new Cart();
    	DatabaseProcess db = DatabaseProcess.getInstance();
    	Statement stmt = conn.createStatement();
    	ResultSet rs = stmt.executeQuery("SELECT CartNumber FROM tblShoppingCart WHERE UserName = \"" + userName + "\"");
    	if(rs.next()) {
    		ResultSet rs2 = stmt.executeQuery("SELECT BookISBN FROM tblCartContent WHERE CartNumber = " + rs.getInt("CartNumber"));
    		if(rs2.next()) {
    			Book b = db.getBookByIsbn(rs2.getLong("BookISBN"));
    			c.add(b);
    			while(rs2.next()) {
    				c.add((db.getBookByIsbn(rs2.getLong("BookISBN"))));
    			}
    		}
       	}
    	else {
    		return null;
    	}
    	return c;
    }
  
    /**
     * Find books by specified query, using specific option
     * @param	option	Define parameters of search (eg. search by DatabaseProcess.{AUTHOR,TITLE,USERNAME,CATALOGUE}
     * @param	query	Define what to search for.
     * @return			A list of books that satisfy the search parameters.
     * To get books by title: db.getBookBy(DatabaseProcess.TITLE, "A Clockwork Orange");
     * To get books by Author: db.getBookBy(DatabaseProcess.AUTHOR, "Bob Loblaw");
     * To get a user's book library: db.getBookBy(DatabaseProcess.USERNAME, "colin");
     * To get entire catalogue: db.getBookBy(DatabaseProcess.CATALOGUE, "");
     */  
	protected ArrayList<Book> getBooksBy(int option, String query) throws SQLException {
    	ResultSet rs = null;
    	Statement stmt = conn.createStatement();
    	if(option==DatabaseProcess.AUTHOR && !query.equals("")) {
    		rs = stmt.executeQuery("SELECT * FROM tblBook WHERE Author LIKE \"%" + query + "%\" ORDER BY Title;");
    	}
    	else if(option==DatabaseProcess.TITLE && !query.equals("")) {
    		rs = stmt.executeQuery("SELECT * FROM tblBook WHERE Title LIKE \"%" + query + "%\" ORDER BY Title;");
    	}
    	else if(option==DatabaseProcess.USERNAME && !query.equals("")) {
    		rs=stmt.executeQuery("SELECT tblBook.* FROM tblBook, tblBookRental WHERE tblBook.ISBN=tblBookRental.BookISBN AND tblBookRental.UserName=\"" + query + "\";");
    	}
    	else if(option==DatabaseProcess.CATALOGUE && query.equals("")) {
    		rs = stmt.executeQuery("SELECT * FROM tblBook ORDER BY Title;");
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
    protected Book getBookByIsbn(long isbn) throws SQLException {
        if(isbn<0) {
            return null;
        }
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblBook WHERE ISBN=" + isbn + ";");
        if (rs.next()) {
            return new Book(rs.getString("Title"), rs.getString("Author"), rs.getDouble("Price"), rs.getString("Url"), 
            		rs.getInt("ISBN"), rs.getString("picURL"), rs.getString("Description"));
        } else {	//no book found
            return null;
        }
    }
    
    /**
     * Get the admin status of a user
     * @param	username	the username of the user
     */
    protected boolean getAdminStatus(String username) throws SQLException {
        if(username==null) {
            return false;
        }
        Statement stmt=conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT IsAdmin FROM tblUser WHERE UserName=\"" + username + "\";");
        if(rs.next()) {
        	return rs.getBoolean("IsAdmin");
        } else {
            return false;
        }
    }
    
    /**
     * Get pertinent book info
     * @param isbn	of the book to be gotten
     * @return	the info as a string
     */
    protected String getBookInfo(long isbn) throws SQLException {
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
