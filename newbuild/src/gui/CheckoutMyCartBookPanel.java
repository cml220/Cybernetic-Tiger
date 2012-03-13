package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import controllers.Controller;

import model.Book;

public class CheckoutMyCartBookPanel extends BookPanel {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7804397733163019229L;

	public CheckoutMyCartBookPanel(final Book book){
		
		super(book);

		DecimalFormat df = new DecimalFormat("###,###,###.##");
		
		super.getPrimaryButton().setText("Remove from cart");
		super.getPrimaryButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // initialize controller
            	Controller.initialize();
            	try {
            		// add the book to the cart
            		Controller.removeFromCart(book);
            		// TODO: remove the button remove it
            		
            	}
            	catch (Exception e2){
            		// TODO: possibly remove this once everything is working
            		JOptionPane.showMessageDialog(null,
				            "Failed to remove from cart.",
				            "Checkout error", JOptionPane.ERROR_MESSAGE);
            		// failed to remove from cart
            	}
            }
		    
		    
		});    
		super.getButtonsPanel().add(super.getPrimaryButton());

		super.getRentalInfoLabel().setText("Price: " + df.format(book.price));
		super.getRentalInfoPanel().add(super.getRentalInfoLabel());
		
	}
	
}
