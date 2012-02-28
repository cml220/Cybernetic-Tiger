package controllers;
import model.*;

public class RentalsController {
	
	public RentalsController()
	{
		
		
	}
	
	public void addBookToCurrentUser(Book book)
	{
		Controller.getCurrentUser().rentals.add(book);
	}
	public void addBookToUser(Book book, User user)
	{
		user.rentals.add(book);
	}
	
	public void removeBookFromUser(Book book, User user)
	{
		user.rentals.remove(book);
	}
	
	public void removeBookFromCurrentUser(Book book)
	{
		Controller.getCurrentUser().rentals.remove(book);		
	}
}
