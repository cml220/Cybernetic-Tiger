/*
 * @author Colin Larson
 * TO BE COMPLETED
 */

package dbprocess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Book;
import model.User;

public class GetterProcess {
	/* name of the database */
	private static String dbname = "cmpt371group_CTiger";
    
    protected Connection conn;

    private static GetterProcess instance;
    
    /**
     * Constructor
     */
    protected GetterProcess() throws SQLException {
        initDatabaseConnection();
    }

    /**
     * Singleton pattern DatabaseProcess init
     * @return	single instance of DatabaseProcess
     */
    public static synchronized GetterProcess getInstance() {
        if (instance == null) {
            try {
                instance = new GetterProcess();
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
     * Get the image url associated with a single user
     * @param user	the user whose assoc. img is to be found
     * @return	the url (as a string) if found, otherwise null
     */
    public User getUserInfo(String username) throws SQLException {
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblAccountInfo WHERE UserName = " + "\"" + username + "\"");
        if(rs.first()) {
           	User u = new User(rs.getString("FirstName"), false, rs.getString("email"));
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
     * To get entire catalogue: db.getBookBy("Catalogue", null);
     */  
    public ArrayList<Book> getBooksBy(String option, String query) throws SQLException {
    	ResultSet rs = null;
    	if(option.equals(null))
    		return null;
    	if(query.equals(null) && !option.equals("Catalogue"))
    		return null;
    	Statement stmt = conn.createStatement();
    	if(option.equals("Author")) {
    		rs = stmt.executeQuery("SELECT * FROM tblBook WHERE Author LIKE \"%" + query + "%\" ORDER BY Title;");
    	}
    	if(option.equals("Title")) {
    		rs = stmt.executeQuery("SELECT * FROM tblBook WHERE Title LIKE \"%" + query + "%\" ORDER BY Title;");
    	}
    	if(option.equals("Catalogue")) {
    		rs = stmt.executeQuery("SELECT * FROM tblBook WHERE Catalogue LIKE \"%" + query + "%\" ORDER BY Title;");
    	}
    	if(option.equals("Username")) {
    		rs=stmt.executeQuery("SELECT * FROM tblUserRental, tblBookRental WHERE tblUserRental.RentalID = tblBookRental.RentalID and tblUserRental.UserName=\"" 
    								+ query + "\";");
    	}
    	ArrayList<Book> bookList = new ArrayList<Book>();
    	while(rs.next()) {
    		bookList.add(new Book(rs.getString("Title"), rs.getString("Author"), rs.getDouble("Price"), rs.getString("Url"), rs.getInt("ISBN"), rs.getString("picUrl"), rs.getString("Description")));
    	}
    	if(bookList.size() == 0)
    		return null;
    	return bookList;    		
    }
    
    
    //Possibly depreciated
    /* public ArrayList<Book> getBookByTitle(String title) throws SQLException {
        if(title==null) {
            return null;
        }
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblBook WHERE Title LIKE \"%" + title + "%\" ORDER BY Title;");
        if (rs.first()) {
            ArrayList<Book> booklist = new ArrayList<Book>();
            while (!rs.isAfterLast()) {
                Book tmp = new Book(rs.getString("Title"), rs.getString("Author"), rs.getDouble("Price"), rs.getString("Url"), 
                		rs.getString("ISBN"), rs.getString("picURL"), rs.getString("Description"));
                booklist.add(tmp);
                rs.next();
            }
            return booklist;
        } else {	//no books found
            return null;
        }
    }
    */
    
    //Possibly depreciated
    /*
    public ArrayList<Book> getCatalogue() throws SQLException {
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblBook ORDER BY Title;");
        if(rs.first()) {
            ArrayList<Book> booklist = new ArrayList<Book>();
            while(!rs.isAfterLast()) {
                Book tmp = new Book(rs.getString("Title"), rs.getString("Author"), rs.getDouble("Price"), rs.getString("Url"), 
                		rs.getString("ISBN"), rs.getString("picURL"), rs.getString("Description"));
                booklist.add(tmp);
                rs.next();
            }
            return booklist;
        } else {	//no books found
            return null;
        }
    }
    */
    
    
    
    //Possibly depreciated
    /*
    public ArrayList<Book> getBookByAuthor(String author) throws SQLException {
        if(author==null) {
            return null;
        }
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblBook WHERE Author LIKE \"%" + author + "%\" ORDER BY Title;");
        if (rs.first()) {
            ArrayList<Book> booklist = new ArrayList<Book>();
            while (!rs.isAfterLast()) {
                Book tmp = new Book(rs.getString("Title"), rs.getString("Author"), rs.getDouble("Price"), rs.getString("Url"), 
                		rs.getString("ISBN"), rs.getString("picURL"), rs.getString("Description"));
                booklist.add(tmp);
                rs.next();
            }
            return booklist;
        } else {	//no books found
            return null;
        }
    }
    */
    
    /**
     * Find a book by isbn (exact)
     * @param	ISBN	ISBN to search for
     * @return	the book with the given ISBN if found; otherwise null
     */
    public Book getBookByIsbn(String isbn) throws SQLException {
        if(isbn==null) {
            return null;
        }
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblBook WHERE ISBN=\"" + isbn + "\";");
        if (rs.first()) {
            return new Book(rs.getString("Title"), rs.getString("Author"), rs.getDouble("Price"), rs.getString("Url"), 
            		rs.getInt("ISBN"), rs.getString("picURL"), rs.getString("Description"));
        } else {	//no book found
            return null;
        }
    }
    
    //Possibly depreciated
    /*
    public ArrayList<Book> getBooksByUser(User u) throws SQLException {
        if(u==null) {
            return null;
        }
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblUserRental, tblBookRental WHERE tblUserRental.RentalID = tblBookRental.RentalID and tblUserRental.UserName=\"" 
        				+ u.getUserName() + "\";");
        if(rs.first()) {
            ArrayList<Book> booklist = new ArrayList<Book>();
            while (!rs.isAfterLast()) {
                Book tmp = getBookById(rs.getInt("BookID"));
                booklist.add(tmp);
                rs.next();
            }
            return booklist;
        }

        return null;
    }
    */
    
    /**
     * Get the admin status of a user
     * @param	username	the username of the user
     */
    public String getAdminStatus(String username) throws SQLException {
        if(username==null) {
            return "false";
        }
        Statement stmt=conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT IsAdmin FROM tblUser WHERE UserName=\"" + username + "\";");
        if(rs.first()) {
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
    public String getBookInfo(int isbn) throws SQLException {
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
