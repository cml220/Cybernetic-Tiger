package model;

import java.sql.SQLException;
import java.util.ArrayList;

import dbprocess.DatabaseProcess;
import exceptions.CartException;

public class User {
	public PaymentInfo paymentInfo;
	public String username;

	public ArrayList<Book> rentals;
	public boolean isAdmin;
	public String email;
	public Cart cart;
	
	//TODO: Not sure how login process goes, I envisioned we would simply check db is user login info is correct (using only strings)
	//       and then call getUserInfo to obtain a user from the database. Shouldn't the database controller concern itself with creating
	//       a the user and "attaching" its info, rentals, etc. I was thinking that the only time the user constructor is called outside dbcontroller 
	//       would be when a user who is new to the system is registering, at which point there would be no paymentInfo or rentals.
	
	//		I am going to talk to Colin about new db operations to encapsulate paymentInfo(ie. check if info exists, retrieve payment info by username, etc)
	//		and about making sure that when a user is pulled from the database that all corresponding info comes out with it.
	public User(String username, boolean isAdmin, String email, ArrayList<Book> rentals, PaymentInfo paymentInfo, Cart cart) throws SQLException
	{
		this.username = username;
		this.rentals = rentals;
		this.paymentInfo = paymentInfo;
		this.cart = cart;
		this.isAdmin = isAdmin;
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void restoreCart() throws SQLException, CartException {
		DatabaseProcess gdb = DatabaseProcess.getInstance();
		this.cart = gdb.getUserCart(this.getUserName());
	}
	
	public void deleteCart() {
		this.cart = new Cart();
	}
	
	public void setRentals() throws SQLException {
		this.rentals = DatabaseProcess.getInstance().getBooksBy(DatabaseProcess.USERNAME, this.getUserName());
	}
	
	public ArrayList<Book> getRentals() {
		return this.rentals;
	}
	
	public Cart getCart() {
		return this.cart;
	}
	
	public String getUserName() {
		return username;
	}
	
	public PaymentInfo getPaymentInfo() {
		return this.paymentInfo;
	}
	
	public void setPaymentInfo() throws SQLException, CartException{
		this.paymentInfo = DatabaseProcess.getInstance().getUserInfo(this.getUserName()).getPaymentInfo();
	}
	
	public void setUserName(String newName) {
		this.username = newName;
	}
	
	public void setEmail(String nEmail) {
		this.email = nEmail;
	}

}
