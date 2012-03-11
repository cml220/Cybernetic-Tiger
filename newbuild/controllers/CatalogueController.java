package controllers;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import model.Book;
import model.Catalogue;
import exceptions.CatalogueException;
import dbprocess.DatabaseProcess;

public class CatalogueController {
	private ArrayList<Book> catalogue;
	
	public CatalogueController() {
		catalogue = new ArrayList<Book>();
	}
	
	public ArrayList<Book> getCatalogue() throws SQLException {
		DatabaseProcess process = new DatabaseProcess();
		catalogue = process.getBooksBy(DatabaseProcess.CATALOGUE, null);
		return catalogue;
	}
	
	public void addBookToCatalogue(Book book) throws CatalogueException, SQLException {
		DatabaseProcess db = new DatabaseProcess();
		db.addBookToCatalogue(book);
		catalogue.add(book);
	}
	
	public void removeBookFromCatalogue(Book book) throws CatalogueException, SQLException {
		DatabaseProcess db = new DatabaseProcess();
		//TODO BOOK ID?
		db.removeBookFromCatalogue(book.ISBN);
		catalogue.remove(book);
	}
	
}
