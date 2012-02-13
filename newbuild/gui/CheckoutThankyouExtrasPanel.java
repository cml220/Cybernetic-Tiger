package gui;

/*
 * NextBooks GUI system
 * @author Jake Bolam
 * 
 */

import java.awt.FlowLayout;

import javax.swing.*;

public class CheckoutThankyouExtrasPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -838483260954532251L;
	
	public CheckoutThankyouExtrasPanel()
	{
		/*
		 * creates the home button
		 */
		
		super(); // call JPanel default constructor		
		this.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 5)); // Create Elements Left to Right, ALIGNED TO THE RIGHT, 20 pixels between width, and 5 between height
					
		// Now add the home button - returns to the main window
		JButton homeButton = new JButton("Home");
		this.add(homeButton);
		
	}
}
