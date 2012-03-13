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
