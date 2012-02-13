package gui;

/*
 * NextBooks GUI system
 * @author Jake Bolam
 * 
 */

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

public class CheckoutCheckoutProgressPanel extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3123058109859174542L;
	private JButton[] buttonArray;
	
	public CheckoutCheckoutProgressPanel(int inCheckoutStage)
	{
		/*
		 * creates a clickable progress bar for each checkout stage
		 * @params, one integer from 0 to 3, representing the stage of the checkout (see below)
		 * 0 = Cart - nothing can be clicked
		 * 1 = Payment - cart can be clicked
		 * 2 = Verify Cart/Payment - cart and payment can be clicked
		 * 3 = Thankyou - nothing can be clicked
		 * @returns, renders (where appropriate) a clickable progress bar for each stage of the checkout
		 */
		
		// could just load in a different image every time?
		
		super(); // call JPanel default constructor		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5)); // Create Elements Left to Right, CENTERED, 0 pixels between width, and 5 between height
		
		// Prepare all the elements
		prepareElements();
		
		// Modify elements depending on the checkout stage
		switch (inCheckoutStage)
		{
		case(0):	loadCartProgress(); 	break;	// Cart
		case(1):	loadPaymentProgress();	break;	// Payment
		case(2):	loadVerifyProgress();	break;	// Verify Cart/Payment
		case(3):	loadThankyouProgress();	break;	// Thankyou
		default: // Throw exception, invalid checkout stage
			throw new IllegalArgumentException("Invalid checkout stage.");
		
		}
		
		// Add the elements
		renderElements();
	}
	
	private void prepareElements()
	{
		// Initiate Elements
		buttonArray = new JButton[9]; // 9 elements required
		
		// Initiate all the buttons and settings for all buttons
			for (int ii=0; ii<buttonArray.length; ii++)
			{
				buttonArray[ii] = new JButton();
				setStyleFor(buttonArray[ii], Font.ITALIC);
			}		
		
		// Set settings just for the fancy buttons (all the evens ones)
			for (int ii=0; ii<buttonArray.length; ii+=2)
			{
			buttonArray[ii].setEnabled(false);
			setStyleFor(buttonArray[ii], Font.PLAIN);
			}	
		
		
		// 0 fancy text -- left arrow
		buttonArray[0].setText("<--");
		
		// 1 text -- Cart
		buttonArray[1].setText("Cart");
		
		// 2 fancy text -- line
		buttonArray[2].setText("---");
		
		// 3 text -- Payment
		buttonArray[3].setText("Payment");
				
		// 4 fancy text -- line
		buttonArray[4].setText("---");
				
		// 5 text -- Verify Cart/Payment
		buttonArray[5].setText("Verify Cart/Payment");
				
		// 6 fancy text -- line
		buttonArray[6].setText("---");
				
		// 7 text -- Cart
		buttonArray[7].setText("Thankyou");
				
		// 8 fancy text -- right arrow
		buttonArray[8].setText("-->");		
	}
	
	private void renderElements()
	{
		// add all elements from the array to the screen, left to right
		for (int ii=0; ii<buttonArray.length; ii++)
		{
			this.add(buttonArray[ii]);
		}		
	}
	
	
	private void loadCartProgress()
	{
		// Cart
		// nothing can be clicked				 
				 
		// set Cart as the current button - to be bold and italic
		setStyleFor(buttonArray[1], Font.BOLD+Font.ITALIC);
	}
	
	private void loadPaymentProgress()
	{
		// Payment
		// cart can be clicked - set these to bold
		// !!! NEED TO ADD CLICK LISTERN HERE
		setStyleFor(buttonArray[1], Font.BOLD);
		
		// set Payment as the current button - to be bold and italic
		setStyleFor(buttonArray[3], Font.BOLD+Font.ITALIC);
	}
	
	private void loadVerifyProgress()
	{
		// Verify Cart/Payment
		// cart and payment can be clicked - set these buttons to bold
		// !!! NEED TO ADD CLICK LISTERNS HERE		
		
		setStyleFor(buttonArray[1], Font.BOLD);
		setStyleFor(buttonArray[3], Font.BOLD);
		
		// set Verify as the current button - to be bold and italic
		setStyleFor(buttonArray[5], Font.BOLD+Font.ITALIC);
	}	
	
	
	private void loadThankyouProgress()
	{
		// Thankyou
		// nothing can be clicked
		
		// set Thankyou as the current button - to be bold and italic
		setStyleFor(buttonArray[7], Font.BOLD+Font.ITALIC);
	}
	
	// changes the style of a given button without affecting the overall font
	private void setStyleFor(JButton inJButton, int inStyle)
	{		
		inJButton.setFont(new Font(inJButton.getFont().getName(), inStyle, inJButton.getFont().getSize()));
	}
}
