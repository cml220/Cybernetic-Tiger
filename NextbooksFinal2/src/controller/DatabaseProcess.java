package controller;
import java.util.LinkedList;
import java.sql.*;
import obj.*;

/**
 * @author cml220
 */
public class DatabaseProcess {
	/* name of the database */
	private static String dbname = "cmpt370group04";
	/* connection to the database */
	private Connection conn;
	
	private static DatabaseProcess instance;
	
	/** 
	 * Constructor 
	 */
	private DatabaseProcess() throws SQLException{
		initDatabaseConnection();
	}
	
	/**
	 * Singleton pattern DatabaseProcess init
	 * @return	single instance of DatabaseProcess
	 */
	public static synchronized DatabaseProcess getInstance() {
		if (instance == null) {
			try {
				instance = new DatabaseProcess();
			}
			catch (Exception e) { e.printStackTrace(); }
		}
		return instance;
	}
	
	/**
	 * Initialize a connection to the database
	 * @postcond	connection to the database initialized
	 */
	private void initDatabaseConnection() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url="jdbc:mysql://papyrus.usask.ca/" + dbname + "?user=cmpt370group04&password=74jv1vde";
			conn=DriverManager.getConnection(url);
		}
		catch (Exception e) { e.printStackTrace(); }
	}
	
	/**
	 * Get the image url associated with a single user
	 * @param user	the user whose assoc. img is to be found
	 * @return	the url (as a string) if found, otherwise null
	 */
	public String getUserIMG(String user) throws SQLException{
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT img FROM " + dbname +".users WHERE username=\"" + user + "\" LIMIT 1;");
		if(rs.first()) {
			String img = rs.getString("img");
			return img;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Get a list of all the books in the catalogue
	 * @return	a list of all the books currently in the catalogue (books table)
	 */
	public LinkedList<Book> getCatalogue() throws SQLException{
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM " + dbname + ".books ORDER BY books.title;");
		if(rs.first()) {
			LinkedList<Book> booklist = new LinkedList<Book>();
			while(!rs.isAfterLast()) {
				Book tmp = new Book(rs.getString("title"), rs.getString("author"), rs.getFloat("price"), rs.getString("url"), rs.getString("isbn"), rs.getInt("id"), rs.getString("picURL"), rs.getString("description"));
				booklist.add(tmp);
				rs.next();
			}
			return booklist;
		}
		else {	//no books found
			return null;
		}
	}
	
	/**
	 * Find books by title (pattern match)
	 * @param	title	title to search for
	 * @return	a list of books that are exactly or contain the substring in their title field
	 */
	public LinkedList<Book> getBookByTitle(String title) throws SQLException{
		if(title==null) { return null; }
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM " + dbname + ".books WHERE books.title LIKE \"%" + title + "%\" ORDER BY books.title;");
		if (rs.first()) {
			LinkedList<Book> booklist = new LinkedList<Book>();
			while (!rs.isAfterLast()) {
				Book tmp = new Book(rs.getString("title"), rs.getString("author"), rs.getFloat("price"), rs.getString("url"), rs.getString("isbn"), rs.getInt("id"), rs.getString("picURL"), rs.getString("description"));
				booklist.add(tmp);
				rs.next();
			}
			return booklist;
		}
		else {	//no books found
			return null;
		}
	}
	
	/**
	 * Find books by author (pattern match)
	 * @param	author	author to search for
	 * @return	a list of books that are exactly or contain the substring in their author field
	 */
	public LinkedList<Book> getBookByAuthor(String author) throws SQLException{
		if(author==null) { return null; }
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM " + dbname + ".books WHERE books.author LIKE \"%" + author + "%\" ORDER BY books.title;");
		if (rs.first()) {
			LinkedList<Book> booklist = new LinkedList<Book>();
			while (!rs.isAfterLast()) {
				Book tmp = new Book(rs.getString("title"), rs.getString("author"), rs.getFloat("price"), rs.getString("url"), rs.getString("isbn"), rs.getInt("id"), rs.getString("picURL"), rs.getString("description"));
				booklist.add(tmp);
				rs.next();
			}
			return booklist;
		}
		else {	//no books found
			return null;
		}
	}
	
	/**
	 * Find a book by isbn (exact)
	 * @param	ISBN	ISBN to search for
	 * @return	the book with the given ISBN if found; otherwise null
	 */
	public Book getBookByISBN(String ISBN) throws SQLException{
		if(ISBN==null) { return null; }
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM " + dbname + ".books WHERE books.isbn=\"" + ISBN + "\";");
		if (rs.first()) {
			return new Book(rs.getString("title"), rs.getString("author"), rs.getFloat("price"), rs.getString("url"), rs.getString("isbn"), rs.getInt("id"), rs.getString("picURL"), rs.getString("description"));
		}
		else {	//no book found
			return null;
		}
	}
	
	/**
	 * Find a book by ID (exact)
	 * @param	ID	ID of the book
	 * @return	the book with the given ID if found; otherwise null
	 */
	public Book getBookByID(int ID) throws SQLException{
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM " + dbname + ".books WHERE books.id=" + ID + ";");
		if (rs.first()) {
			return new Book(rs.getString("title"), rs.getString("author"), rs.getFloat("price"), rs.getString("url"), rs.getString("isbn"), rs.getInt("id"), rs.getString("picURL"), rs.getString("description"));
		}
		else {	//no book found
			return null;
		}	
	}
	
	/**
	 * Get a list of books being rented by a user
	 * @param	u	the user to find the books being rented by
	 * @return	a list of books being rented by the given user
	 */
	public LinkedList<Book> getBooksByUser(User u) throws SQLException{
		if(u==null) { return null; }
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM " + dbname + ".userRentals WHERE userRentals.username=\"" + u.getUserName() + "\";");
		if(rs.first()) {
			LinkedList<Book> booklist = new LinkedList<Book>();
			while (!rs.isAfterLast()) {
				Book tmp = getBookByID(rs.getInt("bookID"));
				booklist.add(tmp);
				rs.next();
			}	
			return booklist;
		}
		
		return null;
	}
	
	/**
	 * Add a book to a user's rentals
	 * @param	u	the user/renter
	 * @param 	b	the book to be rented
	 */
	public void addBooktoUser(Book b, User u) throws SQLException{
		if(b==null || u==null) { return; }
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM " + dbname + ".books WHERE books.id=" + b.getBookID() + ";");
		if(rs.first()) {
			stmt.execute("INSERT INTO " + dbname + ".userRentals (username,bookID) VALUES (\"" +
				u.getUserName() + "\"," + b.getBookID() + ");");
		}
	}
	
	/**
	 * Add a book to the catalogue
	 * @param	b	book to be added to the catalogue 
	 * @postcond	book has been added to the catalogue if it was not present already
	 */
	public void addBookToCatalogue(Book b) throws SQLException{	
		if(b==null) { return; }
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM " + dbname + ".books WHERE books.isbn=\"" + b.getBookISBN() + "\";");
		if(rs.first()) { return; }	//book with this isbn already exists
		else {
			stmt.execute("INSERT INTO " + dbname + ".books (title,author,price,url,isbn,id,picURL,description) VALUES (\"" +
				b.getBookTitle() + "\",\"" + b.getBookAuthor() + "\"," + b.getBookPrice() + ",\"" + b.getBookURL() +
				"\",\"" + b.getBookISBN() + "\"," + b.getBookID() + ",\"" + b.getBookPicURL() + "\",\"" + b.getDescription() + "\");");
			rs=stmt.executeQuery("SELECT * FROM " + dbname + ".books WHERE books.isbn=\"" + b.getBookISBN() +"\";");
			rs.first();
		}
	}

	/**
	 * Remove a single book from the catalogue as well as all rentals
	 * @param bookid	the id of the book to be removed
	 */
	public void removeBookFromCatalogue(int bookid) throws SQLException{
		if(bookid < 0) { return; }
		Statement stmt=conn.createStatement();
		Statement stmt2=conn.createStatement();
		stmt.execute("DELETE FROM " + dbname + ".books WHERE books.id=" + bookid + ";");
		stmt2.execute("DELETE FROM " + dbname + ".userRentals WHERE userRentals.bookID=" + bookid + ";");
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
	 * Create a new user for the system
	 * @param	u	user to be added to the system
	 * @postcond	user has been added to the system
	 * @return 		user ID if successful; or -1 (username in use)
	 */
	public int createUser(User u) throws SQLException{
		if(u==null) { return -1; }
		if(stringIsEmpty(u.getUserName()) || stringIsEmpty(u.getPassword())) { return -2; }
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM " + dbname + ".users WHERE users.username=\"" + u.getUserName() + "\";");
		if(rs.first()) { return -1; }	//value in result set; user already exists
		else {
			stmt.execute("INSERT INTO " + dbname + ".users (username,password) VALUES (\"" + u.getUserName() + "\",\"" + u.getPassword() + "\");");
			rs=stmt.executeQuery("SELECT * FROM " + dbname + ".users WHERE users.username=\"" + u.getUserName() +"\";");
			rs.first();
			return 0;
		}
	}
	
	/**
	 * Check to see if a user is registered in the system
	 * @param	userName	the login name to be searched for
	 * @param	password	the password to be searched for
	 * @return 	true if username and password are registered to a user; false otherwise
	 */
	public boolean checkLogin(String username, String password) throws SQLException{
		if(username==null || password==null) { return false; }
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM " + dbname + ".users WHERE (users.username=\"" + username + "\") AND (users.password=\"" + password + "\");");
		if(rs.first()) { return true; }
		else { return false; }
	}
	
	/**
	 * Update a user's profile image
	 * @param	url			the url of the profile image
	 * @param	username	the username of the user
	 */
	public void editUserProfilePic(String url, String username)	throws SQLException{
		if(username==null || url==null) { return; }
		Statement stmt=conn.createStatement();
		stmt.execute("UPDATE users SET users.img=\"" + url + "\" WHERE (users.username=\"" + username + "\");");	
	}
	
	/**
	 * Get the admin status of a user
	 * @param	username	the username of the user
	 */
	public String getAdminStatus(String username) throws SQLException{
		if(username==null) { return "false"; }
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT users.isAdmin FROM " + dbname + ".users WHERE (users.username=\"" + username + "\");");
		if(rs.first()) {
			return rs.getString("isAdmin");
		}
		else {
			return "false";
		}
	}
	
	/**
	 * Get pertinent book info
	 * @param id	of the book to be gotten
	 * @return	the info as a string
	 */
	public String getBookInfo(int id) throws SQLException{
		String info;
		if(id < 0) { return null; }
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM " + dbname + ".books WHERE (books.id=" + id + ") LIMIT 1;");
		if(rs.first()) {
			info = "<html>Title: " + rs.getString("title") + "<br>Author: " + rs.getString("author") + "<br>ISBN: " + rs.getString("isbn")  + "<br>ID: " + rs.getString("id") + "<br>Description: <br>" + rs.getString("description");
		}
		else { return "No info found!"; }
		return info;
	}
}