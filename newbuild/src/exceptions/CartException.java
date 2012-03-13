package exceptions;

public class CartException extends Exception {

	/**
	 * Serial ID, used to get rid of warnings/improve efficiency
	 */
	private static final long serialVersionUID = -2420910221784404324L;

	public CartException(String message) {
		super(message);
	}
}
