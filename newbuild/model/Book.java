package model;

import java.awt.Image;

public class Book {
	public String title;
    public String author;
    public float price;
    public String pdfURL;
    public String ISBN;
    public String img;
    public String description;
    
    public Book(String title, String author, float price, String pdfURL, String ISBN, String picURL, String description) {
        this.title=title;
        this.author=author;
        this.price=price;
        this.pdfURL=pdfURL;
        this.ISBN=ISBN;
        this.img = picURL; 
        this.description=description;
    }
    
    //TODO
    public boolean equals(Book other)
    {
    	return title.equals(other.title);
    	
    }
}
