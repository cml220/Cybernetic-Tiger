/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 * Start of the checkout process, My Cart
 * 
 * Checkout written by Jake Bolam
 */

package gui;



import javax.swing.JPanel;
import javax.swing.SpringLayout;


public class CheckoutPaymentPanel extends JPanel
{

    /**
     * 
     */
    private static final long serialVersionUID = 635271050458474969L;

    public CheckoutPaymentPanel()
    {
    	// Set to spring layout, attempt to center the form "somewhat"
    	SpringLayout springLayout = new SpringLayout();
    	setLayout(springLayout);
    	
    	// TODO add in some images or something to pretty up the page
    	
    	// Add in the payment panel with fields
    	CheckoutPaymentFieldsPanel checkoutPaymentPanelNew = new CheckoutPaymentFieldsPanel();
    	springLayout.putConstraint(SpringLayout.NORTH, checkoutPaymentPanelNew, -429, SpringLayout.SOUTH, this);
    	springLayout.putConstraint(SpringLayout.WEST, checkoutPaymentPanelNew, 322, SpringLayout.WEST, this);
    	springLayout.putConstraint(SpringLayout.SOUTH, checkoutPaymentPanelNew, -158, SpringLayout.SOUTH, this);
    	this.add(checkoutPaymentPanelNew);
    	

       
    }
}
