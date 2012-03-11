package dbprocess;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import model.Book;
import model.User;

import org.junit.Test;

import exceptions.NoUsernameOrPasswordException;
import exceptions.NullUserException;
import exceptions.UserAlreadyExistsException;

public class DatabaseProcessJUnit {
	
	private DatabaseProcess db = DatabaseProcess.getInstance();
	Logger log = Logger.getLogger(DatabaseProcessJUnit.class);
	/**
	 * Test cases for User based database operations.
	 * @throws SQLException 
	 */
	@Test
	public void testCreateUser() throws SQLException {
		log.debug("testCreateUser Entered.");
		User u = new User("Test", false, "1234@google.se");
		User u2 = new User(null, false, null);
		User u3 = new User("", false, "");
		try {
			boolean res = db.createUser(u, "1234");
			log.debug(res);
			boolean res2 = db.createUser(u2, "");
			log.debug(res2);
			boolean res3 = db.createUser(u3, "");
			log.debug(res3);
			assertTrue(res);	//if test run more than once u1 might exist
			assertTrue(db.checkUser(u.getUserName(), "1234"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoUsernameOrPasswordException e2) {	// null or blank case
			assertTrue(e2.getMessage().equals("Please supply both a username and password."));
		} catch (NullUserException e3) {
			assertTrue(e3.getMessage().equals("Null User passed."));
		} catch (UserAlreadyExistsException e4) {
			assertTrue(e4.getMessage().equals("A user with that name already exists."));
		} catch (Exception e5) {
			e5.printStackTrace();
		}
		
	}
	
	@Test
	public void testGetUserInfo() throws SQLException {
		log.debug("testGetUserInfo Entered.");
		User u = new User("Test", false, "1234@google.se");
		try {
			// db.createUser(u, "54321");
			User res = db.getUserInfo("Test");
			assertEquals("User Retrival", u.getUserName(), res.getUserName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testGetAdminStatus() throws SQLException {
		log.debug("testGetAdminStatus Entered.");
		User u = new User("Test", false, "1234@google.se");
		try {
			User res = db.getUserInfo("Test");
			assertEquals("isAdmin Status", u.isAdmin, res.isAdmin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Test Cases for Book based database operation
	 */
	@Test
	public void testAddBookToCatalogue() {
		log.debug("testAddBookToCatalogue Entered.");
		Book b = new Book("THISISAUNIQUESTRING","THISISAUNIQUESTRING", 1.10,"THISISAUNIQUESTRING", 2309580,"THISISAUNIQUESTRING","THISISAUNIQUESTRING");
		try {
			db.addBookToCatalogue(b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddBookToUser() {
		log.debug("testAddBookToUser Entered.");
		Book b = new Book("THISISAUNIQUESTRING","THISISAUNIQUESTRING", 1.10,"THISISAUNIQUESTRING", 2309580,"THISISAUNIQUESTRING","THISISAUNIQUESTRING");
		try {
			db.addBookToUser(b.getBookISBN(), "Test");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetCatalogue() {
		log.debug("testGetCatalogue Entered.");
		try {
			ArrayList<Book> booklist = db.getBooksBy(DatabaseProcess.CATALOGUE, "");
			
			log.debug("hello" + booklist.size());
			assertTrue(!booklist.isEmpty());
		} catch (SQLException e) {
			log.error("MYSQL Error");
			e.printStackTrace();
		}
	}

	@Test
	public void testGetBookByTitle() {
		log.debug("testGetBookByTitle Entered.");
		ArrayList<Book> booklist;
		try {
			booklist = db.getBooksBy(DatabaseProcess.TITLE, "THISISAUNIQUESTRING");
			assertTrue(!booklist.isEmpty());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Test
	public void testGetBookByAuthor() {
		log.debug("testGetBookByAuthor Entered.");
		ArrayList<Book> booklist;
		try {
			booklist = db.getBooksBy(DatabaseProcess.AUTHOR, "THISISAUNIQUESTRING");
			assertTrue(!booklist.isEmpty());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetBookByIsbn() {
		log.debug("testGetBookByIsbn Entered.");
		Book b = new Book("THISISAUNIQUESTRING","THISISAUNIQUESTRING",(float) 1.10,"THISISAUNIQUESTRING", 2309580,"THISISAUNIQUESTRING","THISISAUNIQUESTRING");
		Book found;
		try {
			found = db.getBookByIsbn(2309580);
			assertTrue(found != null);
            assertTrue(found.equals(b));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Test
	public void testGetBooksByUser() throws SQLException {
		log.debug("testGetBooksByUser Entered.");
		ArrayList<Book> booklist = new ArrayList<Book>();
		User u = new User("Test", false, "1234@google.se");
		try {
			booklist = db.getBooksBy(DatabaseProcess.USERNAME, u.getUserName());
			assertTrue(!booklist.isEmpty());
			assertTrue(booklist.size() == 1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	@Test
	public void testRemoveBookFromCatalogue() {
		log.debug("testRemoveBookFromCatalogue Entered.");
		Book b;
		try {
			b = db.getBookByIsbn(2309580);
			log.debug(b.getBookAuthor());
			db.removeBookFromCatalogue(b.getBookISBN());
			b = db.getBookByIsbn(2309580);
			assertTrue(b == null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 *  Test cases for VerificationProcess database operations.
	 */
	@Test
	public void testCheckLogin() {
		log.debug("testCheckLogin Entered.");
		boolean res;
		try {
			res = db.checkUser("Test", "1234");
			log.debug(res);
			assertTrue(res);
			res = db.checkUser("Test2", "wrong");
			assertFalse(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testCheckNameAvailable() {
		log.debug("testCheckNameAvailable Entered.");
		boolean res;
		try {
			res = db.checkUser("Test2", null);
			assertTrue(res);
			res = db.checkUser("Test", null);
			assertFalse(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRemoveUser() {
		log.debug("testRemoveUser Entered");
		boolean res;
		try {
			res = db.checkUser("Test", null);
			assertFalse(res);
			res = db.removeUser("Test");
			assertFalse(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}