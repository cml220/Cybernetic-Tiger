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

/**
 * A panel containing a stack of bookpanels, constructed using details from
 * a search function.
 * @author Brad
 *
 */
public class SearchResultsPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = -7862774713466486186L;

    /**
     * Constructor.
     * Empty Placeholder.
     */
    public SearchResultsPanel() {

        this.setLayout(new GridLayout(0, 1));

    }

    /**
     * Builds a search results panel filled with book panels, constructed
     * using books passed in to the constructor.
     * @param books the list of books to populate the panel with
     */
    public SearchResultsPanel(final ArrayList<Book> books) {

        this.setLayout(new GridLayout(0, 1));

        Book currentBookToAdd;

        System.out.println(books.size());

        for (int i = 0; i < books.size(); i++) {

            currentBookToAdd = books.get(i);
            System.out.println("HI " + currentBookToAdd.title);
            this.add(new CatalogueBookPanel(currentBookToAdd));

        }

    }

}
