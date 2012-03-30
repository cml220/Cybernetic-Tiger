package exceptions;

public class ImageLoadFailedException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 673774854766029951L;

    /**
     * Exception for when a controller fails to load an image.
     */
    public ImageLoadFailedException() {

        super("Failed to load image.");

    }

}
