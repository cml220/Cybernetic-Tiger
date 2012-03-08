package dbprocess;
import java.util.ArrayList;
import java.sql.*;

import model.*;

/**
 * @author cml220
 */
public class DatabaseProcess {

    private static DatabaseProcess instance;

    private DatabaseProcess() {
    	// wat
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
     * Get the image url associated with a single user
     * @param user	the user whose assoc. img is to be found
     * @return	the url (as a string) if found, otherwise null
     */
    public User getUserInfo(String user) throws SQLException {
    	GetterProcess db = GetterProcess.getInstance();
        return db.getUserInfo(user);
    }

    /**
     * Find books by specified query, using specific option
     * @param	option	Define parameters of search (eg. search by Title, Author, Username or Catalogue)
     * @param	query	Define what to search for.
     * @return			A list of books that satisfy the search parameters.
     */
    public ArrayList<Book> getBooksBy(String option, String query) throws SQLException {
    	GetterProcess db = GetterProcess.getInstance();
    	return db.getBooksBy(option, query);
    }
    
    /**
     * Find a book by isbn (exact)
     * @param	ISBN	ISBN to search for
     * @return	the book with the given ISBN if found; otherwise null
     */
    public Book getBookByIsbn(String isbn) throws SQLException {
    	GetterProcess db = GetterProcess.getInstance();
        return db.getBookByIsbn(isbn);
    }
    
    /**
     * Get the admin status of a user
     * @param	username	the username of the user
     */
    public String getAdminStatus(String username) throws SQLException {
    	GetterProcess db = GetterProcess.getInstance();
        return db.getAdminStatus(username);
    }

    /**
     * Get pertinent book info
     * @param id	of the book to be gotten
     * @return	the info as a string
     */
    public String getBookInfo(int id) throws SQLException {
    	GetterProcess db = GetterProcess.getInstance();
        return db.getBookInfo(id);
    }

    /**
     * Add a book to a user's rentals
     * @param	u	the user/renter
     * @param 	b	the book to be rented
     */
    public void addBookToUser(String isbn, String username, int rentalId) throws SQLException {
    	InsertionProcess db = InsertionProcess.getInstance();
        db.addBookToUser(isbn, username, rentalId);
    }

    /**
     * Add a book to the catalogue
     * @param	b	book to be added to the catalogue
     * @postcond	book has been added to the catalogue if it was not present already
     */
    public void addBookToCatalogue(Book b) throws SQLException {
    	InsertionProcess db = InsertionProcess.getInstance();
        db.addBookToCatalogue(b);
    }

    /**
     * Remove a single book from the catalogue as well as all rentals
     * @param bookid	the id of the book to be removed
     */
    public void removeBookFromCatalogue(int bookid) throws SQLException {
    	RemovalProcess db = RemovalProcess.getInstance();
        db.removeBookFromCatalogue(bookid);
    }

    /**
     * Create a new user for the system
     * @param	u	user to be added to the system
     * @postcond	user has been added to the system
     * @return 		user ID if successful; or -1 (username in use)
     */
    public int createUser(User u) throws SQLException {
    	InsertionProcess db = InsertionProcess.getInstance();
        return db.createUser(u);
    }
    
    /**
     * Save a cart and its contents in the appropriate tables
     * @param c			the cart to be saved
     * @param username	the user for it to be saved to
     * @param shopdate	the date in which it was saved
     */
    public void saveShoppingCart(Cart c, String username, Date shopdate) throws SQLException {
    	InsertionProcess db = InsertionProcess.getInstance();
    	db.saveShoppingCart(c, username, shopdate);
    }

    /**
     * DEPRECATED (DO NOT USE)
     * Check to see if a user is registered in the system
     * @param	userName	the login name to be searched for
     * @param	password	the password to be searched for
     * @return 	true if username and password are registered to a user; false otherwise
     */
    public boolean checkLogin(String username, String password) throws SQLException {
    	VerificationProcess db = VerificationProcess.getInstance();
        return db.checkLogin(username, password);
    }
    
    /**
     * DEPRECATED (DO NOT USE)
     * Check to see if a username is in use in the system
     * @param	userName	the login name to be searched for
     * @return 	true if username is available; false otherwise
     */
    public boolean checkNameAvailable(String username) throws SQLException {
    	VerificationProcess db = VerificationProcess.getInstance();
        return db.checkNameAvailable(username);
    }

    /**
     * DEPRECATED (DO NOT USE)
     * Update a user's profile image
     * @param	url			the url of the profile image
     * @param	username	the username of the user
     */
    public void editUserProfilePic(String url, String username)	throws SQLException {
    	ModificationProcess db = ModificationProcess.getInstance();
        db.editUserProfilePic(url, username);
    }

    /**
     * Update a user
     * @param username		the username of the user
     * @param user			the actual user to modify
     */
    public void editUserInfo(String username, User user)	throws SQLException {
    	ModificationProcess db = ModificationProcess.getInstance();
        db.editUserInfo(username, user);
    }
}