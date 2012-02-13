/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 * Start of the checkout process, My Cart
 * Checkout written by Jake Bolam
 */

package gui;


import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class CheckoutPaymentSTARTPanel extends JPanel 
{		

	/**
	 * 
	 */
	private static final long serialVersionUID = -3710831860090215423L;

	public CheckoutPaymentSTARTPanel()
	{
		
		//	Stack panels vertically, 1 column, rows don't have fixed height
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		// Load the payment panel
		this.add(new CheckoutPaymentPanel());
		
		
		// Load the verify and back buttons
		this.add(new CheckoutPaymentExtrasPanel());		
		
		// Load the checkout progress (at the payment stage)		
		this.add(new CheckoutCheckoutProgressPanel(1)); // 1 indicates that we are at the PAYMENT phase	
		
	}
}
