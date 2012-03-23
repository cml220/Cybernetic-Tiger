/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 * Start of the checkout process, My Cart
 * 
 * Checkout written by Jake Bolam
 */

package gui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Book;
import controllers.Controller;


public class CheckoutMyCartPanel extends JPanel
{

    /**
     * 
     */
    private static final long serialVersionUID = 9165182901028257821L;

    public CheckoutMyCartPanel()
    {

        /*
         * Stack panels vertically, 1 column
         */
        this.setLayout(new GridLayout(0,1));


        // TODO: remove the examples below once system goes live
        this.add(new CheckoutMyCartBookPanel(new Book("Test book", "Test author", 11.75, "http://pdfloc", 123456, "http://imgloc", "This is a test book for the next books system.")));
        this.add(new CheckoutMyCartBookPanel(new Book("Test book", "Test author", 11.75, "http://pdfloc", 1234567, "http://imgloc", "This is a test book for the next books system.")));
        this.add(new CheckoutMyCartBookPanel(new Book("Test book", "Test author", 11.75, "http://pdfloc", 1234568, "http://imgloc", "This is a test book for the next books system.")));
        this.add(new CheckoutMyCartBookPanel(new Book("Test book", "Test author", 11.75, "http://pdfloc", 1234569, "http://imgloc", "This is a test book for the next books system.")));

        ArrayList<Book> books = null;

        // Throws exception - ControllerNOTInitalised, SQLException
        try {

            books = Controller.getCartContents();

        }
        catch(Exception e){

            PanelsManager.displayError("Failed to load shopping cart");

        }

        if (books != null) {

            Book currentBookToAdd;
            // Display all the books
            for (int i = 0; i < books.size(); i++) {

                currentBookToAdd = books.get(i);
                this.add(new CheckoutMyCartBookPanel(currentBookToAdd));

            }

        }

    }

}
