package gui;

/*
 * NextBooks GUI system
 * @author Jake Bolam
 * 
 */

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

public class CheckoutVerifyExtrasPanel extends JPanel {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2519054394839378443L;
	// member field the for actual total price (so it can be updated dynamically)
	public JLabel totalPrice;
	
	public CheckoutVerifyExtrasPanel()
	{
		/*
		 * creates the totalPrice and the confirm and back buttons
		 */
		
		super(); // call JPanel default constructor		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5)); // Create Elements Left to Right, CENTERED, 20 pixels between width, and 5 between height
		
		// Add the total price tag		
		this.add(new JLabel("Total Price:"));
		
		// Now add the actual total price, note this is declared in memberFields
		totalPrice = new JLabel("$x");
		totalPrice.setFont(new Font(totalPrice.getFont().getName(), Font.ITALIC, totalPrice.getFont().getSize())); // make text just italic, leave other settings
		this.add(totalPrice);
		
		// Add a couple of blank elements for further space to the proceed button hehe :)
		this.add(new JLabel(""));
		this.add(new JLabel(""));
		this.add(new JLabel(""));
		
		// Now add the proceed button
		JButton confirmButton = new JButton("Confirm");
		this.add(confirmButton);
		
		// Now add the back button
		JButton backButton = new JButton("Back");
		this.add(backButton);
		
	}
	
	public void setTotalPrice(float inPrice)
	{
		if (inPrice < 0)
		{
			throw new IllegalArgumentException("Price cannot be negative.");
		}
		// Rounding to 2.dp??
		totalPrice.setText("$ " + inPrice);
	}
}
