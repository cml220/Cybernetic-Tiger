package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controllers.Controller;
import model.Book;

/**
 * A panel containing a single book and details about the book.
 * @author Brad
 *
 */
public class RentedBookPanel extends BookPanel {

    /**
     *
     */
    private static final long serialVersionUID = -1259781312842495888L;

    /**
     * Constructor;  builds a book panel for a specific book.
     * @param book, the object of the Book
     */
    public RentedBookPanel(final Book book) {

        super(book);

        super.getPrimaryButton().setText("Read Now");
        super.getPrimaryButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // initialize controller
            	Controller.initialize();
            	try {
            		// add the book to the cart
            		Controller.openReader(book);
            		// TODO: remove the button to read it
            		// TODO: display the panel somewhere, can we just launch a new panel?
            		
            	}
            	catch (Exception e2){
            		// TODO: possibly remove this once everything is working
            		JOptionPane.showMessageDialog(null,
				            "Failed to display book to read.",
				            "NextBooks error", JOptionPane.ERROR_MESSAGE);
            		// failed to display
            	}
            }
		    
		    
		}); 

        super.getButtonsPanel().add(super.getPrimaryButton());

        super.getRentalInfoLabel().setText("Days remaining: 10"); // TODO: implement this throughout the application
        super.getRentalInfoPanel().add(super.getRentalInfoLabel());

    }

}
