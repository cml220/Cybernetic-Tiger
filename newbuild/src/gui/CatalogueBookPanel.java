package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import controllers.Controller;

import model.Book;

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
                // initialize controller
            	Controller.initialize();
            	try {
            		// add the book to the cart
            		Controller.addToCart(book);
            		// TODO: remove the button to rent it
            		
            	}
            	catch (Exception e2){
            		// TODO: possibly remove this once everything is working
            		JOptionPane.showMessageDialog(null,
				            "Failed to add to cart.",
				            "Catalogue error", JOptionPane.ERROR_MESSAGE);
            		// failed to add to cart, noo biggy ;)
            	}
            }
		    
		    
		});        
        super.getButtonsPanel().add(super.getPrimaryButton());

        super.getRentalInfoLabel().setText("Price: " + df.format(book.price));
        super.getRentalInfoPanel().add(super.getRentalInfoLabel());

    }

}