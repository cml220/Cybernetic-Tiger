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

	public User(String username, boolean isAdmin, String email,
			ArrayList<Book> rentals, PaymentInfo paymentInfo, Cart cart) {
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
		this.rentals = DatabaseProcess.getInstance().getBooksBy(
				DatabaseProcess.USERNAME, this.getUserName());
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

	public void setPaymentInfo() throws SQLException, CartException {
		this.paymentInfo = DatabaseProcess.getInstance()
				.getUserInfo(this.getUserName()).getPaymentInfo();
	}

	public void setUserName(String newName) {
		this.username = newName;
	}

	public void setEmail(String nEmail) {
		this.email = nEmail;
	}

}
