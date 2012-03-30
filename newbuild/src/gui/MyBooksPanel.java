/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.GridLayout;
import java.util.ArrayList;

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

        ArrayList<Book> books = null;

        // Throws exception - ControllerNOTInitalised, SQLException
        try {
            books = Controller.getUserBooks();

            // Display all the books
            for (int i = 0; i < books.size(); i++) {

                this.add(new RentedBookPanel(books.get(i)));

            }

        } catch (Exception e) {

            // something has gone wrong
            PanelsManager.displayError("Failed to load your books.");

        }


    }
}
