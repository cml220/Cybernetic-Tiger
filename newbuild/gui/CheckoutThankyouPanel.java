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


public class CheckoutThankyouPanel extends JPanel 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 997202355725952480L;

	public CheckoutThankyouPanel()
	{
		
		/*
		 * Stack panels vertically, 1 column, rows don't have fixed height		
		 */
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JLabel thankyouText = new JLabel("Thankyou");
		this.add(thankyouText);
		
		JTextField thankyouMessage;
		thankyouMessage = new JTextField("Your purchase has been processed, you will recive\n an email with your receipt shortly, all\n rented books will now be available.");
		this.add(thankyouMessage);			
		
	}
	
}
