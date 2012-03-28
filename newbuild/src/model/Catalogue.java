package model;
import java.util.ArrayList;
import exceptions.CatalogueException;

public class Catalogue extends ArrayList<Book> {
	
	private static final long serialVersionUID = 1L;

	public Catalogue() {
		super();
	}
	
	public Catalogue(ArrayList<Book> store) {
		super(store);
	}

		
	public void addBook(Book book) throws CatalogueException {
		if(this.contains(book)) throw new CatalogueException("Catalogue already contains book\n");
		this.add(book);
	}
	
	public void removeBook(Book book) throws CatalogueException {
		if(!this.contains(book)) throw new CatalogueException("Catalogue doesn't contain book\n");
		this.remove(book);
	}
}
