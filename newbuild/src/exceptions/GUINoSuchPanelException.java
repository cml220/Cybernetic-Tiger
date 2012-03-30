package exceptions;

public class GUINoSuchPanelException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 4838999005832862856L;

    public GUINoSuchPanelException() {

        super("Trying to load a panel that doesn't exist.");

    }

}
