package controllers;
import java.util.ArrayList;

import model.Book;
import exceptions.CartException;

/**
 * Class to control basic functions of a cart, including adding and removing books
 * and calculating the total price of the cart.
 * @author jlg327
 */
public class CartController {

	/**
	 * Adds a given book to the current user's cart, using the Cart class method.
	 * @param book The book to add
	 * @throws CartException if book is already in the current user's cart
	 */
	public void addBookToCart(Book book) throws CartException {
		Controller.getCurrentUser().cart.add(book);
	}

	/**
	 * Removes a given book from the current user's cart, using the Cart class method.
	 * @param book The book to remove
	 * @throws CartException if book is not in the current user's cart
	 */
	public void removeBookFromCart(Book book) throws CartException {
		Controller.getCurrentUser().cart.remove(book);
	}

	/**
	 * @return The total dollar value of the books in the current user's cart
	 */
	public float getTotal() {
		float total = 0;
		// Get the current books in the cart
		if (Controller.getCurrentUser() != null) {
			ArrayList<Book> cart = Controller.getCurrentUser().cart;
			if (cart != null) {
				// Go through every book, adding its price to the running total
				for (Book b : cart) {
					total += b.price;
				}
			}
		}
		return total;
	}

	/**
	 * @return Returns the entire list of books that are in the current user's cart
	 */
	public ArrayList<Book> getBooks() {
		return Controller.getCurrentUser().cart;
	}
}
