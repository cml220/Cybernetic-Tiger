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

import java.awt.Font;


public class CheckoutVerifyPanel extends JPanel 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 8248737071658570236L;

	public CheckoutVerifyPanel()
	{
		// TODO covert layout from absolute to another layout that still works XD
		setLayout(null);
		
		// Cart label
		JLabel lblCart = new JLabel("Cart:");
    	lblCart.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
    	lblCart.setBounds(198, 24, 74, 23);
    	add(lblCart);
		
    	// cart panel, note this is a scrolling pane
    	JScrollPane cartContentsScrollPane = new JScrollPane(new CheckoutVerifyCartContentsPanel());
    	cartContentsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    	cartContentsScrollPane.setBounds(180, 58, 500, 88);
    	this.add(cartContentsScrollPane);
    	
    	// payment label
    	JLabel lblPayment = new JLabel("Payment:");
    	lblPayment.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
    	lblPayment.setBounds(198, 157, 74, 23);
    	add(lblPayment);
    	
    	// payment panel
    	CheckoutPaymentFieldsPanel checkoutPaymentFieldsPanel = new CheckoutPaymentFieldsPanel(true); // The true attributes disables the text fields (see inner panel)
    	checkoutPaymentFieldsPanel.setBounds(232, 191, 367, 281);
    	this.add(checkoutPaymentFieldsPanel); 
    	
    	// checkbox to save details
    	JCheckBox saveDetails = new JCheckBox("Check to save details for next purchase");
    	saveDetails.setBounds(274, 479, 272, 23);
    	add(saveDetails);		
		
		
		
	}
}
