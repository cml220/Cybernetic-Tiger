package exceptions;

public class NullUserException extends Exception {
	private static final long serialVersionUID = -1648475327994729183L;

	public NullUserException(String message) {
		super(message);
	}
}
