package dbprocess;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import model.Book;
import model.Cart;
import model.User;

import org.junit.Test;

import exceptions.CartException;
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

        try {
            boolean res;
            res = db.createUser("Test", "1234@google.se", "1234");
        //    boolean res2 = db.createUser(null, null, "");
        //    boolean res3 = db.createUser("", "", "");
            //if test run more than once u1 might exist
            assertTrue(res);
            assertTrue(db.checkUser("Test", "1234"));
            log.debug("testCreateUser Passed.");
        } catch (SQLException e) {
            e.printStackTrace();
            log.debug("Stupid exception1.");
         // null or blank case
        } catch (NoUsernameOrPasswordException e2) {
            assertTrue(e2.getMessage().equals("Please supply both a username and password."));
            log.debug("Stupid exception2.");
        } catch (NullUserException e3) {
            assertTrue(e3.getMessage().equals("Null User passed."));
            log.debug("Stupid exception3.");
        } catch (UserAlreadyExistsException e4) {
            assertTrue(e4.getMessage().equals("A user with that name already exists."));
            log.debug("Stupid exception4.");
        } catch (Exception e5) {
            e5.printStackTrace();
            log.debug("Stupid exception5.");
        }

    }

    @Test
    public void testGetUserInfo() throws SQLException {
        log.debug("testGetUserInfo Entered.");
        try {
            // db.createUser(u, "54321");
            User res = db.getUserInfo("Test");
            assertEquals("User Retrival", "Test", res.getUserName());
            log.debug("testGetUserInfo Passed.");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    @Test
    public void testGetUserPassWord() {
        try {
            log.debug("testGetUserPassWord entered.");
            String password = db.getUserPassWord("Test");
            assertTrue(password.equals("1234"));
            log.debug("testGetUserPassWord Passed.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @Test
    public void testGetAdminStatus() throws SQLException {
        log.debug("testGetAdminStatus Entered.");
        try {
            boolean res = db.getAdminStatus("Test");
            assertEquals("isAdmin Status", false, res);
            log.debug("testGetAdminStatus Passed.");
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
        Book b = new Book("THISISAUNIQUESTRING", "THISISAUNIQUESTRING", 1.10, "THISISAUNIQUESTRING", 2309580,"THISISAUNIQUESTRING","THISISAUNIQUESTRING");
        try {
            db.addBookToCatalogue(b);
            log.debug("testAddBookToCatalogue Passed.");
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
            log.debug("testAddBookToUser Passed.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testShoppingCart() throws SQLException, CartException {
        log.debug("testShoppingCart Entered.");
        User res = db.getUserInfo("Test");
        res.cart.add(db.getBookByIsbn(2309580));
        db.saveShoppingCart(res.cart, res.getUserName(),  "2012-02-27");
        Cart c = db.getUserCart("Test");
        assertTrue(c.get(0).getBookISBN() == 2309580);
        db.removeShoppingCart("Test");
        c = db.getUserCart("Test");
        assertTrue(c == null);
        log.debug("testShoppingCart Passed.");

    }
    
    @Test
    public void testUserHasBook() {
        try {
            log.debug("testUserHasBook Entered.");
            boolean res = db.userHasBook("Test", 2309580);
            assertTrue(res);
            log.debug("testUserHasBook Passed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetCatalogue() {
        log.debug("testGetCatalogue Entered.");
        try {
            ArrayList<Book> booklist = db.getBooksBy(DatabaseProcess.CATALOGUE, "");;
            assertTrue(!booklist.isEmpty());
            log.debug("testGetCatalogue Passed.");

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
            log.debug("testGetBookByTitle Entered.");
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
            log.debug("testGetBookByAuthor Passed.");

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
            log.debug("testGetBookByIsbn Passed.");
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
            log.debug("testGetBooksByUser Passed.");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testRemoveBookFromUser() {
        try {
            log.debug("testRemoveBookFromUser Entered.");

            boolean res = db.removeBookFromUser("Test", 2309580);
            assertTrue(res);
            res = db.userHasBook("Test", 2309580);
            assertFalse(res);
            log.debug("testRemoveBookFromUser Passed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRemoveBookFromCatalogue() {
        log.debug("testRemoveBookFromCatalogue Entered.");
        Book b;
        try {
            b = db.getBookByIsbn(2309580);
            db.removeBookFromCatalogue(b.getBookISBN());
            b = db.getBookByIsbn(2309580);
            assertTrue(b == null);
            log.debug("testRemoveBookFromCatalogue Passed.");
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
            assertTrue(res);
            res = db.checkUser("Test2", "wrong");
            assertFalse(res);
            log.debug("testCheckLogin Passed.");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testIsNameAvailable() {
        log.debug("testCheckNameAvailable Entered.");
        boolean res;
        try {
            res = db.isNameAvailable("Test2");
            assertTrue(res);
            res = db.isNameAvailable("Test");
            assertFalse(res);
            log.debug("testCheckNameAvailable Entered.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testEditUserInfo() throws SQLException, Exception {
        log.debug("testEditUserInfo Entered.");
        User u = db.getUserInfo("Test");
        u.email = "newEmail@microsuck.biz";
        db.editUserInfo(u, "1234", "4321");
        assertTrue(db.getUserInfo("Test").email.equals("newEmail@microsuck.biz") );
        log.debug("testEditUserInfo Passed.");

    }
    
    @Test
    public void testRemoveUser() {
        log.debug("testRemoveUser Entered");
        boolean res;
        try {
            res = db.isNameAvailable("Test");
            assertFalse(res);
            res = db.removeUser("Test");
            assertTrue(res);
            res = db.isNameAvailable("Test");
            assertTrue(res);
            log.debug("testRemoveUser Entered");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }    
    }
}