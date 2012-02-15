package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * A scroll panel with styling options to match the NextBooks GUI.
 * @author Brad
 *
 */
public class DisplayScrollPane extends JScrollPane {

    /**
     *
     */
    private static final long serialVersionUID = -2561392613587167883L;

    /**
     * The scroll speed of the scroll bar.
     */
    private final int scrollSpeed = 20;

    /**
     * Creates a stylised, scrollable panel.
     * @param innerPanel the panel contained inside of this scrollpane
     */
    public DisplayScrollPane(final JPanel innerPanel) {

        super(innerPanel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        this.setBorder(PanelsManager.DEFAULTBORDER);

        this.getVerticalScrollBar().setUnitIncrement(scrollSpeed);

    }

}
