/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 * Start of the checkout process, My Cart
 * 
 * Checkout written by Jake Bolam
 */

package gui;



import javax.swing.*;

public class CheckoutThankyouPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 997202355725952480L;


	public CheckoutThankyouPanel()
	{
		// using spring layout
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		// place the tiger image
		JLabel tigerImage = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, tigerImage, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, tigerImage, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, tigerImage, 821, SpringLayout.WEST, this);
		tigerImage.setHorizontalAlignment(SwingConstants.CENTER);
		tigerImage.setIcon(new ImageIcon(CheckoutThankyouPanel.class.getResource("/gui/thankyou.png")));
		add(tigerImage);
		
		// place the thankyou text
		JLabel thankyouMessage = new JLabel("Your purchase has been processed, you will recive an email with your receipt shortly, all rented books will now be available.");
		springLayout.putConstraint(SpringLayout.SOUTH, tigerImage, -25, SpringLayout.NORTH, thankyouMessage);
		springLayout.putConstraint(SpringLayout.NORTH, thankyouMessage, 459, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, thankyouMessage, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, thankyouMessage, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, thankyouMessage, 0, SpringLayout.EAST, tigerImage);
		thankyouMessage.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(thankyouMessage);

		




	}
}
