package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Book;
import model.PaymentInfo;

/**
 * 
 * @author jlg327
 */
public class PaymentController {

    /**
     * Confirms that a payment is successful.
     * @return True if payment is successful, false otherwise
     */
    public boolean confirmPayment() {

        System.out.println("Thanks for the business!");
        System.out.println("Love, Mastercard");

        return true;
    }

    /**
     * Adds the books in the current cart to the current user's rentals.
     * @throws SQLException
     */
    public void addCurrentCart() throws SQLException {
        ArrayList<Book> cart = Controller.getCurrentUser().cart;
        RentalsController rc = new RentalsController();
        for (Book b : cart) {
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
     * Updates the current user's payment information to be the info contained in piNew.
     * @param piNew The new payment information to set
     */
    public void setPaymentInfo(PaymentInfo piNew) {
        Controller.getCurrentUser().paymentInfo = piNew;
    }
}
