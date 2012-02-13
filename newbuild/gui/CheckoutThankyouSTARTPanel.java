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


public class CheckoutThankyouSTARTPanel extends JPanel 
{		



	/**
	 * 
	 */
	private static final long serialVersionUID = -5603750399015023136L;

	public CheckoutThankyouSTARTPanel()
	{
		
		//	Stack panels vertically, 1 column, rows don't have fixed height		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		// Load the thankyou message in the thankyou panel :)
		this.add(new CheckoutThankyouPanel());
		
		// Load the button to return home
		this.add(new CheckoutThankyouExtrasPanel());		
				
		// Load the checkout progress (at the thankyou stage)		
		this.add(new CheckoutCheckoutProgressPanel(3)); // 3 indicates that we are at the THANKYOU phase	
		
	}
}
