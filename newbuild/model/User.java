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
	public User(String username, String pw, boolean isAdmin, String email)
	{
		this.username = username;
		this.password = pw;
		//TODO DBINTERFACE
		//paymentInfo = DBInterface.getPaymentInfo(username)
		//rentals = DBInterface.getBooksByUser(username)
		this.isAdmin = isAdmin;
		this.email = email;
		cart = new Cart();
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getUserName() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}
