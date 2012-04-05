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

import exceptions.GUINoSuchPanelException;

public class CheckoutProgressPanel extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3123058109859174542L;
	private JButton[] buttonArray;
	
	public CheckoutProgressPanel()
	{
		/*
		 * creates a clickable progress bar for each checkout stage		
		 * @returns, renders (where appropriate) a clickable progress bar for each stage of the checkout
		 */
		
		// could just load in a different image every time?
		
		super(); // call JPanel default constructor		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5)); // Create Elements Left to Right, CENTERED, 0 pixels between width, and 5 between height
		
		// Prepare all the elements
		prepareElements();		
		
		// Add the elements
		renderElements();
		
		this.loadCartProgress();
	}
	
	private void prepareElements()
	{
		// Initiate Elements
		buttonArray = new JButton[9]; // 9 elements required
		
		// Initiate all the buttons
		for (int ii=0; ii<buttonArray.length; ii++)
		{
			buttonArray[ii] = new JButton();
		}	
		
		// Set all the default styles
		this.setDefaultStyle();
		
		// 0 fancy text -- left arrow
		buttonArray[0].setText("<--");
		
		// 1 text -- Cart
		buttonArray[1].setText("Cart");
		buttonArray[1].addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    
                    CheckoutPanel.jumpToPaymentStep(CheckoutPanel.CART);
                    
                } catch (GUINoSuchPanelException e1) {

                    JOptionPane.showMessageDialog(null, "Could not load " +
                    		"shopping cart.  \nPlease contact technical " +
                    		"support.", "GUINoSuchPanelException",
                    		JOptionPane.ERROR_MESSAGE);
                    
                }
                
            }
		    
		    
		});
		
		// 2 fancy text -- line
		buttonArray[2].setText("---");
		
		// 3 text -- Payment
		buttonArray[3].setText("Payment");
		buttonArray[3].addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    
                    CheckoutPanel.jumpToPaymentStep(CheckoutPanel.PAYMENT);
                    
                } catch (GUINoSuchPanelException e1) {

                    JOptionPane.showMessageDialog(null, "Could not load " +
                            "payment step.  \nPlease contact technical " +
                            "support.", "GUINoSuchPanelException",
                            JOptionPane.ERROR_MESSAGE);
                    
                }
                
            }
            
            
        });
        
				
		// 4 fancy text -- line
		buttonArray[4].setText("---");
				
		// 5 text -- Verify Cart/Payment
		buttonArray[5].setText("Verify Cart/Payment");
		buttonArray[5].addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    
                    CheckoutPanel.jumpToPaymentStep(CheckoutPanel.VERIFY);
                    
                } catch (GUINoSuchPanelException e1) {

                    JOptionPane.showMessageDialog(null, "Could not load " +
                            "verification.  \nPlease contact technical " +
                            "support.", "GUINoSuchPanelException",
                            JOptionPane.ERROR_MESSAGE);
                    
                }
                
            }
            
            
        });
        
				
		// 6 fancy text -- line
		buttonArray[6].setText("---");
				
		// 7 text -- Cart
		buttonArray[7].setText("Thankyou");
		buttonArray[7].addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    
                    CheckoutPanel.jumpToPaymentStep(CheckoutPanel.THANKYOU);
                    
                } catch (GUINoSuchPanelException e1) {

                    JOptionPane.showMessageDialog(null, "Could not load " +
                            "thank you dialog.  \nPlease contact technical " +
                            "support.", "GUINoSuchPanelException",
                            JOptionPane.ERROR_MESSAGE);
                    
                }
                
            }
            
            
        });
        
				
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
	
	private void setDefaultStyle()
	{
		// Initiate the settings for all buttons
		for (int ii=0; ii<buttonArray.length; ii++)
		{			
			setStyleFor(buttonArray[ii], Font.ITALIC);
		}		
				
		// Set settings just for the fancy buttons (all the evens ones)
					for (int ii=0; ii<buttonArray.length; ii+=2)
					{
					buttonArray[ii].setEnabled(false);
					setStyleFor(buttonArray[ii], Font.PLAIN);
					}	
	}
	
	private void setAllDisabled()
	{
		// Initiate the settings for all buttons
		for (int ii=0; ii<buttonArray.length; ii++)
		{			
			buttonArray[ii].setEnabled(false);
		}	
	}	
	
	public void loadCartProgress()
	{
		// Cart
		// nothing can be clicked
		// Load default style first
		this.setDefaultStyle();		
				 
		// set Cart as the current button - to be bold and italic
		setStyleFor(buttonArray[1], Font.BOLD+Font.ITALIC);
		
		// just the Cart button can be clicked
		this.setAllDisabled();
		buttonArray[1].setEnabled(true);	
	}
	
	public void loadPaymentProgress()
	{
		// Payment
		// cart can be clicked - set these to bold
		// Load default style first
		this.setDefaultStyle();		
		
		setStyleFor(buttonArray[1], Font.BOLD);
		
		// set Payment as the current button - to be bold and italic
		setStyleFor(buttonArray[3], Font.BOLD+Font.ITALIC);
		
		// just the Cart and Payment button can be clicked
		this.setAllDisabled();
		buttonArray[1].setEnabled(true);
		buttonArray[3].setEnabled(true);
	}
	
	public void loadVerifyProgress()
	{
		// Verify Cart/Payment
		// cart and payment can be clicked - set these buttons to bold
		// Load default style first
		this.setDefaultStyle();	
		
		setStyleFor(buttonArray[1], Font.BOLD);
		setStyleFor(buttonArray[3], Font.BOLD);
		
		// set Verify as the current button - to be bold and italic
		setStyleFor(buttonArray[5], Font.BOLD+Font.ITALIC);
		
		// just the Cart and Payment and Verify button can be clicked
		this.setAllDisabled();
		buttonArray[1].setEnabled(true);
		buttonArray[3].setEnabled(true);
		buttonArray[5].setEnabled(true);
	}	
	
	
	public void loadThankyouProgress()
	{
		// Thankyou
		// nothing can be clicked
		// Load default style first
		this.setDefaultStyle();
		
		// set Thankyou as the current button - to be bold and italic
		setStyleFor(buttonArray[7], Font.BOLD+Font.ITALIC);
		
		// just the Thankyou button can be clicked
		this.setAllDisabled();
		buttonArray[7].setEnabled(true);
	}
	
	// changes the style of a given button without affecting the overall font
	private void setStyleFor(JButton inJButton, int inStyle)
	{		
		inJButton.setFont(new Font(inJButton.getFont().getName(), inStyle, inJButton.getFont().getSize()));
	}
}
