/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 * Start of the checkout process, My Cart
 * 
 * Checkout written by Jake Bolam
 */

package gui;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CheckoutPaymentPanel extends JPanel
{

    /**
     * 
     */
    private static final long serialVersionUID = 635271050458474969L;

    private final CheckoutPaymentFieldsPanel cardNumber;
    private final JTextField expiryMonth;
    private final JTextField expiryYear;
    private final JTextField securityCode;
    private final CheckoutPaymentFieldsPanel name;
    private final CheckoutPaymentFieldsPanel country;
    private final CheckoutPaymentFieldsPanel address;
    private final CheckoutPaymentFieldsPanel address2;
    private final CheckoutPaymentFieldsPanel state;
    private final CheckoutPaymentFieldsPanel zip;
    private final CheckoutPaymentFieldsPanel phone;


    public CheckoutPaymentPanel()
    {

        this.setLayout(new GridLayout(0,1));

        this.setSize(new Dimension(this.getWidth(), 800));

        // Card number row
        cardNumber = new CheckoutPaymentFieldsPanel("Card number:");
        this.add(cardNumber);

        // Expiry row
        expiryMonth = new JTextField();
        expiryMonth.setColumns(2);
        expiryMonth.setText("mm");

        expiryYear = new JTextField();
        expiryYear.setColumns(4);
        expiryYear.setText("yyyy");

        securityCode = new JTextField();
        securityCode.setColumns(3);

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
