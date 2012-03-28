package model;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.CatalogueException;

public class CatalogueJUnit {

	@Test
	public void catalogueConstructorTest() {
		Catalogue c = new Catalogue();
		assertTrue(c.size() == 0);
		assertTrue(c != null);
	}
	
	@Test
	public void addBookTest() {
		Book b = new Book("THISISAUNIQUESTRING1", "THISISAUNIQUESTRING2", 1.10,
				"THISISAUNIQUESTRING3", 2309580, "THISISAUNIQUESTRING4",
				"THISISAUNIQUESTRING5");
		Catalogue c = new Catalogue();
		assertFalse(c.size() > 0);
		c.add(b);
		assertTrue(c.size() > 0);
	}
	
	@Test
	public void removeBookTest() {
		Catalogue c = new Catalogue();
		Book b = new Book("THISISAUNIQUESTRING1", "THISISAUNIQUESTRING2", 1.10,
				"THISISAUNIQUESTRING3", 2309580, "THISISAUNIQUESTRING4",
				"THISISAUNIQUESTRING5");
		assertTrue(c.size() == 0);
		c.add(b);
		assertTrue(c.size() > 0);
		try {
			c.removeBook(b);
		} catch (CatalogueException e) {
			e.printStackTrace();
		}
	}
	
	
}
