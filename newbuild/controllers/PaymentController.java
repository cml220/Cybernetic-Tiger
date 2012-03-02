package controllers;

import java.util.LinkedList;

import model.Book;

/**
 * 
 * @author jlg327
 */
public class PaymentController {

    /**
     * Confirms that a payment is successful
     */
    public void confirmPayment() {
        // TODO: Pass user's payment info to "Credit Card Company" ie: a dummy
        // class and confirm "that the payment is successful"
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
