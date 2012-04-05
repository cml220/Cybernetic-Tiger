package gui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import model.Book;
import controllers.Controller;

public class CheckoutVerifyCartContentsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1995910743393899639L;

	/**
	 * Create the panel.
	 */
	public CheckoutVerifyCartContentsPanel() {
		
		setLayout(new GridLayout(0, 3));
		
		// Title field
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblNewLabel);
		
		
		// author field
		JLabel lblNewLabel_1 = new JLabel("Author");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		add(lblNewLabel_1);
		
		// price field
		JLabel lblNewLabel_2 = new JLabel("Price ($)");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		add(lblNewLabel_2);
		
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
	                this.add(new JLabel(currentBookToAdd.title));
	                this.add(new JLabel(currentBookToAdd.author));
	                JLabel priceLabel = new JLabel(currentBookToAdd.price.toString());
	                priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
	                this.add(priceLabel);

	            }

	        }
		

	}

}
