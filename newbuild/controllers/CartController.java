package controllers;
import model.Book;
import exceptions.CartException;

public class CartController {
	public CartController()
	{
	}
	
	public void addBookToCart(Book book) throws CartException
	{
		Controller.currentUser.cart.addBookToCart(book);
	}
	
	public void removeBookFromCart(Book book) throws CartException
	{
		Controller.currentUser.cart.removeBook(book);
	}
	
	public float getTotal()
	{
		return 0;
		//TODO
	}
}
