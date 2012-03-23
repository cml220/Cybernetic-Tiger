package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import model.Book;
import controllers.Controller;

/**
 * A panel containing a single book and details about the book.
 * @author Brad
 *
 */
public class CatalogueBookPanel extends BookPanel {

    /**

     */
    private static final long serialVersionUID = -5162648801797138348L;

    /**
     * Constructor; builds a book panel for a specific book.
     * @param title the title of the book
     * @param desc the description of the book
     * @param author the author of the book
     * @param location the url of the book's pdf
     * @param price the price of the book
     */
    public CatalogueBookPanel(final Book book) {

        super(book);

        DecimalFormat df = new DecimalFormat("###,###,###.##");

        super.getPrimaryButton().setText("Rent book");
        // rent book action
        super.getPrimaryButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    // add the book to the cart
                    Controller.addToCart(book);
                    // TODO: remove the button to rent it

                }
                catch (Exception e2){
                    // failed to add to cart
                    e2.printStackTrace();
                    PanelsManager.displayError("Failed to add to cart. \nPlease contact technical support.");
                }
            }


        });
        super.getButtonsPanel().add(super.getPrimaryButton());

        super.getRentalInfoLabel().setText("Price: " + df.format(book.price));
        super.getRentalInfoPanel().add(super.getRentalInfoLabel());

    }

}
