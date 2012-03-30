/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import model.Book;
import controllers.Controller;

/**
 * The class that other book panels are based upon.
 * Contains an image, a button, and information about the book.
 * @author Brad
 *
 */
abstract class BookPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 5401241274318892383L;

    /**
     * The height of the book image.
     */
    private final int bookHeight = 200;

    /**
     * The width of the book image.
     */
    private final int bookWidth = 180;

    /**
     * The panels used to put the layout of the book panel together.
     */
    private final JPanel rentalInfoPanel, buttonsPanel;

    /**
     * The information label.
     */
    private final BookLabel rentalInfoLabel;

    /**
     * The button for the primary function of the book panel.
     */
    private final JButton primaryButton;

    /**
     * A style-modified label used throughout the panel.
     * @author Brad
     *
     */
    class BookLabel extends JLabel {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * Small font used in the panels.
         */
        private final int smallFont = 12;

        /**
         * Large font used in the panels.
         */
        private final int largeFont = 24;

        /**
         * Font styling for the book panel parts.
         * @param text the words on the label
         * @param isHeader whether the text is a header or body-text
         */
        public BookLabel(final String text, final boolean isHeader) {

            super(text);

            if (isHeader) {

                this.setFont(new Font(PanelsManager.BODYFONT, Font.BOLD,
                        largeFont));
                this.setForeground(PanelsManager.SELECTEDBLUE);

            } else {

                this.setFont(new Font(PanelsManager.BODYFONT, Font.PLAIN,
                        smallFont));
                this.setForeground(PanelsManager.SELECTEDBLUE);

            }

        }

    }

    /**
     * Panel for displaying a single RENTED book and its information.
     * @param book - the book to build this panel around.
     */
    public BookPanel(final Book book) {
        super();

        /*
         * Wrap this panel with another so that it doesn't get distorted by
         * layout managers.
         * TODO: Find some way to get rid of the magic number 830
         */
        JPanel wrapPanel = new JPanel();
        wrapPanel.setPreferredSize(new Dimension(830, bookHeight));

        wrapPanel.setLayout(new BorderLayout());
        wrapPanel.setBorder(new LineBorder(PanelsManager.BACKGROUNDBLUE, 1));

        /*
         * Make each book panel 200 pixels tall.  Let the panel its in
         * determine its width.
         */
        wrapPanel.setSize(new Dimension(this.getWidth(), bookHeight));

        /*
         * This will be the book icon cover         *
         * Far left i.e. WEST
         */
        JLabel bookIcon;
        JButton bookIconError;

        try {

            bookIcon = Controller.loadCover(book);
            bookIcon.setPreferredSize(new Dimension(bookHeight, bookWidth));
            wrapPanel.add(bookIcon, BorderLayout.WEST);

        } catch (Exception e) {

            bookIcon = null;
            /*
             * the book icon didn't load, destroy it and start adding the
             * replacement one
             */
            bookIconError = new JButton("");
            bookIconError.setPreferredSize(
                    new Dimension(bookHeight, bookWidth));
            wrapPanel.add(bookIconError, BorderLayout.WEST);

        }

        /*
         * Book title
         */
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(0, 1));
        BookLabel titleLabel = new BookLabel(book.title, true);
        titlePanel.add(titleLabel);

        /*
         * Information panel:  Description, author, ...
         */
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(0, 1));
        BookLabel descLabel = new BookLabel(book.description, false);
        BookLabel authorLabel = new BookLabel(book.author, false);
        infoPanel.add(descLabel);
        infoPanel.add(authorLabel);

        /*
         * Panel which contains title panel at top and info panel at bottom
         */
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BorderLayout());
        middlePanel.add(titlePanel, BorderLayout.NORTH);
        middlePanel.add(infoPanel, BorderLayout.CENTER);

        /*
         * Panel containing 'action' button.
         * eg: Read now, rent now, etc.
         */
        buttonsPanel = new JPanel();
        primaryButton = new JButton("");

        /*
         * Information about the rental
         * eg: price, quantity on hand or days remainings
         */
        rentalInfoPanel = new JPanel();
        rentalInfoLabel = new BookLabel("", false);

        /*
         * Right half of book panel.
         * Contains buttons at top and rental into at bottom
         */
        JPanel rightSidePanel = new JPanel();
        rightSidePanel.setLayout(new BorderLayout());
        rightSidePanel.add(buttonsPanel, BorderLayout.NORTH);
        rightSidePanel.add(rentalInfoPanel, BorderLayout.SOUTH);

        /*
         * Add the other two main sections:
         * Middle panel - title, details
         * Right Panel - buttons, rental info
         */
        wrapPanel.add(middlePanel, BorderLayout.CENTER);
        wrapPanel.add(rightSidePanel, BorderLayout.EAST);

        this.add(wrapPanel);

    }

    /**
     * Getter for rentalInfoPanel.
     * @return rentalInfoPanel
     */
    public JPanel getRentalInfoPanel() {

        return rentalInfoPanel;

    }

    /**
     * Getter for buttonsPanel.
     * @return buttonsPanel
     */
    public JPanel getButtonsPanel() {

        return buttonsPanel;

    }

    /**
     * Getter for rentalInfoLabel.
     * @return rentalInfoLabel
     */
    public BookLabel getRentalInfoLabel() {

        return rentalInfoLabel;

    }

    /**
     * Getter for primaryButton.
     * @return primaryButton
     */
    public JButton getPrimaryButton() {

        return primaryButton;

    }


}
