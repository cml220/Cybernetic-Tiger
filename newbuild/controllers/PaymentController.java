package controllers;

import java.util.LinkedList;
import model.Book;

/**
 * 
 * @author jlg327
 */
public class PaymentController {

	/**
	 * Confirms that a user actually wants to make a payment
	 */
	public void confirmPayment() {
		// TODO: Open window
		// How is this working? Give control to correct window, depending on input?
	}

	/**
	 * Adds the books in the current cart to the current user's rentals
	 */
	public void addCurrentCart() {
		LinkedList<Book> cart = Controller.getCurrentUser().cart.getCart();
		for (Book b : cart)
		{
			// Possible TODO: add in check for addings duplicate books to user?
			Controller.getCurrentUser().rentals.add(b);
		}
	}
}
