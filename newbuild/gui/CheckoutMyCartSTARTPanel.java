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


public class CheckoutMyCartSTARTPanel extends JPanel 
{	


	/**
	 * 
	 */
	private static final long serialVersionUID = 278868391776758102L;

	public CheckoutMyCartSTARTPanel()
	{
		
		//		Stack panels vertically, 1 column, rows don't have fixed height
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		// Load items in the cart
		this.add(new DisplayScrollPane(new CheckoutMyCartPanel()));
		
		
		// Load the totalCost and Payment button
		this.add(new CheckoutMyCartExtrasPanel());		
		
		// Load the checkout progress (at the cart stage)		
		this.add(new CheckoutCheckoutProgressPanel(0)); // 0 indicates that we are at the cart phase	
		
	}
}
