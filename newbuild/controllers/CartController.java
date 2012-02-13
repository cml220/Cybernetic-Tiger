package controllers;
import java.util.LinkedList;

import model.Book;
import exceptions.CartException;

/**
 * Class to control basic functions of a cart, including adding and removing books
 * and calculating the total price of the cart.
 * @author jlg327
 */
public class CartController {

	/**
	 * Adds a given book to the current user's cart, using the Cart class method
	 * @param book The book to add
	 * @throws CartException if book is already in the current user's cart
	 */
	public void addBookToCart(Book book) throws CartException{
		Controller.currentUser.cart.addBookToCart(book);
	}

	/**
	 * Removes a given book from the current user's cart, using the Cart class method
	 * @param book The book to remove
	 * @throws CartException if book is not in the current user's cart
	 */
	public void removeBookFromCart(Book book) throws CartException{
		Controller.currentUser.cart.removeBook(book);
	}

	/**
	 * @return The total dollar value of the books in the current user's cart
	 */
	public float getTotal(){
		// Get the current books in the cart
		LinkedList<Book> cart = Controller.currentUser.cart.getCart();
		int total = 0;
		// Go through every book, adding its price to the running total
		for (Book b : cart){
			total += b.price;
		}
		return total;
	}
}
