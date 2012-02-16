package dbprocess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import obj.Book;
import obj.User;

public class GetterProcess extends DatabaseProcess {
	/* name of the database */
    private static String dbname = "cmpt370group04";
    
    private GetterProcess() throws SQLException {
    	super();
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
           	User u = new User(rs.getString("FirstName"), rs.getString("LastName"));
            return u;
        } else {
            return null;
        }
    }
    
    /**
     * Get a list of all the books in the catalogue
     * @return	a list of all the books currently in the catalogue (books table)
     */
    public LinkedList<Book> getCatalogue() throws SQLException {
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblBook ORDER BY Title;");
        if(rs.first()) {
            LinkedList<Book> booklist = new LinkedList<Book>();
            while(!rs.isAfterLast()) {
                Book tmp = new Book(rs.getString("Title"), rs.getString("Author"), rs.getDouble("Price"), rs.getString("Url"), 
                		rs.getString("ISBN"), rs.getInt("BookID"), rs.getString("picURL"), rs.getString("Description"));
                booklist.add(tmp);
                rs.next();
            }
            return booklist;
        } else {	//no books found
            return null;
        }
    }
    
    /**
     * Find books by title (pattern match)
     * @param	title	title to search for
     * @return	a list of books that are exactly or contain the substring in their title field
     */
    public LinkedList<Book> getBookByTitle(String title) throws SQLException {
        if(title==null) {
            return null;
        }
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblBook WHERE Title LIKE \"%" + title + "%\" ORDER BY Title;");
        if (rs.first()) {
            LinkedList<Book> booklist = new LinkedList<Book>();
            while (!rs.isAfterLast()) {
                Book tmp = new Book(rs.getString("Title"), rs.getString("Author"), rs.getDouble("Price"), rs.getString("Url"), 
                		rs.getString("ISBN"), rs.getInt("BookID"), rs.getString("picURL"), rs.getString("Description"));
                booklist.add(tmp);
                rs.next();
            }
            return booklist;
        } else {	//no books found
            return null;
        }
    }
    
    /**
     * Find books by author (pattern match)
     * @param	author	author to search for
     * @return	a list of books that are exactly or contain the substring in their author field
     */
    public LinkedList<Book> getBookByAuthor(String author) throws SQLException {
        if(author==null) {
            return null;
        }
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblBook WHERE Author LIKE \"%" + author + "%\" ORDER BY Title;");
        if (rs.first()) {
            LinkedList<Book> booklist = new LinkedList<Book>();
            while (!rs.isAfterLast()) {
                Book tmp = new Book(rs.getString("Title"), rs.getString("Author"), rs.getDouble("Price"), rs.getString("Url"), 
                		rs.getString("ISBN"), rs.getInt("BookID"), rs.getString("picURL"), rs.getString("Description"));
                booklist.add(tmp);
                rs.next();
            }
            return booklist;
        } else {	//no books found
            return null;
        }
    }
    
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
            		rs.getString("ISBN"), rs.getInt("BookID"), rs.getString("picURL"), rs.getString("Description"));
        } else {	//no book found
            return null;
        }
    }
    
    /**
     * Find a book by ID (exact)
     * @param	ID	ID of the book
     * @return	the book with the given ID if found; otherwise null
     */
    public Book getBookById(int ID) throws SQLException {
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblBook WHERE BookID=" + ID + ";");
        if (rs.first()) {
            return new Book(rs.getString("Title"), rs.getString("Author"), rs.getDouble("Price"), rs.getString("Url"), 
            		rs.getString("ISBN"), rs.getInt("BookID"), rs.getString("picURL"), rs.getString("Description"));
        } else {	//no book found
            return null;
        }
    }
    
    /**
     * Get a list of books being rented by a user
     * @param	u	the user to find the books being rented by
     * @return	a list of books being rented by the given user
     */
    public LinkedList<Book> getBooksByUser(User u) throws SQLException {
        if(u==null) {
            return null;
        }
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM tblUserRental, tblBookRental WHERE tblUserRental.RentalID = tblBookRental.RentalID and tblUserRental.UserName=\"" 
        				+ u.getUserName() + "\";");
        if(rs.first()) {
            LinkedList<Book> booklist = new LinkedList<Book>();
            while (!rs.isAfterLast()) {
                Book tmp = getBookById(rs.getInt("BookID"));
                booklist.add(tmp);
                rs.next();
            }
            return booklist;
        }

        return null;
    }
    
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
     * @param id	of the book to be gotten
     * @return	the info as a string
     */
    public String getBookInfo(int id) throws SQLException {
        String info;
        if(id < 0) {
            return null;
        }
        Statement stmt=conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + dbname + ".books WHERE (books.id=" + id + ") LIMIT 1;");
        if(rs.first()) {
            info = "<html>Title: " + rs.getString("title") + "<br>Author: " + rs.getString("author") + "<br>ISBN: " + rs.getString("isbn")  + "<br>ID: " + rs.getString("id") + "<br>Description: <br>" + rs.getString("description");
        } else {
            return "No info found!";
        }
        return info;
    }
    
    
}
