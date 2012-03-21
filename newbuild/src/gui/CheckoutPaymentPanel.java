/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 * Start of the checkout process, My Cart
 * 
 * Checkout written by Jake Bolam
 */

package gui;



import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import model.PaymentInfo;


public class CheckoutPaymentPanel extends StyledPanel
{

    /**
     * 
     */
    private static final long serialVersionUID = 635271050458474969L;

    private final CheckoutPaymentFieldsPanel checkoutPaymentPanelNew;

    public CheckoutPaymentPanel()
    {
        // Set to spring layout, attempt to center the form "somewhat"
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);

        // TODO add in some images or something to pretty up the page

        // Add in the payment panel with fields
        checkoutPaymentPanelNew = new CheckoutPaymentFieldsPanel(false);
        springLayout.putConstraint(SpringLayout.NORTH, checkoutPaymentPanelNew, 50, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.WEST, checkoutPaymentPanelNew, 150, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.SOUTH, checkoutPaymentPanelNew, 470, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.EAST, checkoutPaymentPanelNew, 700, SpringLayout.WEST, this);
        checkoutPaymentPanelNew.setBorder(new EmptyBorder(0,0,0,0));
        this.add(checkoutPaymentPanelNew);

    }

    public PaymentInfo getPaymentInfo() {

        return checkoutPaymentPanelNew.getPaymentInfo();

    }
}
