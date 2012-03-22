package model;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.CartException;

public class CartJUnit {

	@Test
	public void cartConstructorTest() {
		Cart test = new Cart();
		Cart test2 = new Cart("2012-01-01");
		assertTrue(test.shopDate == null);
		assertTrue(test != null);
		assertTrue(test2 != null);
		assertTrue(test2.shopDate.equals("2012-01-01"));
	}

	@Test
	public void cartGetterTest() {
		Cart test = new Cart("2012-01-01");
		assertTrue(test.getShopDate().equals("2012-01-01"));

	}

	@Test
	public void cartSetterTest() {
		Cart test = new Cart();
		assertTrue(test.getShopDate() == null);
		test.setShopDate("2012-01-01");
		assertTrue(test.getShopDate().equals("2012-01-01"));
	}

	@Test
	public void cartAddTest() {
		Book b = new Book("THISISAUNIQUESTRING1", "THISISAUNIQUESTRING2", 1.10,
				"THISISAUNIQUESTRING3", 2309580, "THISISAUNIQUESTRING4",
				"THISISAUNIQUESTRING5");
		Cart test = new Cart();
		test.add(b);
		assertTrue(test.size() > 0);
	}

	@Test
	public void cartRemoveTest() {
		Book b = new Book("THISISAUNIQUESTRING1", "THISISAUNIQUESTRING2", 1.10,
				"THISISAUNIQUESTRING3", 2309580, "THISISAUNIQUESTRING4",
				"THISISAUNIQUESTRING5");
		Cart test = new Cart();
		try {
			test.addBookToCart(b);
		} catch (CartException e) {
			e.printStackTrace();
		}
		assertTrue(test.size() > 0);
		try {
			test.removeBook(b);
		} catch (CartException e) {
			e.printStackTrace();
		}
		assertTrue(test.size() == 0);

	}
}
