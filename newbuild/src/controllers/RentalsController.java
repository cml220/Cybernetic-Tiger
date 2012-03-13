package controllers;
import java.sql.SQLException;
import java.util.ArrayList;

import model.*;
import dbprocess.DatabaseProcess;

public class RentalsController {
	
	public RentalsController() {
		
		
	}
	
	public void addBookToCurrentUser(Book book) throws SQLException {
		DatabaseProcess db = new DatabaseProcess();
		db.addBookToUser(book.ISBN, Controller.getCurrentUser().username);
		Controller.getCurrentUser().rentals.add(book);
		
	}
	public void addBookToUser(Book book, User user) throws SQLException {
		DatabaseProcess db = new DatabaseProcess();
		db.addBookToUser(book.ISBN, user.username);
		user.rentals.add(book);
	}
	
	public void removeBookFromUser(Book book, User user) throws SQLException {
		DatabaseProcess db = new DatabaseProcess();
		db.removeBookFromUser(user.username, book.ISBN);
		user.rentals.remove(book);
	}
	
	public void removeBookFromCurrentUser(Book book) throws SQLException {
		Controller.getCurrentUser().rentals.remove(book);
		(new DatabaseProcess()).removeBookFromUser(Controller.getCurrentUser().username, book.ISBN);
	}

	public ArrayList<Book> getBooks() throws SQLException {
		DatabaseProcess db = new DatabaseProcess();
		Controller.getCurrentUser().rentals = db.getBooksBy(DatabaseProcess.USERNAME, Controller.getCurrentUser().username);
		return Controller.getCurrentUser().rentals;
	}
}
