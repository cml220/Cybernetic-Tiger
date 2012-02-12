package model;
import java.util.LinkedList;
import exceptions.CatalogueException;

public class Catalogue {
	private LinkedList<Book> books;
	
	public Catalogue() {
		books = new LinkedList<Book>();
	}
	
	public void addBook(Book book) throws CatalogueException {
		if(books.contains(book)) throw new CatalogueException("Catalogue already contains book\n");
		books.add(book);
	}
	
	public void removeBook(Book book) throws CatalogueException {
		if(!books.contains(book)) throw new CatalogueException("Catalogue doesn't contain book\n");
		books.remove(book);
	}
}
