package controllers;

import static org.junit.Assert.fail;

import java.net.MalformedURLException;

import javax.swing.JPanel;

import model.Book;

import org.junit.Test;

public class ControllerJUnit {

    //need to create a reader controller to test
    private final ReaderController c = new ReaderController();

    @Test
    public void testopenBook() throws MalformedURLException {
        //need to make a book and give it a bad url, already know good url works
        //need to make sure a bad url doesn't work
        Book b = new Book("title", "author", 1.99, "pdfURL", 0, "picURL", "description");
        try{
            @SuppressWarnings("unused")
            //don't need to actually display the reader as it should fail anyway. just call openBook
            JPanel panel = c.openBook(b);
            //if we continue after this we know our test has failed
            fail("openBook should have failed");
        } catch(MalformedURLException expected) {
            //we caught an exception so all is good
        }
        //make sure our open, save, and print values are set to false
        //assertTrue(c.getProperties());
    }

}
