package controllers;

import java.util.LinkedList;
import model.Book;
import model.PaymentInfo;

/**
 * 
 * @author jlg327
 */
public class PaymentController {

    /**
     * Confirms that a payment is successful
     * @return True if payment is successful, false otherwise
     */
    public boolean confirmPayment() {
        // TODO: Pass user's payment info to "Credit Card Company" ie: a dummy
        // class and confirm "that the payment is successful"
    	// Returning true by default, as we assume credit card payment succeeds
    	return true;
    }

    /**
     * Adds the books in the current cart to the current user's rentals
     */
    public void addCurrentCart() {
        LinkedList<Book> cart = Controller.getCurrentUser().cart.getCart();
        RentalsController rc = new RentalsController();
        for (Book b : cart)
        {
            rc.addBookToCurrentUser(b);
        }
    }

    /**
     * @return The payment information for the current user
     */
	public PaymentInfo getPaymentInfo() {
		PaymentInfo info = Controller.getCurrentUser().paymentInfo;
		return info;
	}

	/**
	 * Updates the current user's payment information to be the info contained in piNew
	 * @param piNew The new payment information to set
	 */
	public void setPaymentInfo(PaymentInfo piNew) {
		Controller.getCurrentUser().paymentInfo = piNew;
	}
}
