/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabActionListener implements ActionListener{

	private Tab caller;
	private int intention;
	
	/*
	 * Creates a special actionlistener specifically suited for tabs.
	 * Allows the actionlistener to change the color of the tab when the tab 
	 * is pressed.
	 * @param intention - the intention of the tab, ie: open "My Books".  Use values from PanelsManager.java.
	 * @param caller - the tab using this actionlistener

	 */
	public TabActionListener(int intention, Tab caller){
		
		this.caller = caller;
		this.intention = intention;
		
	}


	/*
	 * @postcond - MainPanel.java's displayPanel will be changed to the appropriate panel
	 * @postcond - This tab will turn "selected blue" and the others will turn "unselected blue"
	 */
	public void actionPerformed(ActionEvent arg0) {

		MainPanel.changeDisplayPanel(intention);
		TabsPanel.deselectAllTabs();
		caller.setBackground(PanelsManager.selectedBlue);
		
	}
	
}
