package gui;

import java.text.DecimalFormat;

/**
 * A panel containing a single book and details about the book.
 * @author Brad
 *
 */
public class SearchBookPanel extends BookPanel {

    /**

     */
    private static final long serialVersionUID = -5162648801797138348L;

    /**
     * Constructor; builds a book panel for a specific book.
     * @param title the title of the book
     * @param desc the description of the book
     * @param author the author of the book
     * @param location the url of the book's pdf
     * @param price the price of the book
     */
    public SearchBookPanel(final String title, final String desc,
            final String author, final String location, final Double price) {

        super(title, desc, author, location);

        DecimalFormat df = new DecimalFormat("###,###,###.##");

        super.getPrimaryButton().setText("Rent book");
        super.getButtonsPanel().add(super.getPrimaryButton());

        super.getRentalInfoLabel().setText("Price: " + df.format(price));
        super.getRentalInfoPanel().add(super.getRentalInfoLabel());

    }

}
