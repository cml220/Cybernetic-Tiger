package exceptions;

public class CatalogueException extends Exception {
	/**
	 * Serial ID, used to get rid of warnings/improve efficiency
	 */
	private static final long serialVersionUID = 3657628207456186811L;

	public CatalogueException(String message) {
		super(message);
	}
}
