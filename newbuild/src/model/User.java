package model;

import java.sql.SQLException;
import java.util.ArrayList;

import dbprocess.DatabaseProcess;

public class User {
	public PaymentInfo paymentInfo;
	public String username;

	public ArrayList<Book> rentals;
	public boolean isAdmin;
	public String email;
	public Cart cart;
	
	//TODO:
	public User(String username, boolean isAdmin, String email) throws SQLException
	{
		this.username = username;
		//TODO DBINTERFACE
		User userInfo = (new DatabaseProcess()).getUserInfo(username);
			// hack so login still works below (if null etc)
			if (userInfo != null) {
				this.paymentInfo = userInfo.paymentInfo;
			}
			// end hack
		rentals = (new DatabaseProcess()).getBooksBy(DatabaseProcess.USERNAME, username);
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

}
