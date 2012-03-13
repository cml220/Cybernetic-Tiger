package exceptions;

public class PurchaseFailedException extends Exception {

    /**
     * ID.
     */
    private static final long serialVersionUID = -7652014485501501268L;

    /**
     * Exception for when a controller fails to load an image.
     */
    public PurchaseFailedException(){

        super("Purchase transaction encountered error.");

    }

}
