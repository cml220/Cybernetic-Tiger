package model;

public class PaymentInfo {
	enum CreditCard {Mastercard, Visa};
	public CreditCard creditCard;
	public int cardNumber;
	public String cardHolder;
	public int expiryMonth;
	public int expiryDate;
	public String address;
	public String postalCode;
	
	public PaymentInfo(CreditCard creditCard, int cardNumber, String cardHolder, int expiryMonth, int expiryDate, String address, String postalCode)
	{
		this.creditCard = creditCard;
		this.cardNumber = cardNumber;
		this.cardHolder = cardHolder;
		this.expiryMonth = expiryMonth;
		this.expiryDate = expiryDate;
		this.address = address;
		this.postalCode = postalCode;
	}
}
