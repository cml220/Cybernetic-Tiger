/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * This panel provides the buttons for selecting which display panel is shown
 * to the user
 * @author Brad Johnson
 * NextBooks 2011-2012
 * @modified Jake Bolam - Refactored tab buttons into array
 */
public class TabsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3357923531295006611L;	
	
	private static Tab[] tabArray;
	private static int activeTabs;

	public TabsPanel(){
		
		this.setLayout(new GridLayout(0,1));
		this.setBackground(PanelsManager.backgroundBlue);
		tabArray = new Tab[11]; // Maximum of 11 tabs
		activeTabs = 4; // There are 4 tabs that contain relative information
	
		
		// 1st Tab, Book search tab
		// On click opens up search results		
		tabArray[0] = new Tab("Book Search", PanelsManager.SEARCHRESULTS);		
		
		// 2nd Tab, "My Books" tab
		// On click opens up customer's book inventory		
		tabArray[1] = new Tab("My Books", PanelsManager.MYBOOKS);		
		
		// 3rd Tab, "My Account" tab
		// On click opens up customer's account settings 		
		tabArray[2] = new Tab("My Account", PanelsManager.MYACCOUNT);
		
		// 4th Tab, "My Cart" tab
		// On click opens up the shopping cart - start of the checkout process 	
		tabArray[3] = new Tab("My Cart", PanelsManager.MYCART);
		
		// 5th Tab, unused tab
		tabArray[4] = new Tab("");
		
		// 6th Tab, unused tab
		tabArray[5] = new Tab("");
		
		// 7th Tab, unused tab
		tabArray[6] = new Tab("");
		
		// 8th Tab, unused tab
		tabArray[7] = new Tab("");
		
		// 9th Tab, unused tab
		tabArray[8] = new Tab("");
		
		// 10th Tab, unused tab
		tabArray[9] = new Tab("");
		
		// 11th Tab, unused tab
		tabArray[10] = new Tab("");
		
		
		// Load in all the Tabs
		for(int ii=0;ii<tabArray.length;ii++) {
		this.add(tabArray[ii]);
		}
		
		
		// Setting the default tab, My Books (tab array 1)		
		PanelsManager.setDefaultPanel(tabArray[1]);
		
	}
	
	/*
	 * Changes the color of all functional tabs to "unselected blue"
	 * @postcond - the color of all functional tabs is PanelsManager.unselectedBlue
	 */
	public static void deselectAllTabs(){		
	
		//This only applies to functional tabs, not empty "placeholder" tabs		
		for(int ii=0;ii<activeTabs;ii++) {
		tabArray[ii].setBackground(PanelsManager.unselectedBlue);
		}		
	}
	
}
