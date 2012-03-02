package controllers;
import java.sql.SQLException;
import dbprocess.DatabaseProcess;
import model.*;

/**
 * Class to handle various functionality regarding a user account.
 * Includes making a user an administrator, getting and changing user info
 * and saving payment info.
 * @author jlg327
 */
public class AccountController {

	/**
	 * Makes a given user into an administrator
	 * @param user The user that will become an administrator
	 * @throws SQLException if no connection to the database can be obtained
	 */
	public void makeAdmin(User user) throws SQLException{
		user.isAdmin = true;
		changeUserInfo(user.username, user);
	}

	/**
	 * Searches the database for a given user, then returns that user's information in a User object
	 * @param username The name of the user to search for
	 * @return The user that was found, null if no user with user name "username" 
	 * @throws SQLException if no connection to the database can be obtained
	 */
	public User getUserInfo(String username) throws SQLException {
		DatabaseProcess instance = DatabaseProcess.getInstance();
		User user = instance.getUserInfo(username);
		return user;
	}

	/**
	 * Searches the database for a given user, then updates that user's information based on a User object
	 * @param username The name of the user to search for
	 * @param user The User object containing the information to update with
	 * @throws SQLException  if no connection to the database can be obtained
	 */
	void changeUserInfo(String username, User user) throws SQLException {
		DatabaseProcess instance = DatabaseProcess.getInstance();
		instance.editUserInfo(username, user);
	}

	/**
	 * Adds payment information to a given user
	 * @param user The user to update
	 * @param paymentInfo The payment information to be assigned
	 * @throws SQLException if no connection to the database can be obtained
	 */
	void saveUserPaymentInfo(User user, PaymentInfo paymentInfo) throws SQLException {
		user.paymentInfo = paymentInfo;
		changeUserInfo(user.username, user);
	}
}
