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
	 *  Makes a given user into an administrator.
	 * @param username The name of the user that will become an administrator
	 * @throws Exception 
	 */
	public void makeAdmin(String username) throws Exception {
		if (!Controller.getCurrentUser().isAdmin)
		{
			throw new Exception("Only administrators can make other users admins");
		}
		DatabaseProcess instance = DatabaseProcess.getInstance();
		User user = instance.getUserInfo(username);
		user.isAdmin = true;
		String passWord = instance.getUserPassWord(username);
		instance.editUserInfo(user, username, passWord);
	}

	/**
	 * Searches the database for a given user, then returns that user's information in a User object.
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
	 * Searches the database for a given user, then updates that user's information based on a User object.
	 * @param newPassword The new password to use
	 * @param user The User object containing the information to update with
	 * @param password The password of the user, used to ensure that an update is permissible
	 * @throws Exception 
	 */
	void changeUserInfo(String newPassword, User user, String password) throws Exception {
		DatabaseProcess instance = DatabaseProcess.getInstance();
		instance.editUserInfo(user, password, newPassword);
	}

	/**
	 * Adds payment information to a given user.
	 * @param user The user to update
	 * @param paymentInfo The payment information to be assigned
	 * @throws Exception 
	 *** DEPRECATED to improve security (users must manually enter payment info each time) ***
	void saveUserPaymentInfo(User user, PaymentInfo paymentInfo) throws Exception {
		user.paymentInfo = paymentInfo;
		//changeUserInfo(user.username, user, null);
		throw new Exception("AccountController.saveUserPaymentInfo(user, paymentInfo) is a broken method -Jason");
	}*/
}
