package controllers;
import java.sql.SQLException;

import model.User;
import dbprocess.DatabaseProcess;

public class LoginController {

	public LoginController() {
		
	}
	
	public boolean checkLogin(String username, String password) throws SQLException {
		DatabaseProcess db = new DatabaseProcess();
		return db.checkUser(username, password);
	}
	
	public boolean checkNameAvailible(String username) throws SQLException {
		DatabaseProcess db = new DatabaseProcess();
		//return db.(username);		
		return false;
	}
	
	public void createUser(User user, String password) throws Exception {
		DatabaseProcess db = new DatabaseProcess();
		db.createUser(user, password);
	}
}
