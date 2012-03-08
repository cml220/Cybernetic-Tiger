package model;

public class Book {
	public String title;
    public String author;
    public Double price;
    public String pdfURL;
    public int ISBN;
    public String img;
    public String description;
    
    public Book(String title, String author, double price, String pdfURL, int ISBN, String picURL, String description) {
        this.title=title;
        this.author=author;
        this.price=price;
        this.pdfURL=pdfURL;
        this.ISBN=ISBN;
        this.img = picURL; 
        this.description=description;
    }
    
    
    public String getBookTitle() {
		return title;
	}

	public String getBookAuthor() {
		return author;
	}

	public Double getBookPrice() {
		return price;
	}

	public String getBookPdfURL() {
		return pdfURL;
	}

	public int getBookISBN() {
		return ISBN;
	}

	public String getBookImg() {
		return img;
	}

	public String getBookDescription() {
		return description;
	}
    
    //TODO
    public boolean equals(Book other)
    {
    	return ISBN == other.ISBN;
    	
    }
}
