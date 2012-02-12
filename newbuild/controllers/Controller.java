package controllers;
import model.*;

public class Controller {
	
	public static AccountController accountController;
	public static CartController cartController;
	public static CatalogueController catalogueController;
	public static LoginController loginController;
	public static PaymentController paymentController;
	public static ReaderController readerController;
	public static RentalsController rentalsController;
	
	//TODO make this a singleton!
	public static User currentUser;
		
	
	public static void openAccount() {
	}
	
	public static void openCart() {
		
	}
	
	public static void openCatalogue() {
	}
	
	public static void openLogin() {
		
	}
	
	public static void openPayment() {
	}
	
	public static void openReader(Book book) {
		readerController.openBook(book);
	}
	public static void openRentals() {
	
	}	
}
