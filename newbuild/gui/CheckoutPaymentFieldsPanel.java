package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.SpringLayout;

public class CheckoutPaymentFieldsPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1770411281976756228L;
	// member fields
	private JTextField expiryMonth;
	private JTextField expiryYear;
	private JTextField securityCode;
	private JTextField cardNumber;
	private JTextField name;
	private JTextField country;
	private JTextField address;
	private JTextField address2;
	private JTextField state;
	private JTextField zip;
	private JTextField phone;

	/**
	 * Create the panel.
	 */
	public CheckoutPaymentFieldsPanel() {
		this.renderPanel();
	}
	
	/**
	 * Create the panel, but the option to disable all the fields is available.	
	 * @param inDisabled
	 */
	public CheckoutPaymentFieldsPanel(boolean inDisabled) {
		this.renderPanel();
		
		if (inDisabled == true) {
		
		// Disable all the fields now
		expiryMonth.setEnabled(false);
		expiryYear.setEnabled(false);
		securityCode.setEnabled(false);
		cardNumber.setEnabled(false);
		name.setEnabled(false);
		country.setEnabled(false);
		address.setEnabled(false);
		address2.setEnabled(false);
		state.setEnabled(false);
		zip.setEnabled(false);
		phone.setEnabled(false);
		}
	}
	
	private void renderPanel()
	{
		// the little border
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		// using spring layout, components are relative to other components
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		
		// Start adding labels and fields where appropriate
		// Card
		JLabel label = new JLabel("Card number:");
		springLayout.putConstraint(SpringLayout.NORTH, label, 11, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, label, 8, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, label, 85, SpringLayout.WEST, this);
		add(label);
		
		cardNumber = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, cardNumber, 8, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, cardNumber, 116, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, cardNumber, 333, SpringLayout.WEST, this);
		add(cardNumber);
		cardNumber.setColumns(10);
		
		
		//Expriy
		JLabel label_1 = new JLabel("Expiration date:");
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 37, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, label_1, 8, SpringLayout.WEST, this);
		add(label_1);
		
		expiryMonth = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, expiryMonth, 34, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, expiryMonth, 116, SpringLayout.WEST, this);
		expiryMonth.setText("mm");
		add(expiryMonth);
		expiryMonth.setColumns(2);
		
		expiryYear = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, expiryYear, 34, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, expiryYear, 144, SpringLayout.WEST, this);
		expiryYear.setText("yyyy");
		add(expiryYear);
		expiryYear.setColumns(4);
		
		JLabel label_2 = new JLabel("CVC:");
		springLayout.putConstraint(SpringLayout.NORTH, label_2, 37, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, label_2, 273, SpringLayout.WEST, this);
		add(label_2);
		
		securityCode = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, securityCode, 34, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, securityCode, 303, SpringLayout.WEST, this);
		add(securityCode);
		securityCode.setColumns(3);
		
		
		// Name
		JLabel label_3 = new JLabel("Name:");
		springLayout.putConstraint(SpringLayout.NORTH, label_3, 88, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, label_3, 8, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, label_3, 85, SpringLayout.WEST, this);
		add(label_3);
		
		name = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, name, 85, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, name, 116, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, name, 333, SpringLayout.WEST, this);
		add(name);
		name.setColumns(10);
		
		
		// Country
		JLabel label_4 = new JLabel("Country:");
		springLayout.putConstraint(SpringLayout.NORTH, label_4, 114, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, label_4, 8, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, label_4, 85, SpringLayout.WEST, this);
		add(label_4);
		
		country = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, country, 111, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, country, 116, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, country, 333, SpringLayout.WEST, this);
		add(country);
		country.setColumns(10);
		
		
		// Address
		JLabel label_5 = new JLabel("Address:");
		springLayout.putConstraint(SpringLayout.NORTH, label_5, 140, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, label_5, 8, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, label_5, 85, SpringLayout.WEST, this);
		add(label_5);
		
		address = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, address, 137, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, address, 116, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, address, 333, SpringLayout.WEST, this);
		add(address);
		address.setColumns(10);
		
		address2 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, address2, 163, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, address2, 116, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, address2, 333, SpringLayout.WEST, this);
		add(address2);
		address2.setColumns(10);
		
		
		// State
		JLabel label_6 = new JLabel("State:");
		springLayout.putConstraint(SpringLayout.NORTH, label_6, 192, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, label_6, 8, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, label_6, 85, SpringLayout.WEST, this);
		add(label_6);
		
		state = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, state, 189, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, state, 116, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, state, 267, SpringLayout.WEST, this);
		add(state);
		state.setColumns(10);
		
		
		// Zip
		JLabel label_7 = new JLabel("Zip:");
		springLayout.putConstraint(SpringLayout.NORTH, label_7, 218, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, label_7, 8, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, label_7, 85, SpringLayout.WEST, this);
		add(label_7);
		
		zip = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, zip, 215, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, zip, 116, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, zip, 188, SpringLayout.WEST, this);
		add(zip);
		zip.setColumns(10);		
		
		
		// Phone
		JLabel label_8 = new JLabel("Phone:");
		springLayout.putConstraint(SpringLayout.NORTH, label_8, 244, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, label_8, 8, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, label_8, 85, SpringLayout.WEST, this);
		add(label_8);
		
		phone = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, phone, 241, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, phone, 116, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, phone, 267, SpringLayout.WEST, this);
		add(phone);
		phone.setColumns(10);		
	
	}

	// public getters for all the field details
	public String getExpiryMonth() {
		return expiryMonth.getText();
	}

	public String getExpiryYear() {
		return expiryYear.getText();
	}

	public String getSecurityCode() {
		return securityCode.getText();
	}

	public String getCardNumber() {
		return cardNumber.getText();
	}
	
	public String getName() {
		return name.getText();
	}

	public String getCountry() {
		return country.getText();
	}

	public String getAddress() {
		return address.getText();
	}

	public String getAddress2() {
		return address2.getText();
	}

	public String getState() {
		return state.getText();
	}

	public String getZip() {
		return zip.getText();
	}

	public String getPhone() {
		return phone.getText();
	}

	// public setters for all the field details
	public void setExpiryMonth(String inExpiryMonth) {
		this.expiryMonth.setText(inExpiryMonth);
	}

	public void setExpiryYear(String inExpiryYear) {
		this.expiryYear.setText(inExpiryYear);
	}

	public void setSecurityCode(String inSecurityCode) {
		this.securityCode.setText(inSecurityCode);
	}

	public void setCardNumber(String inCardNumber) {
		this.cardNumber.setText(inCardNumber);
	}

	public void setName(String inName) {
		this.name.setText(inName);
	}

	public void setCountry(String inCountry) {
		this.country.setText(inCountry);
	}

	public void setAddress(String inAddress) {
		this.address.setText(inAddress);
	}

	public void setAddress2(String inAddress2) {
		this.address2.setText(inAddress2);
	}

	public void setState(String inState) {
		this.state.setText(inState);
	}

	public void setZip(String inZip) {
		this.zip.setText(inZip);
	}

	public void setPhone(String inPhone) {
		this.phone.setText(inPhone);
	}	

}
