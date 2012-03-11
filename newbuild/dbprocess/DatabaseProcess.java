package dbprocess;
import java.util.ArrayList;
import java.sql.*;

import model.*;

/**
 * @author cml220
 */
public class DatabaseProcess {
	public static int AUTHOR = 0;
	public static int TITLE = 1;
	public static int USERNAME = 2;
	public static int CATALOGUE = 3;
	
	/* name of the database */
	private static String dbname = "cmpt371group_CTiger";  
    private static DatabaseProcess instance;
    private Connection conn;

    public DatabaseProcess() throws SQLException {
    	initDatabaseConnection();
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
     * Singleton pattern DatabaseProcess init
     * @return	single instance of DatabaseProcess
     */
    public static synchronized DatabaseProcess getInstance() {
        if (instance == null) {
            try {
                instance = new DatabaseProcess();
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
    public User getUserInfo(String user) throws SQLException {
    	GetterProcess db = GetterProcess.getInstance(conn);
        return db.getUserInfo(user);
    }

    /**
     * Find books by specified query, using specific option
     * @param	option	Define parameters of search (eg. search by DBConsts.{AUTHOR,TITLE,USERNAME,CATALOGUE}
     * @param	query	Define what to search for.
     * @return			A list of books that satisfy the search parameters.
     */
    public ArrayList<Book> getBooksBy(int option, String query) throws SQLException {
    	GetterProcess db = GetterProcess.getInstance(conn);
    	return db.getBooksBy(option, query);
    }
    
    /**
     * Find a book by isbn (exact)
     * @param	ISBN	ISBN to search for
     * @return	the book with the given ISBN if found; otherwise null
     */
    public Book getBookByIsbn(int isbn) throws SQLException {
    	GetterProcess db = GetterProcess.getInstance(conn);
        return db.getBookByIsbn(isbn);
    }
    
    /**
     * Get the admin status of a user
     * @param	username	the username of the user
     * @return	true if the user is an admin; false otherwise
     */
    public boolean getAdminStatus(String username) throws SQLException {
    	GetterProcess db = GetterProcess.getInstance(conn);
        return db.getAdminStatus(username);
    }

    /**
     * Get pertinent book info
     * @param isbn	of the book to be gotten
     * @return	the info as a string
     */
    public String getBookInfo(int isbn) throws SQLException {
    	GetterProcess db = GetterProcess.getInstance(conn);
        return db.getBookInfo(isbn);
    }

    /**
     * Add a book to a user's rentals
     * @param	u	the user/renter
     * @param 	b	the book to be rented
     */
    public void addBookToUser(int isbn, String username) throws SQLException {
    	InsertionProcess db = InsertionProcess.getInstance(conn);
        db.addBookToUser(isbn, username);
    }

    /**
     * Add a book to the catalogue
     * @param	b	book to be added to the catalogue
     * @postcond	book has been added to the catalogue if it was not present already
     */
    public void addBookToCatalogue(Book b) throws SQLException {
    	InsertionProcess db = InsertionProcess.getInstance(conn);
        db.addBookToCatalogue(b);
    }

    /**
     * Remove a single book from the catalogue as well as all rentals
     * @param bookid	the id of the book to be removed
     */
    public void removeBookFromCatalogue(int bookid) throws SQLException {
    	RemovalProcess db = RemovalProcess.getInstance(conn);
        db.removeBookFromCatalogue(bookid);
    }

    /**
     * Create a new user for the system
     * @param	u		user to be added to the system
     * @param password	password to be given to user
     * @postcond	user has been added to the system
     * @return 		true if successful, exception thrown if not for any reason
     */
    public boolean createUser(User u, String password) throws Exception {
    	InsertionProcess db = InsertionProcess.getInstance(conn);
        return db.createUser(u, password);
    }
    
    /**
     * Save a cart and its contents in the appropriate tables
     * @param c			the cart to be saved
     * @param username	the user for it to be saved to
     * @param shopdate	the date in which it was saved
     */
    public void saveShoppingCart(Cart c, String username, Date shopdate) throws SQLException {
    	InsertionProcess db = InsertionProcess.getInstance(conn);
    	db.saveShoppingCart(c, username, shopdate);
    }

    /**
     * Update a user
     * @param username		the username of the user
     * @param user			the actual user to modify
     */
    public void editUserInfo(String username, User user) throws Exception {
    	ModificationProcess db = ModificationProcess.getInstance(conn);
        db.editUserInfo(username, user);
    }
    
    /**
     * Remove a user from the db
     * @param username	the user to be removed
     * @return true		if the user has been removed; false otherwise
     */
    public boolean removeUser(String username) throws SQLException {
    	RemovalProcess db = RemovalProcess.getInstance(conn);
    	return db.removeUser(username);
    }
    
    /**
     * Remove a book from a user's rentals
     * @param username	the user
     * @param isbn		the book to be removed from the user
     * @return true		if the book has been removed from the user; false otherwise
     */
    public boolean removeBookFromUser(String username, int isbn) throws SQLException {
    	RemovalProcess db = RemovalProcess.getInstance(conn);
    	return db.removeBookFromUser(username, isbn);
    }

    /**
     * Check if a user with the given login info is registered
     * @param username  the login name to be searched for
     * @param password	the password to be searched for
     * @return	true if a user with that info is registered; false otherwise
     */
	public boolean checkUser(String username, String password) throws SQLException {
		VerificationProcess db = VerificationProcess.getInstance(conn);
		return db.checkUser(username, password);
	}
	
	/**
     * is the provided username available?
     * @param username	the username to search for
     * @return	true if the username is available; false otherwise
     */
    public boolean isNameAvailable(String username) throws SQLException {
    	VerificationProcess db = VerificationProcess.getInstance(conn);
		return db.isNameAvailable(username);
    }
	
	/**
     * Check if a user has a book in their rentals
     * @param username	the user to check
     * @param isbn		the book to check for
     * @return	true 	if the user has the book; false otherwise
     */
    public boolean userHasBook(String username, int isbn) throws SQLException {
    	VerificationProcess db = VerificationProcess.getInstance(conn);
		return db.userHasBook(username, isbn);
    }
}