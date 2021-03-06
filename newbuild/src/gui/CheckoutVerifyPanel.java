/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 * Start of the checkout process, My Cart
 * 
 * Checkout written by Jake Bolam
 */

package gui;



import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import controllers.Controller;


public class CheckoutVerifyPanel extends StyledPanel
{


    /**
     * 
     */
    private static final long serialVersionUID = 8248737071658570236L;

    public CheckoutVerifyPanel()
    {
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
        checkoutPaymentFieldsPanel.setFields(Controller.getSessionPaymentInfo());
        checkoutPaymentFieldsPanel.setBounds(250, 200, 350, 250);
        this.add(checkoutPaymentFieldsPanel);

        // checkbox to save details
        JCheckBox saveDetails = new JCheckBox("Check to save details for next purchase");
        saveDetails.setBounds(274, 479, 272, 23);
        add(saveDetails);



    }
}
