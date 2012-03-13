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
import javax.swing.JPanel;


public class CheckoutMyCartPanel extends JPanel 
{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 9165182901028257821L;

	public CheckoutMyCartPanel()
	{
		
		/*
		 * Stack panels vertically, 1 column
		 */
		this.setLayout(new GridLayout(0,1));
		
		/*
		 * Load the book panels
		 */
		this.loadCart();		
		
	}
	
	private void loadCart()
	{		
		/*
		 * 
		 * Skeleton implementation
		 * In the future will load the items currently in the cart into view
		 */
		this.add(new CheckoutMyCartBookPanel("Oxford English Dictionary", "Words and stuff.","some guy", "http://somewhere", 100, 22.50));
		this.add(new CheckoutMyCartBookPanel("Collins Pocket French Dictionary", "French words and stuff.", "un garcon", "http://lesomewherre", 20, 11.50));
		this.add(new CheckoutMyCartBookPanel("College Physics", "PHYSICS", "Physics person", "httphysics", 3, 300.0));
		this.add(new CheckoutMyCartBookPanel("A Clockwork Orange", "No time for the old in-out in-out love.","Anthony Burgess", "http://droogs", 42, 200.0));



		
	}
	
}
