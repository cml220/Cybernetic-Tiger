/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.GridLayout;
import javax.swing.JLabel;

public class SearchResultsPanel extends DisplayPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7862774713466486186L;

	public SearchResultsPanel(){
		
		this.setLayout(new GridLayout(0,1));
		
		JLabel placeholder = new JLabel("Search Results");
		
		this.add(placeholder);
		
		//TODO: Search results
		
	}
	
}
