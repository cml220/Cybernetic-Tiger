package model;

import java.util.ArrayList;
import exceptions.CartException;

public class Cart extends ArrayList<Book>{


	public Cart() {
		super();
	}
	
	/*
	 * TODO Fill out this comment This should probably throw a BookAlready
//	 */
//	public void addBookToCart(Book book) throws CartException {
//		if (cart.contains(book)) {
//			throw new CartException("Book is already in cart\n");
//		}
//		cart.add(book);
//	}
//
//	public void removeBook(Book book) throws CartException {
//		if (!cart.contains(book)) {
//			throw new CartException("Book isn't in cart\n");
//		}
//		cart.remove(book);
//	}
//
//	public ArrayList<Book> getCart() {
//		return cart;
//	}
}
