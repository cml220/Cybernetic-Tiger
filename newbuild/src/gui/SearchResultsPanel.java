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

        this.loadBooks();

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

            this.add(new SearchBookPanel(currentBookToAdd.title,
                    currentBookToAdd.description, currentBookToAdd.author,
                    currentBookToAdd.pdfURL, currentBookToAdd.price));

        }

    }

    /**
     * Only in place while controllers incomplete.
     */
    private void loadBooks() {

        /*
         * Skeleton implementation
         * In future, this will create book panels from the database/cache
         */
        this.add(new SearchBookPanel("Oxford English Dictionary",
                "Words and stuff.", "some guy", "http://somewhere", 22.50));

        this.add(new SearchBookPanel("Collins Pocket French Dictionary",
                "French words and stuff.", "un garcon", "http://lesomewherre",
                19.75));

        this.add(new SearchBookPanel("College Physics", "PHYSICS",
                "Physics person", "httphysics", 99.99));

        this.add(new SearchBookPanel("A Clockwork Orange",
                "No time for the old in-out in-out love.", "Anthony Burgess",
                "http://droogs", 12.63));

        this.add(new SearchBookPanel("Another Clockwork Orange", "",
                "Anthony Burgess", "http://droogs", 12.63));

        this.add(new SearchBookPanel("An Additional Clockwork Orange", "",
                "Anthony Burgess", "http://droogs", 12.63));

        this.add(new SearchBookPanel("Not A Clockwork Orange", "",
                "Anthony Burgess", "http://droogs", 12.63));

    }

}
