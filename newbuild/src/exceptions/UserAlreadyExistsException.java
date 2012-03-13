package exceptions;

public class UserAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 7146754211447615073L;

	public UserAlreadyExistsException(String message) {
		super(message);
	}
}
