package exceptions;

public class PaymentInfoNotInitializedException extends Exception {

    /**
     * ID.
     */
    private static final long serialVersionUID = -8340464588289694122L;

    public PaymentInfoNotInitializedException() {

        super("Payment infomation was not intitialized before pushing to database.\n"
                + "Invoke setSessionPaymentInfo first.");

    }

}
