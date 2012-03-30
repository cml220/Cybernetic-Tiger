/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * This is the left "half" of the GUI.
 * (SidePanel.java makes up the right half)
 * @author Brad Johnson
 */
public class MainPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 2949687444255909471L;

    /**
     * The main panel where the functional panels get swapped in.
     */
    private static JPanel displayPanel;

    /**
     * The panel containing the search bar.
     */
    private static JPanel searchBarPanel;

    /**
     *  the panel count for the application to be able to add panels on the fly
     */
    private static int panelCount;

    /**
     * Constructs the main panel, which contains all of the sub-panels of the
     * nextbooks GUI.
     */
    public MainPanel() {

        searchBarPanel = new SearchBarPanel();

        /*
         * populate the display panel with all of the potential panels that
         * could go in that spot
         */
        displayPanel = new JPanel();
        displayPanel.setLayout(new CardLayout());

        for (panelCount = 0; panelCount < PanelsManager.getNumPanels(); panelCount++) {

            displayPanel.add(PanelsManager.getPanel(panelCount), Integer.toString(panelCount));

        }

        /*
         * Add the search bar and display panel to this panel with search bar
         * at top and display panel filling the rest of the panel
         */
        this.setLayout(new BorderLayout());
        this.add(searchBarPanel, BorderLayout.NORTH);
        this.add(displayPanel, BorderLayout.CENTER);

    }

    /**
     * Changes which panel is shown in the displayPanel spot.
     * @param choice the index of the panel which will be swapped i
     * (See: PanelsManager)
     */
    public static void changeDisplayPanel(final int choice) {

        CardLayout cl = (CardLayout) displayPanel.getLayout();
        cl.show(displayPanel, Integer.toString(choice));
        PanelsManager.getPanel(choice).requestFocus();

    }

    /**
     * Changes to the panel that has been passed in.
     * @param panel - the panel to change to.
     * (See: PanelsManager)
     */
    public static void changeDisplayPanel(final JPanel panel) {

        // increase the panelCount
        panelCount++;

        // add the panel that has been passed in
        displayPanel.add(panel, Integer.toString(panelCount));

        // show the panel
        CardLayout cl = (CardLayout) displayPanel.getLayout();
        cl.show(displayPanel, Integer.toString(panelCount));

    }

    /**
     * Replace a panel in the cardlayout.
     * @param origPanel the original panel
     * @param newPanel the replacement panel
     * @param index the index to do the swap at
     */
    public static void replaceDisplayPanel(final JComponent origPanel,
            final JComponent newPanel, final int index) {

        CardLayout cl = (CardLayout) displayPanel.getLayout();
        cl.removeLayoutComponent(origPanel);
        displayPanel.add(newPanel, Integer.toString(index));

    }

}
