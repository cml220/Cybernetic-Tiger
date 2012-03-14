package model;

public class PaymentInfo {
	// these are all strings so we don't get exceptions
	// later on we should check for valid data and such etc..
	
	// member fields are private, use getters and setters, this is so later on when we validate the data
	private String cardNumber;
	private String name; //aka card holder
	private String country;
	private String address;
	private String address2;
	private String expiryMonth;
	private String expiryYear;
	private String securityCode;
	private String state;
	private String zip;
	private String phone;
	
	
	// default constructor, set the fields to blank
	public PaymentInfo()
	{
		this.cardNumber = "";
		this.name = "";
		this.country = "";
		this.address = "";
		this.address2 = "";
		this.expiryMonth = "";
		this.expiryYear = "";
		this.securityCode = "";
		this.state = "";
		this.zip = "";
		this.phone = "";		
	}
	
	// alternative constructor, construct from exact values
	public PaymentInfo(String cardNumber, String name, String country,
			String address, String address2, String expiryMonth, String expiryYear,
			String securityCode, String state, String zip, String phone) {
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

	
	// getters and setters in pairs
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public String getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
