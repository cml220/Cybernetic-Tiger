package gui;

/*
 * NextBooks GUI system
 * @author Jake Bolam
 * 
 */

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CheckoutMyCartExtrasPanel extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8200533829923804627L;
	
	// member field the for actual total price (so it can be updated dynamically)
	public JLabel totalPrice;
	
	public CheckoutMyCartExtrasPanel()
	{
		/*
		 * creates the totalPrice and proceed to payment button for the MyCart window
		 */
		
		super(); // call JPanel default constructor		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5)); // Create Elements Left to Right, CENTERED, 20 pixels between width, and 5 between height
		
		// Add the total price tag		
		this.add(new JLabel("Total Price:"));
		
		// Now add the actual total price, note this is declared in memberFields
		totalPrice = new JLabel("$x");
		totalPrice.setFont(new Font(totalPrice.getFont().getName(), Font.ITALIC, totalPrice.getFont().getSize())); // make text just italic, leave other settings
		this.add(totalPrice);
		
		// Add a couple of blank elements for further space to the proceed button hehe :)
		this.add(new JLabel(""));
		this.add(new JLabel(""));
		this.add(new JLabel(""));
		
		// Now add the proceed button
		JButton paymentButton = new JButton("Proceed to Payment");
		paymentButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                
                CheckoutPanel.nextPaymentStep();
                
            }
		    
		    
		    
		});
		
		this.add(paymentButton);
		
		
	}
	
	public void setTotalPrice(float inPrice)
	{
		if (inPrice < 0)
		{
			throw new IllegalArgumentException("Price cannot be negative.");
		}
		// Rounding to 2.dp??
		totalPrice.setText("$ " + inPrice);
	}
}
