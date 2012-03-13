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
     * Only in place while constructors not finished
     */
    public SearchResultsPanel() {

        this.setLayout(new GridLayout(0, 1));

        //TODO: Search results

    }

    /**
     * Builds a search results panel filled with book panels, constructed
     * using books passed in to the constructor.
     * @param books the list of books to populate the panel with
     */
    public SearchResultsPanel(final LinkedList<Book> books) {

        this.setLayout(new GridLayout(0, 1));

        ListIterator<Book> bookIterator = (ListIterator<Book>) books.iterator();
        Book currentBookToAdd;

        while (bookIterator.hasNext()) {

            currentBookToAdd = bookIterator.next();
            this.add(new CatalogueBookPanel(currentBookToAdd));

        }

    }

}
