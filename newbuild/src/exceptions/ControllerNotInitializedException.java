package exceptions;

public class ControllerNotInitializedException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -1277727858909953098L;

    public ControllerNotInitializedException() {
        
        super("Controller action attempted while controller not initialized.");
        
    }
    
}
