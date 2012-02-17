package model;

import java.util.LinkedList;

public class User {
	public PaymentInfo paymentInfo;
	public String username;
	public String password;
	public LinkedList<Book> rentals;
	public boolean isAdmin;
	public String email;
	public Cart cart;
	
	//TODO:
	public User(String username, boolean isAdmin, String email)
	{
		this.username = username;
		//TODO DBINTERFACE
		//paymentInfo = DBInterface.getPaymentInfo(username)
		//rentals = DBInterface.getBooksByUser(username)
		this.isAdmin = isAdmin;
		this.email = email;
		cart = new Cart();
	}
	
	public String getUserName() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}
