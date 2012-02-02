/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.*;

/**
 * This is the left "half" of the GUI.
 * (SidePanel.java makes up the right half)
 * @author Brad Johnson
 */
public class MainPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2949687444255909471L;

	private static JPanel displayPanel;
	private static JPanel searchBarPanel;
	
	public MainPanel(){

		searchBarPanel = new SearchBarPanel();
		
		/*
		 * populate the display panel with all of the potential panels that
		 * could go in that spot
		 */
		displayPanel = new JPanel();
		displayPanel.setLayout(new CardLayout());
		
		for(int i = 0; i < PanelsManager.getNumPanels(); i++){
			
			displayPanel.add(PanelsManager.GetPanel(i), Integer.toString(i));
			
		}
		
		/*
		 * Add the search bar and display panel to this panel with search bar
		 * at top and display panel filling the rest of the panel
		 */
		this.setLayout(new BorderLayout());
		this.add(searchBarPanel, BorderLayout.NORTH);
		this.add(displayPanel, BorderLayout.CENTER);
		
	}
	
	public static void changeDisplayPanel(int choice){
		
		CardLayout cl = (CardLayout) displayPanel.getLayout();
		cl.show(displayPanel, Integer.toString(choice));
		
	}
	
}
