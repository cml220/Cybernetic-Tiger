package gui;

/**
 * A panel containing a single book and details about the book.
 * @author Brad
 *
 */
public class RentedBookPanel extends BookPanel {

    /**
     *
     */
    private static final long serialVersionUID = -1259781312842495888L;

    /**
     * Constructor;  builds a book panel for a specific book.
     * @param title the title of the book
     * @param desc the description of the book
     * @param author the author of the book
     * @param location the URL of the PDF for the book
     * @param daysRemain the number of days remaining on the rental
     */
    public RentedBookPanel(final String title, final String desc,
            final String author, final String location, final int daysRemain) {

        super(title, desc, author, location);

        super.getPrimaryButton().setText("Read Now");

        super.getButtonsPanel().add(super.getPrimaryButton());

        super.getRentalInfoLabel().setText("Days remaining: "
                + Integer.toString(daysRemain));
        super.getRentalInfoPanel().add(super.getRentalInfoLabel());

    }

}
