/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 * Start of the checkout process, My Cart
 * 
 * Checkout written by Jake Bolam
 */

package gui;

import java.awt.GridLayout;

import javax.swing.*;


public class CheckoutPaymentPanel extends JPanel 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 635271050458474969L;

	public CheckoutPaymentPanel()
	{
		
        this.setLayout(new GridLayout(0, 2));
		
		
		
		// Card number row
		JLabel cardNumberLabel = new JLabel("Card number: ");
		JTextField cardNumberField = new JTextField("", 15);		
		this.add(cardNumberLabel);
		this.add(cardNumberField);
		
		// Expiry row
		JLabel expirationDateLabel = new JLabel("Expiration date:");
		JTextField expirationDateField = new JTextField("", 15);
		this.add(expirationDateLabel);
		this.add(expirationDateField);
		
		
		
		
		
	}
	
}
