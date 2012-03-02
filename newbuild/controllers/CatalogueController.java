package controllers;
import model.Book;
import model.Catalogue;
import exceptions.CatalogueException;

public class CatalogueController {
	private Catalogue catalogue;
	
	public CatalogueController() {
		catalogue = new Catalogue();
	}
	
	public Catalogue getCatalogue() {
		return catalogue;
	}
	
	public void addBookToCatalogue(Book book) throws CatalogueException {
		catalogue.addBook(book);
	}
	
	public void removeBookFromCatalogue(Book book) throws CatalogueException {
		catalogue.removeBook(book);
	}
	
}
