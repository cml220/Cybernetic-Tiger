/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

     */
    private static final long serialVersionUID = -8388903742748016888L;

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

        this.setLayout(new BorderLayout());

        /*
         * Search entry field
         */
        JTextField searchField = new JTextField();
        searchField.requestFocus();
        searchField.setFont(new Font("Times New Roman", Font.BOLD,
                searchFontSize));
        searchField.setBorder(PanelsManager.DEFAULTBORDER);

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

}
