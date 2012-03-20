package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 * A Label-InputField pair.
 * @author Brad Johnson
 */
class LabeledInputField extends JPanel {

    /**
     * ID.
     */
    private static final long serialVersionUID = -1289482107395840721L;

    /**
     * The text entry field of the pair.
     */
    private final JTextField field;
    
    /**
     * The button?.
     */
    private final JButton button;

    /**
     * Constructor.
     * @param caption - the label to put beside the text entry box.
     */
    public LabeledInputField(final String caption) {
    	
    	/*
    	 * No button
    	 */
    	button = null;
    	
        /*
         * Align things to the right
         */
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.setBackground(Color.WHITE);
        this.setOpaque(false);
        
        /*
         * Create the label first
         */
        JLabel label = new JLabel(caption);
        label.setForeground(PanelsManager.UNSELECTEDBLUE);

        /*
         * Then create the entry field.
         */
        field = new JTextField();
        field.setColumns(40);

        /*
         * Add the label and entry field to a the panel holding the pair.
         */
        this.add(label);
        this.add(field);

        /*
         * Add a uniform amount of space on the right side
         */
        this.add(Box.createRigidArea(new Dimension(200, 50)));

    }
    
    /**
     * Constructor with button
     * @param caption - the label to put beside the text entry box.
     * @param buttonCap - the label for the button
     */
    public LabeledInputField(final String caption, final String buttonCap) {
    	
    	/*
    	 * Button
    	 */
    	button = new JButton(buttonCap);
    	
        /*
         * Align things to the right
         */
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.setBackground(Color.WHITE);
        this.setOpaque(false);
        
        /*
         * Create the label first
         */
        JLabel label = new JLabel(caption);
        label.setForeground(PanelsManager.UNSELECTEDBLUE);

        /*
         * Then create the entry field.
         */
        field = new JTextField();
        field.setColumns(40);

        /*
         * Add the label and entry field and button to the panel holding the pair.
         */
        this.add(label);
        this.add(field);
        this.add(button);
        
        /*
         * Add a uniform amount of space on the right side (minus enough space for the button)
         */
        this.add(Box.createRigidArea(new Dimension(200 - 100, 50)));

    }

    @Override
    /*
     * When this pair requests focus, give the focus to the entry field.
     */
    public void requestFocus() {

        field.requestFocus();

    }

    /**
     * Add a keyboard-shortcut mapping to the text field.
     * @param keyStroke - the keystroke that must be used to invoke the
     * action tied to actionDesc.
     * @param actionDesc - a string which links to an action in the
     * ActionMap
     */
    public void putInput(final KeyStroke keyStroke,
            final String actionDesc) {

        this.field.getInputMap().put(keyStroke, actionDesc);

    }

    /**
     * Add an action to the keyboard shortcut mapping.
     * @param actionDesc - a string which links to a keystroke in InputMap
     * @param action - the action performed when actionDesc is called
     */
    public void putAction(final String actionDesc,
            final AbstractAction action) {

        this.field.getActionMap().put(actionDesc, action);

    }
    
    /**
     * Add an action listener to the button from a public scope.
     * @param l - the actionlistener
     */
    public void addActionListener(ActionListener l){
    	
    	this.button.addActionListener(l);
    	
    }

    /**
     * Get the value from the text field.
     * @return the String from the text field
     */
    public String getText() {

        return field.getText();

    }
    
    /**
     * Set the value in the text field.
     * @param value - the string to set in the text field
     */
    public void setText(String value) {
    	
    	this.field.setText(value);
    	
    }
    
}
