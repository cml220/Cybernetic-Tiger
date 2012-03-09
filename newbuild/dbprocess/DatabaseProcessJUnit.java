package dbprocess;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import model.Book;
import model.User;

import org.junit.Test;

public class DatabaseProcessJUnit {

	private DatabaseProcess db = DatabaseProcess.getInstance();
	Logger log = Logger.getLogger(DatabaseProcessJUnit.class);
	/**
	 * Test cases for User based database operations.
	 */
	@Test
	public void testCreateUser() {
		log.debug("testCreateUser Entered.");
		User u = new User("Test", false, "1234@google.se");
		User u2 = new User(null, false, null);
		User u3 = new User("", false, "");
		try {
			int res = db.createUser(u, "1234");
			log.debug(res);
			int res2 = db.createUser(u2, "");
			log.debug(res2);
			int res3 = db.createUser(u3, "");
			log.debug(res3);
			assertTrue(res == 0 || res == -1);	//if test run more than once u1 might exist
	        assertTrue(res2 == -2);					//the null case
	        assertTrue(res3 == -2);					//the blank case
			assertTrue(db.checkLogin(u.getUserName(), "1234"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testGetUserInfo() {
		log.debug("testGetUserInfo Entered.");
		User u = new User("Test", false, "1234@google.se");
		try {
			db.createUser(u, "54321");
			User res = db.getUserInfo("Test");
			assertEquals("User Retrival", u.getUserName(), res.getUserName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testGetAdminStatus() {
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
			db.addBookToUser(String.valueOf(b.getBookISBN()), "Test", 7);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetCatalogue() {
		log.debug("testGetCatalogue Entered.");
		try {
			ArrayList<Book> booklist = db.getBooksBy("Catalogue", "");
			
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
			booklist = db.getBooksBy("Title", "THISISAUNIQUESTRING");
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
			booklist = db.getBooksBy("Author", "THISISAUNIQUESTRING");
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
			found = db.getBookByIsbn("2309580");
			assertTrue(found != null);
            assertTrue(found.equals(b));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Test
	public void testGetBooksByUser() {
		log.debug("testGetBooksByUser Entered.");
		ArrayList<Book> booklist = new ArrayList<Book>();
		User u = new User("Test", false, "1234@google.se");
		try {
			booklist = db.getBooksBy("Username", u.getUserName());
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
			b = db.getBookByIsbn("2309580");
			log.debug(b.getBookAuthor());
			db.removeBookFromCatalogue(b.getBookISBN());
			b = db.getBookByIsbn("2309580");
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
			res = db.checkUser("Test2", "");
			assertTrue(res);
			res = db.checkUser("Test", "");
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
			res = db.checkUser("Test", "");
			assertFalse(res);
			db.removeUser("Test");
			res = db.checkUser("Test", "");
			assertTrue(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}