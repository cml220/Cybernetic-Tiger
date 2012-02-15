/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Actionlistener for tabs which allows the actionlistener to change the tab
 * itself.
 * @author Brad
 *
 */
public class TabActionListener implements ActionListener {

    /**
     * The tab who contained this actionlistener.
     */
    private Tab caller;

    /**
     * The intended action of the tab.
     */
    private int intention;

    /**
     * Creates a special actionlistener specifically suited for tabs.
     * Allows the actionlistener to change the color of the tab when the tab
     * is pressed.
     * @param inIntention - the intention of the tab, ie: open "My Books".
     * Use values from PanelsManager.java.
     * @param inCaller - the tab using this actionlistener
     */
    public TabActionListener(final int inIntention, final Tab inCaller) {

        this.caller = inCaller;
        this.intention = inIntention;

    }


    /**
     * @param arg0 - the action which triggers this listener
     * @postcond - MainPanel.java's displayPanel will be changed to the
     * appropriate panel
     * @postcond - This tab will turn "selected blue" and the others will turn
     * "unselected blue"
     */
    public void actionPerformed(final ActionEvent arg0) {

        MainPanel.changeDisplayPanel(intention);
        TabsPanel.deselectAllTabs();
        caller.setBackground(PanelsManager.SELECTEDBLUE);

    }

}
