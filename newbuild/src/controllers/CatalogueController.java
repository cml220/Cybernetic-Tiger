package controllers;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Book;
import dbprocess.DatabaseProcess;
import exceptions.CatalogueException;

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

    /**
     * Searches by all non-null fields of a given book.
     * @param book The Book object to use for searching
     * @return All books that match the criteria of the selected book
     * @throws SQLException
     */
    public ArrayList<Book> searchByBook(Book book) throws SQLException {
        DatabaseProcess db = new DatabaseProcess();
        // Initialize the ArrayList<Book> to return
        ArrayList<Book> bookList = new ArrayList<Book>();

        // Use the database process getBooksBy() method to get books by all applicable fields

        // ISBN is always required, so we can always search by it
        if (book.getBookISBN() >= 0) {
            Book bookByISBN = db.getBookByIsbn(book.getBookISBN());
            if (!bookList.contains(bookByISBN)) {
                bookList.add(bookByISBN);
            }
        }

        // Check Title
        if (book.getBookTitle() != null) {
            ArrayList<Book> booksByTitle = db.getBooksBy(DatabaseProcess.TITLE, book.getBookTitle());
            for (Book b : booksByTitle) {
                if (!bookList.contains(b)) {
                    bookList.add(b);
                }
            }
        }

        // Check Author
        if (book.getBookAuthor() != null) {
            ArrayList<Book> booksByAuthor = db.getBooksBy(DatabaseProcess.AUTHOR, book.getBookAuthor());
            for (Book b : booksByAuthor) {
                if (!bookList.contains(b)) {
                    bookList.add(b);
                }
            }
        }
        return bookList;
    }

    public void removeBookFromCatalogue(Book book) throws CatalogueException, SQLException {
        DatabaseProcess db = new DatabaseProcess();
        db.removeBookFromCatalogue(book.ISBN);
        catalogue.remove(book);
    }

}
