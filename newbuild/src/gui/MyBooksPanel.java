/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.GridLayout;

import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JPanel;

import model.Book;

import controllers.Controller;

/**
 * A panel containing a stack of bookpanels, constructed using details from
 * the user's book collection info.
 * @author Brad
 *
 */
public class MyBooksPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = -25250717196528793L;

    /**
     * Construct the panel.
     * THIS IS A PLACEHOLDER
     */
    public MyBooksPanel() {

        /*
         * Stack panels vertically, 1 column
         */
        this.setLayout(new GridLayout(0, 1));

     // TODO: remove the examples below once system goes live
        this.add(new RentedBookPanel(new Book("Test book", "Test author", 11.75, "http://dl.dropbox.com/u/47583545/test.pdf", 123456, "http://imgloc", "This is a test book for the next books system.")));
        this.add(new RentedBookPanel(new Book("Test book", "Test author", 11.75, "http://dl.dropbox.com/u/47583545/test.pdf", 1234567, "http://imgloc", "This is a test book for the next books system.")));
        this.add(new RentedBookPanel(new Book("Test book", "Test author", 11.75, "http://dl.dropbox.com/u/47583545/test.pdf", 1234568, "http://imgloc", "This is a test book for the next books system.")));
        this.add(new RentedBookPanel(new Book("Test book", "Test author", 11.75, "http://dl.dropbox.com/u/47583545/test.pdf", 1234569, "http://imgloc", "This is a test book for the next books system.")));

        
        /*
         * Initialize the main controller.
         */
        Controller.initialize();
        ArrayList<Book> books = null;
        
        // Throws exception - ControllerNOTInitalised, SQLException
        try {
        	 books = Controller.getUserBooks();
        }
        catch(Exception e){
        	// something has gone wrong, make sure books is set to null
        	books = null;
        }
        
        ListIterator<Book> bookIterator;
        
        // try catch block to stop the application from crashing if user has no books
        try {
        	 bookIterator = (ListIterator<Book>) books.iterator();
        }
        catch(Exception e) {
        	bookIterator = null;
        }
        
        Book currentBookToAdd;        
        // Display all the books
        while (bookIterator != null && bookIterator.hasNext()) {

            currentBookToAdd = bookIterator.next();
            this.add(new RentedBookPanel(currentBookToAdd));

        }

    }
}
