package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import model.Book;
import controllers.Controller;

public class AdvSearchPanel extends StyledPanel {

    /**
     * ID.
     */
    private static final long serialVersionUID = 8285086013085907050L;


    /**
     * Titles for the locations of searches.
     */
    private final String[] locTitles = {"Available Rentals",
            "In My Rentals",
    "In My Shopping Cart"};

    /**
     * The spot where the user can enter a book's title to search.
     */
    private final LabeledInputField titleField;

    /**
     * The spot where the user can enter some words from the book's description
     * to search.
     */
    private final LabeledInputField keywordField;

    /**
     * The spot where the user can enter the author of the book to search.
     */
    private final LabeledInputField authorField;

    /**
     * The spot where the user can enter the isbn of the book to search.
     */
    private final LabeledInputField isbnField;

    /**
     * A choice of locations to search within.
     */
    private final JComboBox locationChoice;

    /**
     * The button which starts the search.
     */
    private final JButton searchBut;


    public AdvSearchPanel() {

        super();

        /*
         * Stack components vertically
         */
        this.setLayout(new GridLayout(0, 1));
        this.setBackground(Color.WHITE);
        this.setOpaque(false);

        JLabel infoLabel = new JLabel("Fill in the details for the book you are"
                + " trying to find:");
        infoLabel.setForeground(PanelsManager.UNSELECTEDBLUE);

        titleField = new LabeledInputField("Title");

        authorField = new LabeledInputField("Author");

        keywordField = new LabeledInputField("Keywords");

        isbnField = new LabeledInputField("ISBN");

        /*
         * Add the potential search locations to a combo box
         */
        JLabel locationLabel = new JLabel("Search Where?");
        locationChoice = new JComboBox();
        locationChoice.setBackground(Color.WHITE);

        for (int i = 0; i < locTitles.length; i++) {

            locationChoice.addItem(locTitles[i]);

        }

        searchBut = new JButton("Search");
        searchBut.addActionListener(new ActionListener() {

            @Override
            /**
             * Skeleton implementation
             * TODO: Invoke search
             */
            public void actionPerformed(final ActionEvent arg0) {

                Book searchBook = new Book();
                boolean anythingSearched = false;

                String message = "Not Yet Implemented\n"
                    + "You Searched for:";

                if (!titleField.getText().isEmpty()) {

                    anythingSearched = true;
                    message = message.concat("\nTitle: "
                            + titleField.getText());

                    searchBook.title = titleField.getText();

                }
                if (!authorField.getText().isEmpty()) {

                    anythingSearched = true;
                    message = message.concat("\nAuthor: "
                            + authorField.getText());

                    searchBook.author = authorField.getText();

                }
                if (!keywordField.getText().isEmpty()) {

                    anythingSearched = true;
                    message = message.concat("\nKeywords: "
                            + keywordField.getText());


                }
                if (!isbnField.getText().isEmpty()) {

                    anythingSearched = true;
                    message = message.concat("\nISBN: "
                            + isbnField.getText());

                    searchBook.ISBN = Integer.parseInt(isbnField.getText());

                }

                if (!anythingSearched) {

                    JOptionPane.showMessageDialog(null, "Nothing Searched", "No Values",
                            JOptionPane.INFORMATION_MESSAGE);

                } else {


                    try {

                        ArrayList books = Controller.searchForBook(searchBook);
                        PanelsManager.newSearchResults(books);

                    } catch (Exception e) {

                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Book Search failed\n"
                                + "Contact tech support\n" + e.getMessage(),
                                "Fatal Error", JOptionPane.ERROR_MESSAGE);

                    }

                }
            }


        });

        /**
         * Panel for aligning the location combo box correctly.
         */
        InnerPanel comboPanel = new InnerPanel();
        comboPanel.add(locationLabel);
        comboPanel.add(locationChoice);
        comboPanel.add(Box.createRigidArea(new Dimension(200, 50)));

        /**
         * Panel for aligning the button correctly.
         */
        InnerPanel buttonsPanel = new InnerPanel();
        buttonsPanel.add(searchBut);

        /**
         * An action which causes the search button to be pressed
         * This is used in keyboard shortcut mappings.
         */
        class StartSearch extends AbstractAction {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(final ActionEvent e) {

                searchBut.doClick();

            }

        }
        StartSearch startSearch = new StartSearch();

        /*
         * If the user presses enter while in any of the text fields,
         * start the search.
         */
        titleField.putInput(KeyStroke.getKeyStroke("ENTER"), "startSearch");
        titleField.putAction("startSearch", startSearch);

        authorField.putInput(KeyStroke.getKeyStroke("ENTER"), "startSearch");
        authorField.putAction("startSearch", startSearch);

        keywordField.putInput(KeyStroke.getKeyStroke("ENTER"), "startSearch");
        keywordField.putAction("startSearch", startSearch);

        this.add(infoLabel);
        this.add(titleField);
        this.add(authorField);
        this.add(keywordField);
        this.add(isbnField);
        this.add(comboPanel);
        this.add(buttonsPanel);
        this.add(Box.createRigidArea(new Dimension(200, 200)));

    }

    @Override
    /**
     * If this panel requests focus, give the cursor to the title field.
     */
    public void requestFocus() {

        titleField.requestFocus();

    }

}
