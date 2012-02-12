package obj;


import java.util.LinkedList;
import java.util.Iterator;

public class Cart {

    private double totalPrice;
    private LinkedList<Book> books;
    private int numBooks;

    public Cart() {
        totalPrice=0;
        books=new LinkedList<Book>();
        numBooks=0;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Book getBookByIndex(int index) {
        Book toReturn;
        try {
            toReturn = books.get(index);
        } catch(Exception e) {
            toReturn = null;
        }
        return toReturn;
    }

    //-------------

    public void addBook(Book b) {
        totalPrice=totalPrice+b.getBookPrice();
        books.add(b);
        numBooks++;
    }

    public int countBook() {
        return numBooks;
    }
    public void clear() {
        books.clear();
        totalPrice=0;
        numBooks=0;

    }

    public void removeBookById(int id) {
        totalPrice=totalPrice-books.get(id).getBookPrice();
        books.remove(id);
        numBooks--;
    }

    public boolean containBook(int bookId) {
        Iterator<Book> ir=books.iterator();
        while(ir.hasNext()) {
            if(ir.next().getBookID()==bookId) {
                return true;
            }
        }
        return false;
    }
}
