package model;

import java.util.ArrayList;

import exceptions.CartException;

public class Cart extends ArrayList<Book>{
	private static final long serialVersionUID = -5188451462474667464L;

	public Cart() {
		super();
	}
	
	/*
	 * TODO Fill out this comment This should probably throw a BookAlready
	 */
	public void addBookToCart(Book book) throws CartException {
		if (contains(book)) {
			throw new CartException("Book is already in cart\n");
		}
		add(book);
	}

	public void removeBook(Book book) throws CartException {
		if (!contains(book)) {
			throw new CartException("Book isn't in cart\n");
		}
		remove(book);
	}
}
