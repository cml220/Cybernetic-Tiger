/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelsManager {

	private static boolean initialized;
	
	/*
	 * Colors used throughout the program
	 */
	public static final Color unselectedBlue = new Color(82, 112, 139);
	public static final Color selectedBlue = new Color(43, 105, 162);
	public static final Color backgroundBlue = new Color(33, 44, 66);
	public static final Color raisedButtonsBlue = new Color(121,199,255);
	
	/*
	 * Borders used throughout the program
	 */
	public static final LineBorder defaultBorder = new LineBorder(PanelsManager.selectedBlue,5);
	
	/*
	 * The default tab
	 */
	private static Tab defaultTab;
	
	/*
	 * indices for the "search area" panel
	 */
	public static final int MYBOOKS = 0;
	public static final int ADVSEARCH = 1;
	public static final int SEARCHRESULTS = 2;
	public static final int MYACCOUNT = 3;
	public static final int SHOPPINGCART = 4;
	
	/*
	 * how many panels the array will hold
	 * THIS MUST BE CHANGED MANUALLY
	 */
	private static final int numPanels = 5;	
	
	/*
	 * An array holding each of the panels that can go in the "search results" space
	 */
	private static JComponent[] panelsArray;
	
	public static void Initialize(){

		/*
		 * Set the default tab to null.
		 * We do this so that the program can check if the default is being set twice.
		 * This is not allowed.
		 */
		defaultTab = null;
		
		panelsArray = new JComponent[numPanels];
		
		/*
		 * Define each of the display panels that will be used in the GUI
		 */
		panelsArray[MYBOOKS] = new DisplayScrollPane(new MyBooksPanel());
		
		panelsArray[ADVSEARCH] = new JPanel(); //new AdvancedSearchPanel();
		
		panelsArray[SEARCHRESULTS] = new SearchResultsPanel();
		
		panelsArray[MYACCOUNT] = new MyAccountPanel(); //new MyAccountPanel();
		
		panelsArray[SHOPPINGCART] = new JPanel(); //new ShoppingCartPanel();
		
		initialized = true;

	}
	
	/*
	 * Returns the desired JPanel when passed in a constant defined in this
	 * class
	 * @precond PanelsManager is initialized ==> panelsArray is initialized
	 * @precond panelNum is not outside the range of panelsArray
	 * @precond panelNum is not negative
	 * @returns a descendent of JPanel from panelsArray, using panelNum as an
	 * index of panelsArray.
	 */
	public static JComponent GetPanel(int panelNum){
		
		/*
		 * precond PanelsManager is initialized ==> panelsArray is initialized
		 */
		if(!initialized){
			throw new RuntimeException("Tried to fetch panel when panels manager not initialized.");
		}
		
		/*
		 * precond panelNum is not outside the range of panelsArray
		 */
		if(panelNum >= numPanels){
			
			throw new RuntimeException("Invalid panel request, " + panelNum + 
					".  Max: " + (numPanels - 1));
			
		}
		
		/*
		 * panelNum is not negative
		 */
		if(panelNum < 0){
			
			throw new RuntimeException("Invalid panel request, " + panelNum + 
					".  Only positive integers allowed");
			
		}

		/*
		 * returns a descendent of JPanel from panelsArray, using panelNum as an
		 * index of panelsArray.
		 */
		return panelsArray[panelNum];

	}
	
	/*
	 * @return the number of panels managed by this class
	 */
	public static int getNumPanels(){
		
		return numPanels;
		
	}
	
	public static void setDefaultPanel(Tab defaultPanelTab){
		
		if(defaultTab != null){
			
			throw new RuntimeException("Default tab was set twice.  " 
					+ " Check for duplicate calls to 'setDefaultPanel'");
			
		}
		
		defaultTab = defaultPanelTab;
		
	}
	
	/*
	 * Click the tab to take us to the default panel
	 */
	public static void goToDefaultPanel(){
		
		if(defaultTab == null){
			
			throw new RuntimeException("Default tab was never set.  Set exactly one tab"
					+ " in TabsPanel.java using PanelsManager.setDefaultpanel(Tab)");
			
		}
		
		defaultTab.doClick();
		
	}
	
	
}
