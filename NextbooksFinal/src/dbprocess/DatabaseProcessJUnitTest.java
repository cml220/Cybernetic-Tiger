package dbprocess;

import static org.junit.Assert.*;

import java.util.LinkedList;

import obj.Book;
import obj.User;
import org.junit.Test;

public class DatabaseProcessJUnitTest {
    private DatabaseProcess db;
    private User u1;
    private String teststr = "THISISAUNIQUESTRING";
    private String isbn = "2309580932902385";

    public void setUp() {
        db = DatabaseProcess.getInstance();
    }

    @Test
    public void testCreateUser() {
        try {
            u1 = new User("OHAI", "watdat");
            User u2 = new User(null, null);
            User u3 = new User("", "");
            int res1 = db.createUser(u1);
            int res2 = db.createUser(u2);
            int res3 = db.createUser(u3);

            assertTrue(res1 == 0 || res1 == -1);	//if test run more than once u1 might exist
            assertTrue(res2 == -2);					//the null case
            assertTrue(res3 == -3);					//the blank case

            //test checkLogin as well
            assertTrue(db.checkLogin(u1.getUserName(), u1.getPassword()));
            assertFalse(db.checkLogin(u2.getUserName(), u2.getPassword()));
            assertFalse(db.checkLogin(u3.getUserName(), u3.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAdminStatus() {
        try {
            assertFalse(db.getAdminStatus("OHAI") == "false");
            assertTrue(db.getAdminStatus("colin") == "true");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBookDBMethods() {
        Book b = new Book(teststr,teststr,(float) 1.10,teststr,isbn,teststr,teststr);
        try {
            // normal cases
            db.addBookToCatalogue(b);
            db.addBookToUser(b, u1);

            LinkedList<Book> booklist= db.getCatalogue();
            assertTrue(!booklist.isEmpty());
            booklist = db.getBookByAuthor(teststr);
            assertTrue(!booklist.isEmpty());
            assertTrue(booklist.size() == 1);
            assertTrue(booklist.getFirst().getBookISBN().equals(isbn));

            booklist = db.getBookByTitle(teststr);
            assertTrue(!booklist.isEmpty());
            assertTrue(booklist.size() == 1);
            assertTrue(booklist.getFirst().getBookISBN().equals(isbn));

            booklist = db.getBooksByUser(u1);
            assertTrue(!booklist.isEmpty());
            assertTrue(booklist.size() == 1);
            assertTrue(booklist.getFirst().getBookISBN().equals(isbn));

            Book b2 = db.getBookByIsbn(isbn);
            assertTrue(b2 != null);
            assertTrue(b2.equals(b));

            // null/strange cases
            booklist = db.getBookByAuthor(null);
            assertTrue(booklist == null);
            booklist = db.getBookByTitle(null);
            assertTrue(booklist == null);
            booklist = db.getBooksByUser(null);
            assertTrue(booklist == null);
            Book b3 = db.getBookByIsbn(null);
            assertTrue(b3 == null);

            // remove book
            Book b4 = db.getBookByIsbn(isbn);
            db.removeBookFromCatalogue(b4.getBookID());
            b4 = db.getBookByIsbn(isbn);
            assertTrue(b4 == null);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
