package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UserJUnit {

	@Test
	public void testUserConstructor() {
		Cart shopping = new Cart();
		ArrayList<Book> rental = new ArrayList<Book>();
		PaymentInfo testInfo = new PaymentInfo();
		User test = new User("Test", false, "myemail@stupid", rental, testInfo,
				shopping);
		assertTrue(test.username.equals("Test")
				&& test.email.equals("myemail@stupid") && test.isAdmin == false);
	}

	@Test
	public void testUserGetters() {
		Cart shopping = new Cart();
		ArrayList<Book> rental = new ArrayList<Book>();
		PaymentInfo testInfo = new PaymentInfo();
		User test = new User("Test", false, "myemail@stupid", rental, testInfo,
				shopping);
		assertTrue(test.getUserName().equals("Test"));
		assertTrue(test.getCart() != null);
		assertTrue(test.getEmail().equals("myemail@stupid"));
		assertTrue(test.getPaymentInfo() != null);
		assertTrue(test.getRentals() != null);
	}

	@Test
	public void testUserSetters() {
		Cart shopping = new Cart();
		ArrayList<Book> rental = new ArrayList<Book>();
		PaymentInfo testInfo = new PaymentInfo();
		User test = new User("Test", false, "myemail@stupid", rental, testInfo,
				shopping);
		test.setEmail("newemail@stupid");
		test.setUserName("test1");
		assertTrue(test.getUserName().equals("test1"));
		assertTrue(test.getEmail().equals("newemail@stupid"));
	}
}
