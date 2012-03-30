package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import model.Book;
import controllers.Controller;

/**
 * Panel for searching by specific criteria.
 * @author Brad Johnson baj231 11044123
 *
 */
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
    @SuppressWarnings("rawtypes")
    private final JComboBox locationChoice;

    /**
     * The button which starts the search.
     */
    private final JButton searchBut;

    /**
     * Constructor.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
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
             * Search for a book using the fields.
             */
            public void actionPerformed(final ActionEvent arg0) {

                buildSearchFromForms();

            }




        });

        /**
         * Panel for aligning the location combo box correctly.
         */
        InnerPanel comboPanel = new InnerPanel();
        comboPanel.add(locationLabel);
        comboPanel.add(locationChoice);
        //comboPanel.add(Box.createRigidArea(new Dimension(1,1)));

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
        //this.add(PanelsManager.getAlignmentBlock());

    }

    @Override
    /**
     * If this panel requests focus, give the cursor to the title field.
     */
    public void requestFocus() {

        titleField.requestFocus();

    }

    /**
     * Construct a search using the advanced search fields and invoke a search.
     */
    private void buildSearchFromForms() {

        Book searchBook = new Book();
        boolean anythingSearched = false;

        /*
         * Get Title from field
         */
        if (!titleField.getText().isEmpty()) {

            anythingSearched = true;
            searchBook.title = titleField.getText();

        }

        /*
         * Get Author from field
         */
        if (!authorField.getText().isEmpty()) {

            anythingSearched = true;
            searchBook.author = authorField.getText();

        }

        /*
         * Get Keywords from field
         */
        if (!keywordField.getText().isEmpty()) {

            anythingSearched = true;
            searchBook.description = keywordField.getText();

        }

        /*
         * Get ISBN from field
         */
        if (!isbnField.getText().isEmpty()) {

            anythingSearched = true;
            searchBook.ISBN = Integer.parseInt(isbnField.getText());

        }

        /*
         * If all the fields were blank, don't search
         */
        if (!anythingSearched) {

            JOptionPane.showMessageDialog(null, "Nothing Searched",
                    "No Values", JOptionPane.INFORMATION_MESSAGE);

        } else {


            try {

                /*
                 * Perform a search
                 */
                ArrayList<Book> books =
                        Controller.searchForBook(searchBook);

                /*
                 * Show the results
                 */
                PanelsManager.newSearchResults(books);

            } catch (Exception e) {

                /*
                 * Print error message if error occurs
                 */
                e.printStackTrace();
                PanelsManager.displayError("Book Search failed\n"
                        + "Contact tech support");

            }

        }
    }

}
