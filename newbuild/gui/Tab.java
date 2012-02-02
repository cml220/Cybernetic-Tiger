/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class Tab extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6303977417629057524L;

	
	/*
	 * Constructor for functional tab
	 * @param title - the label to display on the tab
	 * @param intention - the panel that this button will cause to appear in the main 
	 * panel spot of the GUI, using the int codes defined in PanelsManager.java
	 */
	public Tab(String title, final int intention){
		
		super(title);
		
		/*
		 * All tabs are 120 wide by 40 tall
		 */
		this.setPreferredSize(new Dimension(120,40));
		
		/*
		 * All buttons default to unselectedBlue (defined in PanelsManager)
		 * The color will change when the button is selected (see TabActionListener)
		 */
		this.setBackground(PanelsManager.unselectedBlue);
		
		/*
		 * This gets ride of the border that shows up around the label when clicked
		 */
		this.setFocusPainted(false);
		
		/*
		 * Text color is white
		 */
		this.setForeground(new Color(255,255,255));
		
		/*
		 * invisible border
		 */
		this.setBorder(new EmptyBorder(10,10,10,10));
		
		/*
		 * This constructor is used for functional buttons, so yes they are enabled
		 */
		this.setEnabled(true);
		
		/*
		 * Change the GUI's display panel to 'intention' and recolor this button
		 * See TabActionListener.java
		 */
		this.addActionListener(new TabActionListener(intention, this));
		
	}
	
	/*
	 * Constructor for non-functional tabs, tabs which take up space but don't do anything
	 * when clicked
	 * @param title - the label to display on the tab
	 */
	public Tab(String title){
		
		super(title);
		
		/*
		 * All tabs are 120 wide by 40 tall
		 */
		this.setPreferredSize(new Dimension(120,40));
		
		/*
		 * All non-functional tabs are "background blue", this doesn't change
		 */
		this.setBackground(PanelsManager.backgroundBlue);
		
		/*
		 * Label is white
		 */
		this.setForeground(new Color(255,255,255));
		
		/*
		 * Invisible border
		 */
		this.setBorder(new EmptyBorder(10,10,10,10));
		
		/*
		 * non-functional tabs are not clickable
		 */
		this.setEnabled(false);
		
	}
	
}
