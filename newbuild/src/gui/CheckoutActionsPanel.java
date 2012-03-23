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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.Controller;

public class CheckoutActionsPanel extends JPanel {


    /**
     * 
     */
    private static final long serialVersionUID = 8200533829923804627L;

    // member field the for actual total price (so it can be updated dynamically)
    private static JLabel totalPriceText;
    private static JLabel totalPriceValue;

    private static JLabel space1;
    private static JLabel space2;
    private static JLabel space3;

    private static JButton proceedButton;
    private static JButton backButton;

    public CheckoutActionsPanel()
    {
        /*
         * creates the totalPrice and proceed to payment button for the MyCart window
         */

        super(); // call JPanel default constructor
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5)); // Create Elements Left to Right, CENTERED, 20 pixels between width, and 5 between height

        // Add the total price tag
        totalPriceText = new JLabel("Total Price:");
        this.add(totalPriceText);

        // Now add the actual total price, note this is declared in memberFields
        // note leave this, the value is update via the method "setTotalPrice"
        totalPriceValue = new JLabel("$x");
        totalPriceValue.setFont(new Font(totalPriceValue.getFont().getName(), Font.ITALIC, totalPriceValue.getFont().getSize())); // make text just italic, leave other settings
        this.add(totalPriceValue);

        // Add a couple of blank elements for further space to the proceed button hehe :)
        space1 = new JLabel("");
        this.add(space1);
        space2 = new JLabel("");
        this.add(space2);
        space3 = new JLabel("");
        this.add(space3);

        // Now add the back button
        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {

                CheckoutPanel.previousPaymentStep();

            }



        });
        this.add(backButton);

        // and finally add the proceed button
        proceedButton = new JButton("Proceed");
        proceedButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {

                CheckoutPanel.nextPaymentStep();

            }



        });

        this.add(proceedButton);

        CheckoutActionsPanel.loadCartActions();
    }

    public static void loadCartActions()
    {
        // MyCart Buttons

        // set to visible
        totalPriceText.setVisible(true);

        // update price
        updatePrice();
        // set to visible
        totalPriceValue.setVisible(true);

        // set spaces to visible
        space1.setVisible(true);
        space2.setVisible(true);
        space3.setVisible(true);

        // change text to "Proceed to Payment"
        proceedButton.setText("Proceed to Payment");

        // set back button to hidden
        backButton.setVisible(false);
    }

    public static void loadPaymentActions()
    {

        // Payment buttons
        // verify and cancel buttons

        // set to hidden
        totalPriceText.setVisible(false);

        //set to hidden
        totalPriceValue.setVisible(false);

        // set spaces to hidden
        space1.setVisible(false);
        space2.setVisible(false);
        space3.setVisible(false);

        // change text to "Verify"
        proceedButton.setText("Verify");

        // set back button to visible
        backButton.setVisible(true);
    }

    public static void loadVerifyActions()
    {

        // Verify buttons
        // the totalPrice and the confirm and back buttons

        // set to visible
        totalPriceText.setVisible(true);

        // update price
        updatePrice();
        //set to visible
        totalPriceValue.setVisible(true);

        // set spaces to visible
        space1.setVisible(true);
        space2.setVisible(true);
        space3.setVisible(true);

        // change text to "Confirm"
        proceedButton.setText("Confirm");

        // set back button to visible
        backButton.setVisible(true);

    }

    public static void loadThankyouActions()
    {

        // Thankyou buttons
        // the home button

        // set to hidden
        totalPriceText.setVisible(false);

        // set to hidden
        totalPriceValue.setVisible(false);

        // set spaces to hidden
        space1.setVisible(false);
        space2.setVisible(false);
        space3.setVisible(false);

        // change text to "Home"
        proceedButton.setText("Home");

        // set back button to hidden
        backButton.setVisible(false);
    }

    private static void updatePrice()
    {

        try {
            totalPriceValue.setText("$" + Controller.getCartTotal());
        }
        catch (Exception e) {
            // failed to get cart total, display error, not zero
            totalPriceValue.setText("error");
        }
    }
}
