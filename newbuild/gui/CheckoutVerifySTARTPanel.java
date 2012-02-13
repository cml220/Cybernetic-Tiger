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


public class CheckoutVerifySTARTPanel extends JPanel 
{		
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7321406436510933720L;

	public CheckoutVerifySTARTPanel()
	{
		
		//	Stack panels vertically, 1 column, rows don't have fixed height
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		// Load the verify panel
		this.add(new CheckoutVerifyPanel());
		
		
		// load the check to save checkbox
		
		// Load the confirm and back buttons
		this.add(new CheckoutVerifyExtrasPanel());		
		
		// Load the checkout progress (at the verify stage)		
		this.add(new CheckoutCheckoutProgressPanel(2)); // 2 indicates that we are at the VERIFY phase	
		
	}
}
