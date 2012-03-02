package gui;

/*
 * NextBooks GUI system
 * @author Jake Bolam
 * 
 */

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CheckoutPaymentFieldsPanel extends JPanel {




    /**
     * 
     */
    private static final long serialVersionUID = -4885426338224971236L;

    private final JLabel text;
    private final JTextField field;

    public CheckoutPaymentFieldsPanel(String inTextLabel)
    {
        /*
         * creates a panel with a label and a field
         */

        super(); // call JPanel default constructor
        this.setLayout(new FlowLayout());

        // Add the label
        text = new JLabel(inTextLabel);
        this.add(text); // FOCUSED LEFT

        // Add the associated field
        field = new JTextField();
        field.setColumns(20);
        this.add(field); // FOCUSED RIGHT
    }
}
