/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import model.Book;

/**
 * A panel containing a stack of bookpanels, constructed using details from
 * a search function.
 * @author Brad
 *
 */
public class SearchResultsPanel extends StyledPanel {

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

        /*
         * If there were matching, display the books vertically
         */

        if (books.size() > 0) {

            this.setLayout(new GridLayout(0, 1));

            Book currentBookToAdd;

            System.out.println(books.size());

            for (int i = 0; i < books.size(); i++) {

                currentBookToAdd = books.get(i);
                System.out.println("HI " + currentBookToAdd.title);
                this.add(new CatalogueBookPanel(currentBookToAdd));

            }

        } else {

            /*
             * If there were no matches print a message to screen.
             */
            this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

            this.add(Box.createVerticalStrut(200));
            this.add(new JLabel("   Could not find any books."),
                    BorderLayout.NORTH);
            this.add(new JLabel("   Try using less specific search keywords."),
                    BorderLayout.SOUTH);

        }

    }

}
