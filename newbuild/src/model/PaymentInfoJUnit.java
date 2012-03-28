package model;

import static org.junit.Assert.*;
import org.junit.Test;

public class PaymentInfoJUnit {

	@Test
	public void paymentInfoConstructorTest() {
		PaymentInfo e = new PaymentInfo();
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(e != null);
		assertTrue(f != null);
	}
	
	@Test
	public void paymentInfoGetCardNumberTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getCardNumber().equals("123456789"));
	}
	
	@Test
	public void paymentInfoSetCardNumberTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getCardNumber().equals("123456789"));
		f.setCardNumber("987654321");
		assertFalse(f.getCardNumber().equals("123456789"));
		assertTrue(f.getCardNumber().equals("987654321"));
	}
	
	@Test
	public void paymentInfoGetNameTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getName().equals("Bob"));
	}
	
	@Test
	public void paymentInfoSetNameTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getName().equals("Bob"));
		f.setName("Jon");
		assertFalse(f.getName().equals("Bob"));
		assertTrue(f.getName().equals("Jon"));
	}
	
	@Test
	public void paymentInfoGetCountryTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getCountry().equals("Canada"));
	}
	
	@Test
	public void paymentInfoSetCountryTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getCountry().equals("Canada"));
		f.setCountry("US");
		assertFalse(f.getCountry().equals("Canada"));
		assertTrue(f.getCountry().equals("US"));
	}
	
	@Test
	public void paymentInfoGetAddressTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getAddress().equals("555 12st"));
	}
	
	@Test
	public void paymentInfoSetAddressTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getAddress().equals("555 12st"));
		f.setAddress("123 Easy st");
		assertFalse(f.getAddress().equals("555 12st"));
		assertTrue(f.getAddress().equals("123 Easy st"));
	}
	
	@Test
	public void paymentInfoGetAddress2Test() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getAddress2().equals(""));
	}
	
	@Test
	public void paymentInfoSetAddress2Test() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getAddress2().equals(""));
		f.setAddress2("123 Easy st");
		assertFalse(f.getAddress2().equals(""));
		assertTrue(f.getAddress2().equals("123 Easy st"));
	}
	
	@Test
	public void paymentInfoGetExpiryMonthTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getExpiryMonth().equals("03"));
	}
	
	@Test
	public void paymentInfoSetExpiryMonthTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getExpiryMonth().equals("03"));
		f.setExpiryMonth("04");
		assertFalse(f.getExpiryMonth().equals("03"));
		assertTrue(f.getExpiryMonth().equals("04"));
	}
	
	@Test
	public void paymentInfoGetExpiryYearTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getExpiryYear().equals("12"));
	}
	
	@Test
	public void paymentInfoSetExpiryYearTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getExpiryYear().equals("12"));
		f.setExpiryYear("20");
		assertFalse(f.getExpiryYear().equals("12"));
		assertTrue(f.getExpiryYear().equals("20"));
	}
	
	@Test
	public void paymentInfoGetSecurityCodeTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getSecurityCode().equals("123"));
	}
	
	@Test
	public void paymentInfoSetSecurityCodeTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getSecurityCode().equals("123"));
		f.setSecurityCode("321");
		assertFalse(f.getSecurityCode().equals("123"));
		assertTrue(f.getSecurityCode().equals("321"));
	}
	
	@Test
	public void paymentInfoGetStateTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getState().equals("Sask"));
	}
	
	@Test
	public void paymentInfoSetStateTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getState().equals("Sask"));
		f.setState("Alb");
		assertFalse(f.getState().equals("Sask"));
		assertTrue(f.getState().equals("Alb"));
	}
	
	@Test
	public void paymentInfoGetZipTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getZip().equals("S6V6N4"));
	}
	
	@Test
	public void paymentInfoSetZipTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getZip().equals("S6V6N4"));
		f.setZip("S7L3S4");
		assertFalse(f.getZip().equals("S6V6N4"));
		assertTrue(f.getZip().equals("S7L3S4"));
	}
	
	@Test
	public void paymentInfoGetPhoneTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getPhone().equals("5555555"));
	}
	
	@Test
	public void paymentInfoSetPhoneTest() {
		PaymentInfo f = new PaymentInfo("123456789", "Bob", "Canada",
				"555 12st", "", "03", "12",
				"123", "Sask", "S6V6N4", "5555555");
		assertTrue(f.getPhone().equals("5555555"));
		f.setPhone("5555556");
		assertFalse(f.getPhone().equals("5555555"));
		assertTrue(f.getPhone().equals("5555556"));
	}
}
