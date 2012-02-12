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
 */
public class TabsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3357923531295006611L;
	
	/*
	 * Tabs
	 */
	private static Tab bookSearchButton;
	private static Tab myBooksButton;
	private static Tab myAccountButton;
	private static Tab tab4Button;
	private static Tab tab5Button;
	private static Tab tab6Button;
	private static Tab tab7Button;
	private static Tab tab8Button;
	private static Tab tab9Button;
	private static Tab tab10Button;
	private static Tab tab11Button;

	public TabsPanel(){
		
		this.setLayout(new GridLayout(0,1));
		this.setBackground(PanelsManager.backgroundBlue);
	
		/*
		 * Book search tab
		 * On click opens up search results
		 */
		bookSearchButton = new Tab("Book Search", PanelsManager.SEARCHRESULTS);
		
		/*
		 * "My Books" tab
		 * On click opens up customer's book inventory
		 */
		myBooksButton = new Tab("My Books", PanelsManager.MYBOOKS);
		
		/*
		 * "My Account" tab
		 * On click opens up customer's account settings 
		 */
		myAccountButton = new Tab("My Account", PanelsManager.MYACCOUNT);
		
		tab4Button = new Tab("");
		
		tab5Button = new Tab("");
		
		tab6Button = new Tab("");
		
		tab7Button = new Tab("");
		
		tab8Button = new Tab("");
		
		tab9Button = new Tab("");
		
		tab10Button = new Tab("");
		
		tab11Button = new Tab("");
		
		this.add(bookSearchButton);
		this.add(myBooksButton);
		this.add(myAccountButton);
		this.add(tab4Button);
		this.add(tab5Button);
		this.add(tab6Button);
		this.add(tab7Button);
		this.add(tab8Button);
		this.add(tab9Button);
		this.add(tab10Button);
		this.add(tab11Button);
		
		/*
		 * Setting the default tab
		 */
		PanelsManager.setDefaultPanel(myBooksButton);
		
	}
	
	/*
	 * Changes the color of all functional tabs to "unselected blue"
	 * @postcond - the color of all functional tabs is PanelsManager.unselectedBlue
	 */
	public static void deselectAllTabs(){
		
		/*
		 * This only applies to functional tabs, not empty "placeholder" tabs
		 */
		bookSearchButton.setBackground(PanelsManager.unselectedBlue);
		myBooksButton.setBackground(PanelsManager.unselectedBlue);
		myAccountButton.setBackground(PanelsManager.unselectedBlue);
		
	}
	
}
