/*
 * @author Colin Larson
 * TO BE COMPLETED
 */

package dbprocess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Book;
import model.Cart;
import model.User;

public class InsertionProcess {
	/* name of the database */
	private static String dbname = "cmpt371group_CTiger";
    
    protected Connection conn;

    private static InsertionProcess instance;
    
    /**
     * Constructor
     */
    protected InsertionProcess() throws SQLException {
        initDatabaseConnection();
    }

    /**
     * Singleton pattern DatabaseProcess init
     * @return	single instance of DatabaseProcess
     */
    public static synchronized InsertionProcess getInstance() {
        if (instance == null) {
            try {
                instance = new InsertionProcess();
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
     * Add a book to a user's rentals
     * @param	u	the user/renter
     * @param 	b	the book to be rented
     */
    //TODO: Change DB tblUserRental so it uses ISBN instead of BookID (?)
    public void addBookToUser(Book b, User u, int rentalID) throws SQLException {
        if(b==null || u==null) {
            return;
        }
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblBook WHERE ISBN=" + b.getBookISBN() + ";");
        if(rs.first()) {
        	stmt.execute("INSERT INTO tblBookRental(RentalID, BookID) VALUES (\"" + rentalID + "\"," + b.getBookISBN() + ");");
        }
    }
    
    /**
     * Add a book to the catalogue
     * @param	b	book to be added to the catalogue
     * @postcond	book has been added to the catalogue if it was not present already
     */
    //TODO: Change TB tblBook to no longer use BookID (?)
    public void addBookToCatalogue(Book b) throws SQLException {
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
    public int createUser(User u) throws SQLException {
        if(u==null) {
            return -1;
        }
        if(stringIsEmpty(u.getUserName()) || stringIsEmpty(u.getPassword())) {
            return -2;
        }
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblUser WHERE UserName=\"" + u.getUserName() + "\";");
        if(rs.first()) {
            return -1;    //value in result set; user already exists
        } else {
        	stmt.execute("INSERT INTO tblUser (UserName, PassWord, IsAdmin) VALUES (\"" + u.getUserName() + "\",\"" + u.getPassword() + "\"," + 0 +");");
        	rs=stmt.executeQuery("SELECT * FROM tblUser WHERE UserName=\"" + u.getUserName() +"\"");
        	stmt.execute("SELECT * FROM tblAccountInfo WHERE UserName=\"" + u.getUserName() +"\"");
        	//DO STUFF HERE
        	//stmt.execute("INSERT INTO tblAccountInfo(UserName, FirstName, LastName, Email, PayInfo) VALUES (\"" 
        	//		+ u.getUserName() + "\",\"" + FirstName + "\",\"" + LastName + "\",\"" + Email + "\",\"" + PayInfo + "\",\"");
        	rs=stmt.executeQuery("SELECT * FROM " + dbname + ".users WHERE users.username=\"" + u.getUserName() +"\";");
            rs.first();
            return 0;
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
    
    /**
     * Save a cart and its contents in the appropriate tables
     * @param c			the cart to be saved
     * @param username	the user for it to be saved to
     * @param shopdate	the date in which it was saved
     */
    //TODO: Change appropriate tables to use ISBN instead of ID (?)
    public void saveShoppingCart(Cart c, String username, Date shopdate) throws SQLException {
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
}
