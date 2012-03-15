package exceptions;

public class BookOpenFailed extends Exception{

	/**
	 * 
	 */
    private static final long serialVersionUID = 514756545236554893L;
	
    /**
     * Exception for when a book fails to load, most likely cause by
     * MalformedURLException
     */
    public BookOpenFailed(){
    	
    	super ("Could not open selected book. Please contact Admin");
    }
}
