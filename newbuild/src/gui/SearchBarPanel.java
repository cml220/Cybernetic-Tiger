/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * The panel containing the search field and buttons to start searches.
 * @author Brad
 *
 */
public class SearchBarPanel extends JPanel {

    /**
     * VersionUID.
     */
    private static final long serialVersionUID = -8388903742748016888L;

    /**
     * The search text field itself.
     */
    private static JTextField searchField;

    /**
     * The string that shows in the search bar when nothing has been entered.
     */
    private static String panelSpecificPreSearchText;

    /**
     * Fonts used in this panel.
     */
    private static Font normalSearchFont, graySearchFont;

    /**
     * Search bar font size.
     */
    private final int searchFontSize = 18;

    /**
     * Buttons border width.
     */
    private final int buttonBorderWidth = 5;

    /**
     * Button standard width.
     */
    private final int buttonWidth = 100;

    /**
     * Button standard height.
     */
    private final int buttonHeight = 30;

    /**
     * Constructor; aligns the components of the search bar panel correctly.
     */
    public SearchBarPanel() {

        normalSearchFont = new Font("Times New Roman", Font.BOLD,
                searchFontSize);

        graySearchFont = new Font("Times New Roman", Font.ITALIC,
                searchFontSize);

        this.setLayout(new BorderLayout());

        /*
         * Search entry field
         */
        searchField = new JTextField();
        searchField.setFont(new Font("Times New Roman", Font.BOLD,
                searchFontSize));
        searchField.setBorder(PanelsManager.DEFAULTBORDER);

        searchField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(final FocusEvent arg0) {

                /*
                 * When the user gives the search bar focus, clear it out and
                 * set the font to black
                 */
                if (searchField.getText().equals(panelSpecificPreSearchText)) {

                    searchField.setText("");
                    searchField.setForeground(Color.BLACK);
                    searchField.setFont(normalSearchFont);

                }

            }

            @Override
            public void focusLost(final FocusEvent arg0) {

                /*
                 * When the user takes focus away from an empty searchbox, put
                 * the placeholder text there
                 */
                if (searchField.getText().isEmpty()) {

                    showPreSearchText();

                }


            }


        });

        /*
         * Search start button
         */
        JButton searchButton = new JButton("Search");
        searchButton.setBackground(PanelsManager.RAISEDBUTTONBLUE);
        searchButton.setBorder(new LineBorder(searchButton.getBackground(),
                buttonBorderWidth,
                true));
        searchButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        /*
         * Advanced search button
         */
        JButton advancedSearchButton = new JButton("Advanced");
        advancedSearchButton.setBackground(PanelsManager.RAISEDBUTTONBLUE);
        advancedSearchButton.setBorder(new LineBorder(
                advancedSearchButton.getBackground(), buttonBorderWidth, true));
        advancedSearchButton.setPreferredSize(new Dimension(buttonWidth,
                buttonHeight));
        advancedSearchButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {

                MainPanel.changeDisplayPanel(PanelsManager.ADVSEARCH);
                SearchBarPanel.setPreSearchText(PanelsManager.ADVSEARCH);
                SearchBarPanel.showPreSearchText();

            }

        });

        /*
         * Panel for keeping the Buttons together
         */
        JPanel searchBarButtonsPanel = new JPanel();
        searchBarButtonsPanel.setBackground(PanelsManager.SELECTEDBLUE);
        searchBarButtonsPanel.setLayout(new FlowLayout());
        searchBarButtonsPanel.add(searchButton);
        searchBarButtonsPanel.add(advancedSearchButton);

        /*
         * This puts the buttons on the far right and allows the search bar to
         * take up the remainder
         */
        this.add(searchField, BorderLayout.CENTER);
        this.add(searchBarButtonsPanel, BorderLayout.EAST);

    }

    /**
     * Swap out whatever is in this search bar with the 'pre search text'
     * associated with the current panel.
     */
    public static void showPreSearchText() {

        //TODO: log4j showing intended text.
        searchField.setText(panelSpecificPreSearchText);
        searchField.setForeground(Color.LIGHT_GRAY);
        searchField.setFont(graySearchFont);

    }

    /**
     * set the the 'pre search text' based on which panel is being loaded.
     * @param panelNum - the index of the panel, as defined in
     * PanelsManager.java
     */
    public static void setPreSearchText(final int panelNum) {

        panelSpecificPreSearchText = PanelsManager.getPreSearchString(panelNum);

    }

}
