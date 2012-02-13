package gui;

/*
 * NextBooks GUI system
 * @author Jake Bolam
 * 
 */

import java.awt.FlowLayout;

import javax.swing.*;

public class CheckoutPaymentExtrasPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -838483260954532251L;
	
	public CheckoutPaymentExtrasPanel()
	{
		/*
		 * creates the verify and cancel buttons
		 */
		
		super(); // call JPanel default constructor		
		this.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 5)); // Create Elements Left to Right, ALIGNED TO THE RIGHT, 20 pixels between width, and 5 between height
					
		// Now add the verify button
		JButton verifyButton = new JButton("Verify");
		this.add(verifyButton);
		
		// Now add the back button - returns to the cart
		JButton backButton = new JButton("Back");
		this.add(backButton);
		
	}
}
