package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 * A panel used for conducting multi-parameter searches.
 * @author Brad Johnson
 *
 */
public class AdvSearchPanel extends DisplayPanel {

    /**
     * ID.
     */
    private static final long serialVersionUID = 8285086013085907050L;

    /**
     * Constants for specifying location of search.
     */
    private final int STORE = 0;
    private final int MYBOOKS = 1;
    private final int MYCART = 2;

    /**
     * Titles for the locations of searches.
     */
    private final String[] locTitles = {"Available Rentals",   //STORE
            "In My Rentals",                                    //MYBOOKS
    "In My Shopping Cart"};                                     //MYCART


    /**
     * A Label-InputField pair.
     * @author Brad Johnson
     */
    class AdvLabeledInputField extends JPanel {

        /**
         * ID.
         */
        private static final long serialVersionUID = -1289482107395840721L;

        /**
         * The text entry field of the pair.
         */
        private final JTextField field;

        /**
         * Constructor.
         * @param caption - the label to put beside the text entry box.
         */
        public AdvLabeledInputField(final String caption) {

            /*
             * Align things to the right
             */
            this.setLayout(new FlowLayout(FlowLayout.RIGHT));

            /*
             * Create the label first
             */
            JLabel label = new JLabel(caption);

            /*
             * Then create the entry field.
             */
            field = new JTextField();
            field.setColumns(40);

            /*
             * Add the label and entry field to a the panel holding the pair.
             */
            this.add(label);
            this.add(field);

            /*
             * Add a uniform amount of space on the right side
             */
            this.add(Box.createRigidArea(new Dimension(200, 50)));


        }

        @Override
        /*
         * When this pair requests focus, give the focus to the entry field.
         */
        public void requestFocus() {

            field.requestFocus();

        }

        /**
         * Add a keyboard-shortcut mapping to the text field.
         * @param keyStroke - the keystroke that must be used to invoke the
         * action tied to actionDesc.
         * @param actionDesc - a string which links to an action in the
         * ActionMap
         */
        public void putInput(final KeyStroke keyStroke,
                final String actionDesc) {

            field.getInputMap().put(keyStroke, actionDesc);

        }

        /**
         * Add an action to the keyboard shortcut mapping.
         * @param actionDesc - a string which links to a keystroke in InputMap
         * @param action - the action performed when actionDesc is called
         */
        public void putAction(final String actionDesc,
                final AbstractAction action) {

            field.getActionMap().put(actionDesc, action);

        }

        /**
         * Get the value from the text field.
         * @return the String from the text field
         */
        public String getText() {

            return field.getText();

        }

    }

    /**
     * The spot where the user can enter a book's title to search.
     */
    private final AdvLabeledInputField titleField;

    /**
     * The spot where the user can enter some words from the book's description
     * to search.
     */
    private final AdvLabeledInputField keywordField;

    /**
     * The spot where the user can enter the author of the book to search.
     */
    private final AdvLabeledInputField authorField;

    /**
     * A choice of locations to search within.
     */
    private final JComboBox locationChoice;

    /**
     * The button which starts the search.
     */
    private final JButton searchBut;

    /**
     * Panel for preparing multi-variable searches.
     */
    public AdvSearchPanel() {

        /*
         * Stack components vertically
         */
        this.setLayout(new GridLayout(0, 1));

        JLabel infoLabel = new JLabel("Fill in the details for the book you are"
                + "trying to find:");

        titleField = new AdvLabeledInputField("Title");

        authorField = new AdvLabeledInputField("Author");

        keywordField = new AdvLabeledInputField("Keywords");

        /*
         * Add the potential search locations to a combo box
         */
        JLabel locationLabel = new JLabel("Search Where?");
        locationChoice = new JComboBox();
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

                boolean anythingSearched = false;

                String message = "Not Yet Implemented\n"
                    + "You Searched for:";

                if (!titleField.getText().isEmpty()) {

                    anythingSearched = true;
                    message = message.concat("\nTitle: "
                            + titleField.getText());

                }
                if (!authorField.getText().isEmpty()) {

                    anythingSearched = true;
                    message = message.concat("\nAuthor: "
                            + authorField.getText());

                }
                if (!keywordField.getText().isEmpty()) {

                    anythingSearched = true;
                    message = message.concat("\nKeywords: "
                            + keywordField.getText());

                }

                if (!anythingSearched) {

                    message = message.concat("\nNothing.");

                }

                message = message.concat("\nLocation: "
                        + locTitles[locationChoice.getSelectedIndex()]);

                JOptionPane.showMessageDialog(null, message, "Prototype",
                        JOptionPane.INFORMATION_MESSAGE);

            }


        });

        /**
         * Panel for aligning the location combo box correctly.
         */
        JPanel comboPanel = new JPanel();
        comboPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        comboPanel.add(locationLabel);
        comboPanel.add(locationChoice);
        comboPanel.add(Box.createRigidArea(new Dimension(200, 50)));

        /**
         * Panel for aligning the button correctly.
         */
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
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
