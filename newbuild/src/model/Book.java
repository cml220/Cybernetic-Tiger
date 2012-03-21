package model;

public class Book {
    public String title;
    public String author;
    public Double price;
    public String pdfURL;
    public long ISBN;
    public String img;
    public String description;

    public Book(String title, String author, double price, String pdfURL, long ISBN, String picURL, String description) {
        this.title=title;
        this.author=author;
        this.price=price;
        this.pdfURL=pdfURL;
        this.ISBN=ISBN;
        this.img = picURL;
        this.description=description;
    }

    /**
     * Empty book for searching with.
     */
    public Book() {

        this.title=null;
        this.author=null;
        this.price=null;
        this.pdfURL=null;
        this.ISBN = -1;
        this.img = null;
        this.description=null;

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

    public long getBookISBN() {
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
