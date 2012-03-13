/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import javax.swing.JPanel;

/**
 * Class to handle the appearance of display panels (the big panel on the bottom
 * left of the GUI.
 */
public class DisplayPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 192006444394364516L;

    /**
     * Constructs the panel with style modification.
     */
    public DisplayPanel() {

        this.setBorder(PanelsManager.DEFAULTBORDER);

    }

}
