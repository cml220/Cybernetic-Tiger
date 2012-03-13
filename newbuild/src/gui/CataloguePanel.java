/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JPanel;

import controllers.Controller;

import model.Book;

/**
 * A panel containing a stack of bookpanels, constructed using details from
 * a search function.
 * @author Brad
 *
 */
public class CataloguePanel extends JPanel {
   

    /**
	 * 
	 */
	private static final long serialVersionUID = -3000480930896311304L;

    /**
     * Builds a search results panel filled with book panels, constructed
     * using books passed in to the constructor.
     * @param books the list of books to populate the panel with
     */
    public CataloguePanel() {

        this.setLayout(new GridLayout(0, 1));
        
        // TODO: remove the examples below once system goes live
        this.add(new CatalogueBookPanel(new Book("Test book", "Test author", 11.75, "http://pdfloc", 123456, "http://imgloc", "This is a test book for the next books system.")));
        this.add(new CatalogueBookPanel(new Book("Test book", "Test author", 11.75, "http://pdfloc", 1234567, "http://imgloc", "This is a test book for the next books system.")));
        this.add(new CatalogueBookPanel(new Book("Test book", "Test author", 11.75, "http://pdfloc", 1234568, "http://imgloc", "This is a test book for the next books system.")));
        this.add(new CatalogueBookPanel(new Book("Test book", "Test author", 11.75, "http://pdfloc", 1234569, "http://imgloc", "This is a test book for the next books system.")));

        /*
         * Initialize the main controller.
         */
        Controller.initialize();
        LinkedList<Book> books = null;
        
        // Throws exception - ControllerNOTInitalised, SQLException
        try {
        	// search for a Null book in an effort to return all the books
        	books = Controller.searchForBook(null);
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
            this.add(new CatalogueBookPanel(currentBookToAdd));

        }

    }
}
