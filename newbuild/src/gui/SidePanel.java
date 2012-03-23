/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * This is the right "half" of the GUI.
 * (MainPanel.java makes up the left half)
 * @author Brad Johnson
 */
public class SidePanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 5214506819372822801L;

    /**
     * Construct the panel.
     */
    public SidePanel() {

        /*
         * Align objects top to bottom
         */
        this.setLayout(new GridLayout(0, 1));

        /*
         * Add the display selection tabs
         */
        this.add(new TabsPanel());


    }

}
