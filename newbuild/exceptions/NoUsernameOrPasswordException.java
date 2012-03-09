package exceptions;

public class NoUsernameOrPasswordException extends Exception {
	private static final long serialVersionUID = 3996381168010389844L;

	public NoUsernameOrPasswordException(String message) {
		super(message);
	}
}
