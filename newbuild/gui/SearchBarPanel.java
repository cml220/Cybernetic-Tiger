/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class SearchBarPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8388903742748016888L;

	public SearchBarPanel(){
		
		this.setLayout(new BorderLayout());
		
		/*
		 * Search entry field
		 */
		JTextField searchField = new JTextField();
		searchField.requestFocus();
		searchField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		searchField.setBorder(PanelsManager.defaultBorder);
		
		/*
		 * Search start button
		 */
		JButton searchButton = new JButton("Search");
		searchButton.setBackground(PanelsManager.raisedButtonsBlue);
		searchButton.setBorder(new LineBorder(searchButton.getBackground(),5,true));
		searchButton.setPreferredSize(new Dimension(100, 30));
		
		/*
		 * Advanced search button
		 */
		JButton advancedSearchButton = new JButton("Advanced");
		advancedSearchButton.setBackground(PanelsManager.raisedButtonsBlue);
		advancedSearchButton.setBorder(new LineBorder(advancedSearchButton.getBackground(),5,true));
		advancedSearchButton.setPreferredSize(new Dimension(100, 30));
		
		/*
		 * Panel for keeping the Buttons together
		 */
		JPanel searchBarButtonsPanel = new JPanel();
		searchBarButtonsPanel.setBackground(PanelsManager.selectedBlue);
		searchBarButtonsPanel.setLayout(new FlowLayout());
		searchBarButtonsPanel.add(searchButton);
		searchBarButtonsPanel.add(advancedSearchButton);
		
		/*
		 * This puts the buttons on the far right and allows the search bar to take up the remainder
		 */
		this.add(searchField, BorderLayout.CENTER);
		this.add(searchBarButtonsPanel, BorderLayout.EAST);
		
		
	}
	
}
