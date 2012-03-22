package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookJUnit {

	@Test
	public void bookConstructorTest() {
		Book b = new Book("THISISAUNIQUESTRING1", "THISISAUNIQUESTRING2", 1.10,
				"THISISAUNIQUESTRING3", 2309580, "THISISAUNIQUESTRING4",
				"THISISAUNIQUESTRING5");
		assertTrue(b.author.equals("THISISAUNIQUESTRING2"));
		assertTrue(b.description.equals("THISISAUNIQUESTRING5"));
		assertTrue(b.img.equals("THISISAUNIQUESTRING4"));
		assertTrue(b.ISBN == 2309580);
		assertTrue(b.pdfURL.equals("THISISAUNIQUESTRING3"));
		assertTrue(b.price == 1.10);
		assertTrue(b.title.equals("THISISAUNIQUESTRING1"));
	}

	@Test
	public void bookGetterTest() {
		Book b = new Book("THISISAUNIQUESTRING1", "THISISAUNIQUESTRING2", 1.10,
				"THISISAUNIQUESTRING3", 2309580, "THISISAUNIQUESTRING4",
				"THISISAUNIQUESTRING5");
		assertTrue(b.getBookAuthor().equals("THISISAUNIQUESTRING2"));
		assertTrue(b.getBookDescription().equals("THISISAUNIQUESTRING5"));
		assertTrue(b.getBookImg().equals("THISISAUNIQUESTRING4"));
		assertTrue(b.getBookISBN() == 2309580);
		assertTrue(b.getBookPdfURL().equals("THISISAUNIQUESTRING3"));
		assertTrue(b.getBookPrice() == 1.10);
		assertTrue(b.getBookTitle().equals("THISISAUNIQUESTRING1"));
	}

	@Test
	public void bookSetterTest() {
		Book b = new Book("THISISAUNIQUESTRING1", "THISISAUNIQUESTRING2", 1.10,
				"THISISAUNIQUESTRING3", 2309580, "THISISAUNIQUESTRING4",
				"THISISAUNIQUESTRING5");
		b.setBookPrice(1000000.00);

		assertTrue(b.price == 1000000.00);

	}

}
