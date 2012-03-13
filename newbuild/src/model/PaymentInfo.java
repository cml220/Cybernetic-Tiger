package model;

public class PaymentInfo {
	// these are all strings so we don't get excceptions
	// later on we should check for valid data and such etc..
	public String cardNumber;
	public String name; //aka card holder
	public String country;
	public String address;
	public String address2;
	public String expiryMonth;
	public String expiryYear;
	public String securityCode;
	public String state;
	public String zip;
	public String phone;
	
	public PaymentInfo(String cardNumber, String name, String country,
			String address, String address2, String expiryMonth, String expiryYear,
			String securityCode, String state, String zip, String phone) {
		super();
		this.cardNumber = cardNumber;
		this.name = name;
		this.country = country;
		this.address = address;
		this.address2 = address2;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.securityCode = securityCode;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}
	
	
}
