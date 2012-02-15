package controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import exceptions.CartException;
import exceptions.ControllerNotInitializedException;
import exceptions.ImageLoadFailedException;

import model.Book;
import model.User;

/**
 * Main controller.
 * Provides an interface between the GUI and the rest of the controllers.
 * @author Brad
 *
 */
public final class Controller {

    /**
     * Hiding the controller constructor.
     */
    private Controller() { }

    /**
     * Account controller.
     * User-related functions.
     */
    private static AccountController accountController;

    /**
     * Shopping cart controller.
     */
    private static CartController cartController;

    //private static CatalogueController catalogueController;
    //private static LoginController loginController;
    //private static PaymentController paymentController;

    /**
     * Reader controller.
     * Interface to the ICEPDF reader.
     */
    private static ReaderController readerController;
    //private static RentalsController rentalsController;

    /**
     * Variable for keeping track of if this singleton has been initialised.
     */
    private static boolean initialised;

    /**
     * @return the currentUser
     */
    public static User getCurrentUser() {

        return currentUser;

    }

    /**
     * Initialised the singleton controller for use.
     * Must be run before any other methods will work.
     */
    public static void initialise() {

        accountController = new AccountController();
        cartController = new CartController();
        //catalogueController = new CatalogueController();
        //loginController = new LoginController();
        //paymentController = new PaymentController();
        readerController = new ReaderController();
        //rentalsController = new RentalsController();

        initialised = true;

    }

    /**
     * The current user of the system.
     * Determined at login time.
     */
    private static User currentUser;

    public static void openAccount() {
    }

    public static void openCart() {

    }

    public static void openCatalogue() {
    }

    /**
     * Retrieves a User object from the account controller using a username
     * as identification.
     * @param username - the name of the user to get a User object for
     * @return a User object containing all of 'username's account information
     * @throws ControllerNotInitializedException if the controller isn't loaded
     */
    public static User getUserInfo(final String username)
            throws ControllerNotInitializedException {

        if (!initialised) {

            throw new ControllerNotInitializedException();

        }

        return accountController.getUserInfo(username);

    }

    /**
     * Changes a users information using the data inside of a User object.
     * @param user - the object containing the user data.
     * @throws ControllerNotInitializedException if the controller isn't loaded
     */
    public static void changeUserInfo(final User user)
            throws ControllerNotInitializedException {

        if (!initialised) {

            throw new ControllerNotInitializedException();

        }

        //TODO: Confirm need for (or remove) username parameter
        accountController.changeUserInfo(user.username, user);

    }

    /**
     * Add a book to the current user's shopping cart.
     * @param book the book to add to the cart
     * @throws CartException if the cart operation failed
     * @throws ControllerNotInitializedException if the controller isn't loaded
     */
    public static void addToCart(final Book book)
            throws CartException, ControllerNotInitializedException {

        if (!initialised) {

            throw new ControllerNotInitializedException();

        }

        cartController.addBookToCart(book);

    }

    /**
     * Remove a book from the current user's shopping cart.
     * @param book the book to remove from the cart
     * @throws CartException if the cart operation failed
     * @throws ControllerNotInitializedException if the controller isn't loaded
     */
    public static void removeFromCart(final Book book)
            throws CartException, ControllerNotInitializedException {

        if (!initialised) {

            throw new ControllerNotInitializedException();

        }

        cartController.removeBookFromCart(book);

    }

    /**
     * Fetch a list of books currently in the user's cart so they can be
     * displayed in the GUI.
     * @return a list of the books in the current user's cart
     * @throws CartException if the cart operation failed
     * @throws ControllerNotInitializedException if the controller isn't loaded
     */
    public static LinkedList<Book> getCartContents()
        throws CartException, ControllerNotInitializedException {

            if (!initialised) {

                throw new ControllerNotInitializedException();

            }

            //TODO:
            //cartController.getBooks();
            return null;

    }

    /**
     * Fetch a list of books that a user has rented on their account.
     * @return a list of books linked to the user
     * @throws ControllerNotInitializedException if the controller isn't loaded
     */
    public static LinkedList<Book> getUserBooks()
            throws ControllerNotInitializedException {

        if (!initialised) {

            throw new ControllerNotInitializedException();

        }

        return null;
        //TODO:
        //return rentalsController.getUserBooks();

    }

    /**
     * Load an image to represent a book.
     * @param book the book containing the image location
     * @return a JLabel with an image inside it
     * @throws ImageLoadFailedException if image failed to load
     * @throws ControllerNotInitializedException if the controller isn't loaded
     */
    public static JLabel loadCover(final Book book)
            throws ImageLoadFailedException,
            ControllerNotInitializedException {

        if (!initialised) {

            throw new ControllerNotInitializedException();

        }

        BufferedImage bookImage;

        try {

            bookImage = ImageIO.read(new File(book.img));

        } catch (IOException e) {

            throw new ImageLoadFailedException();

        }

        JLabel returnLabel = new JLabel(new ImageIcon(bookImage));

        return returnLabel;

    }

    /**
     * Fetch a list of books matching the non-null values in bookToMatch.
     * @param bookToMatch a book containing the values to search for (or nulls)
     * @return a list of books matching the non-null values in bookToMatch
     */
    public static LinkedList<Book> searchForBook(final Book bookToMatch) {

        //bookToMatch is a book with 'null' in all of the parameters which
        //haven't been specified for the search
        //TODO:
        //return CatalogueController.search(bookToMatch);
        return null;

    }

    public static void openLogin() {

    }

    public static void openPayment() {
    }

    /**
     * the ICEPDF reader opens 'book' and returns a JPanel to be swapped
     * into the GUI.
     * @param book the book to load in the ICEPDF reader
     * @return a newly constructed JPanel containing the ICEPDF reader with
     * 'book' loaded in it.
     * @throws ControllerNotInitializedException if the controller isn't loaded
     */
    public static JPanel openReader(final Book book)
            throws ControllerNotInitializedException {

        if (!initialised) {

            throw new ControllerNotInitializedException();

        }

        return readerController.openBook(book);

    }
    public static void openRentals() {

    }
}
