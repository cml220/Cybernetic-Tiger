package gui;

/*
 * NextBooks GUI system
 * @author Jake Bolam
 * 
 */

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class CheckoutPaymentFieldsPanel extends JPanel {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4885426338224971236L;
	
	private JLabel text;
	private JTextField field;		
	
	public CheckoutPaymentFieldsPanel(String inTextLabel)
	{
		/*
		 * creates a panel with a label and a field
		 */
		
		super(); // call JPanel default constructor		
		this.setLayout(new BorderLayout());
		// TODO why isn't swing accepting these dimensions???
		this.setPreferredSize(new Dimension(300, 40)); // 300 wide, 40 high - 40 possible too much!!
		
		// Add the label
		text = new JLabel(inTextLabel);
		text.setSize(100, 20);
		this.add(text, BorderLayout.WEST); // FOCUSED LEFT
		
		// Add the associated field
		field = new JTextField(20);
		field.setSize(200, 20);
		this.add(field, BorderLayout.EAST); // FOCUSED RIGHT
	}
}
