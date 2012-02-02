/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.GridLayout;

import javax.swing.JLabel;

public class MyAccountPanel extends DisplayPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6750536388415434300L;

	public MyAccountPanel(){
		
		this.setLayout(new GridLayout(0,1));
		
		JLabel placeholder = new JLabel("Account Details");
		
		this.add(placeholder);
		
	}
	
}
