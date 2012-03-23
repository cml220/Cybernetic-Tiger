/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Book;
import controllers.Controller;
import exceptions.ControllerNotInitializedException;

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
     * @throws ControllerNotInitializedException
     * @throws SQLException
     */
    public CataloguePanel() throws SQLException, ControllerNotInitializedException {

        this.setLayout(new GridLayout(0, 1));

        ArrayList<Book> books = null;

        try{

            books = Controller.getCatalogue();

        } catch (Exception e) {

            e.printStackTrace();
            PanelsManager.displayError(e.getMessage());

        }

        if (books != null) {

            Book currentBookToAdd;
            // Display all the books
            for (int i = 0; i < books.size(); i++) {

                currentBookToAdd = books.get(i);
                this.add(new CatalogueBookPanel(currentBookToAdd));

            }

        }

    }
}
