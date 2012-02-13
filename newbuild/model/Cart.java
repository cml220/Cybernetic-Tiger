package model;

import java.util.LinkedList;
import exceptions.CartException;

public class Cart {
	private LinkedList<Book> cart;

	public Cart() {
			cart = new LinkedList<Book>();
	}
	
	/*
	 * TODO Fill out this comment This should probably throw a BookAlready
	 */
	public void addBookToCart(Book book) throws CartException {
		if (cart.contains(book)) {
			throw new CartException("Book is already in cart\n");
		}
		cart.addLast(book);
	}

	public void removeBook(Book book) throws CartException {
		if (!cart.contains(book)) {
			throw new CartException("Book isn't in cart\n");
		}
		cart.remove(book);
	}

	public LinkedList<Book> getCart() {
		return cart;
	}
}
