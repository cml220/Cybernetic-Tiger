package gui;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

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
		
		// Using form layout, lots of code that has to be here :(
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		// Start adding labels and fields where appropriate
		// Card
		add(new JLabel("Card number:"), "2, 2");
		
		cardNumber = new JTextField();
		add(cardNumber, "6, 2, 9, 1, fill, default");
		cardNumber.setColumns(10);
		
		
		//Expriy
		add(new JLabel("Expiration date:"), "2, 4");
		
		expiryMonth = new JTextField();
		expiryMonth.setText("mm");
		add(expiryMonth, "6, 4, fill, default");
		expiryMonth.setColumns(2);
		
		expiryYear = new JTextField();
		expiryYear.setText("yyyy");
		add(expiryYear, "8, 4");
		expiryYear.setColumns(4);
		
		add(new JLabel("CVC:"), "12, 4, right, default");
		
		securityCode = new JTextField();
		add(securityCode, "14, 4");
		securityCode.setColumns(3);
		
		
		// Name
		add(new JLabel("Name:"), "2, 8");
		
		name = new JTextField();
		add(name, "6, 8, 9, 1, fill, default");
		name.setColumns(10);
		
		
		// Country
		add(new JLabel("Country:"), "2, 10");
		
		country = new JTextField();
		add(country, "6, 10, 9, 1, fill, default");
		country.setColumns(10);
		
		
		// Address
		add(new JLabel("Address:"), "2, 12");
		
		address = new JTextField();
		add(address, "6, 12, 9, 1, fill, default");
		address.setColumns(10);
		
		address2 = new JTextField();
		add(address2, "6, 14, 9, 1, fill, default");
		address2.setColumns(10);
		
		
		// State
		add(new JLabel("State:"), "2, 16");
		
		state = new JTextField();
		add(state, "6, 16, 5, 1, fill, default");
		state.setColumns(10);
		
		
		// Zip
		add(new JLabel("Zip:"), "2, 18");
		
		zip = new JTextField();
		add(zip, "6, 18, 4, 1, fill, default");
		zip.setColumns(10);		
		
		
		// Phone
		add(new JLabel("Phone:"), "2, 20");
		
		phone = new JTextField();
		add(phone, "6, 20, 5, 1, fill, default");
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
