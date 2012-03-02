/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 * Start of the checkout process, My Cart
 * 
 * Checkout written by Jake Bolam
 */

package gui;


import java.awt.FlowLayout;

import javax.swing.*;


public class CheckoutPaymentPanel extends JPanel 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 635271050458474969L;
	
	private CheckoutPaymentFieldsPanel cardNumber;
	private JTextField expiryMonth;
	private JTextField expiryYear;
	private JTextField securityCode;
	private CheckoutPaymentFieldsPanel name;
	private CheckoutPaymentFieldsPanel country;
	private CheckoutPaymentFieldsPanel address;
	private CheckoutPaymentFieldsPanel address2;
	private CheckoutPaymentFieldsPanel state;
	private CheckoutPaymentFieldsPanel zip;
	private CheckoutPaymentFieldsPanel phone;
	

	public CheckoutPaymentPanel()
	{
		
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		
		
		// Card number row
        cardNumber = new CheckoutPaymentFieldsPanel("Card number:");
        this.add(cardNumber);
		
		// Expiry row
        expiryMonth = new JTextField();
        expiryMonth.setSize(40, 20); // enough width for 2 characters
        expiryMonth.setText("mm");
        
        expiryYear = new JTextField();
        expiryYear.setSize(80, 20); // enough width for 4 characters
        expiryYear.setText("yyyy");
        
        securityCode = new JTextField();
        securityCode.setSize(60, 20); // enough width for 3 characters
        
        JPanel expiryRow = new JPanel();
        expiryRow.setLayout(new FlowLayout());
        expiryRow.add(new JLabel("Expiration date:"));
        expiryRow.add(expiryMonth);
        expiryRow.add(expiryYear);
        expiryRow.add(new JLabel("CVC:"));
        expiryRow.add(securityCode);
        this.add(expiryRow);
        
        
        // Name row
        name = new CheckoutPaymentFieldsPanel("Name:");
        this.add(name);
        
        // country row
        country = new CheckoutPaymentFieldsPanel("Country:");
        this.add(country);
        
        // address rows
        address = new CheckoutPaymentFieldsPanel("Address:");
        this.add(address);
        address2 = new CheckoutPaymentFieldsPanel("");
        this.add(address2);
        
        // state row
        state = new CheckoutPaymentFieldsPanel("State:");
        this.add(state);
        
        // country row
        zip = new CheckoutPaymentFieldsPanel("Zip:");
        this.add(zip);
        
        // country row
        phone = new CheckoutPaymentFieldsPanel("Phone:");
        this.add(phone);
		
	}	
}
