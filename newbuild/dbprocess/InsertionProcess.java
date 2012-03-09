/*
 * @author Colin Larson
 * TO BE COMPLETED
 */

package dbprocess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exceptions.NoUsernameOrPasswordException;
import exceptions.NullUserException;
import exceptions.UserAlreadyExistsException;

import model.Book;
import model.Cart;
import model.User;

public class InsertionProcess {
	protected Connection conn;
    private static InsertionProcess instance;
    
    /**
     * Constructor
     */
    protected InsertionProcess(Connection conn) throws SQLException {
        this.conn = conn;
    }

    /**
     * Singleton pattern DatabaseProcess init
     * @return	single instance of DatabaseProcess
     */
    public static synchronized InsertionProcess getInstance(Connection conn) {
        if (instance == null) {
            try {
                instance = new InsertionProcess(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
    
	/**
     * Add a book to a user's rentals
     * @param	u	the user/renter
     * @param 	b	the book to be rented
     */
    protected void addBookToUser(int isbn, String username) throws SQLException {
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblBook WHERE ISBN=" + isbn + ";");
        if(rs.next()) {
        	stmt.execute("INSERT INTO tblBookRental(BookISBN, UserName) VALUES (" + isbn + ",\"" + username + "\");");    	
        }
        
    }
    
    /**
     * Add a book to the catalogue
     * @param	b	book to be added to the catalogue
     * @postcond	book has been added to the catalogue if it was not present already
     */
    protected void addBookToCatalogue(Book b) throws SQLException {
        if(b==null) {
            return;
        }
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblBook WHERE ISBN=\"" + b.getBookISBN() + "\";");
        if(rs.first()) {
            return;    //book with this isbn already exists
        } else {
        	stmt.execute("INSERT INTO tblBook (Title,Author,Price,Url,ISBN,picURL,Description) VALUES (\"" 
        			+ b.getBookTitle() + 		"\",\"" + b.getBookAuthor() + "\"," + b.getBookPrice() 
        			+ ",\"" + b.getBookPdfURL() + "\",\"" + b.getBookISBN() + "\",\"" + b.getBookImg() 
        			+ "\",\"" + b.getBookDescription() + "\");");
        	rs=stmt.executeQuery("SELECT * FROM tblBook WHERE ISBN=\"" + b.getBookISBN() +"\";");
            rs.first();
        }
    }
    
    /**
     * Create a new user for the system
     * @param	u	user to be added to the system
     * @postcond	user has been added to the system
     * @return 		user ID if successful; or -1 (username in use)
     */
    protected boolean createUser(User u, String passWord) 
    						throws SQLException, NoUsernameOrPasswordException,
    								NullUserException, UserAlreadyExistsException {
        if(u==null) {
            throw new NullUserException("Null User passed.");
        }
        if(stringIsEmpty(u.getUserName()) || stringIsEmpty(passWord)) {
            throw new NoUsernameOrPasswordException("Please supply both a username and password.");
        }
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblUser WHERE UserName=\"" + u.getUserName() + "\";");
        if(rs.next()) {
            throw new UserAlreadyExistsException("A user with that name already exists.");   //value in result set; user already exists
        } else {
        	stmt.execute("INSERT INTO tblUser (UserName, PassWord, IsAdmin) VALUES (\"" + u.getUserName() + "\",\"" + passWord + "\",\"" + "N" + "\");");
        	stmt.execute("INSERT INTO tblAccountInfo(UserName, FirstName, LastName, Email) VALUES (\"" + u.getUserName() + "\", \"\", \"\",\"" + u.getEmail() +"\")");
        	rs=stmt.executeQuery("SELECT * FROM tblUser WHERE UserName=\"" + u.getUserName() +"\";");
            rs.first();
            return true;
        }
    }    
    
    /**
     * Save a cart and its contents in the appropriate tables
     * @param c			the cart to be saved
     * @param username	the user for it to be saved to
     * @param shopdate	the date in which it was saved
     */
    protected void saveShoppingCart(Cart c, String username, Date shopdate) throws SQLException {
    	Statement stmt=conn.createStatement();
    	stmt.execute("INSERT INTO tblShoppingCart (UserName, ShopDate) VALUES (\"" + username + "\"," + shopdate +")");
    	ResultSet rs=stmt.executeQuery("SELECT * FROM tblShoppingCart WHERE UserName=\"" + username +"\"");
    	rs.first();
    	int cartNum = rs.getInt("CartNumber");
    	
    	ArrayList<Book> cartBooks = c.getCart();
    	
    	for(Book b : cartBooks) {
    		stmt.execute("INSERT INTO tblCartContent (CartNumber, BookISBN) VALUES (" + cartNum + ",\"" + b.getBookISBN() + "\"");
    	}
    }
    
    
    /**
     * Helper method to validate that a string is not empty, null or ""
     * @param str	the string to check
     * @return		true if "not empty", otherwise false
     */
    private boolean stringIsEmpty(String str) {
        if (str == null || str.isEmpty() || str.equals("")) {
            return true;
        }
        return false;
    }
}
