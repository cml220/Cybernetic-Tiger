package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class CheckoutPaymentFieldsPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1770411281976756228L;
    // member fields
    private LongPanel expiryMonth;
    private LongPanel expiryYear;
    private LongPanel securityCode;
    private LongPanel cardNumber;
    private LongPanel name;
    private LongPanel country;
    private LongPanel address;
    private LongPanel address2;
    private LongPanel state;
    private LongPanel zip;
    private LongPanel phone;

    /**
     * Create the panel.
     */
    public CheckoutPaymentFieldsPanel() {
        this.renderPanel();

        // TODO: show the data stored remotely as a helpful hint, are we removing this??
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

        // TODO: can the controller store this for me?? show the data stored locally
    }

    class LongStyledTextField extends JTextField {

        /**
         * ID.
         */
        private static final long serialVersionUID = 6491335439006536853L;

        public LongStyledTextField() {

            this.setColumns(20);
            this.setFont(new Font("Times New Roman", Font.BOLD,
                    20));
            this.setBorder(PanelsManager.FORMBORDER);

        }

    }

    class LongPanel extends JPanel {

        /**
         * ID.
         */
        private static final long serialVersionUID = 7541096846073319098L;
        LongStyledTextField field;

        LongPanel(String value) {

            this.setLayout(new BorderLayout());
            this.setOpaque(false);

            JPanel labelPanel = new JPanel();
            labelPanel.setSize(new Dimension(100,30));
            labelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JLabel label = new JLabel(value);
            label.setForeground(PanelsManager.UNSELECTEDBLUE);

            labelPanel.add(label);

            JPanel fieldPanel = new JPanel();
            fieldPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

            field = new LongStyledTextField();
            fieldPanel.add(field);

            this.add(labelPanel, BorderLayout.WEST);
            this.add(fieldPanel, BorderLayout.EAST);

        }

        public String getText() {

            return field.getText();

        }

        public void setText(String value) {

            field.setText(value);

        }

    }

    private void renderPanel()
    {
        // the little border
        setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

        setLayout(new GridLayout(0,1));
        setOpaque(false);

        // Start adding labels and fields where appropriate
        // Card
        cardNumber = new LongPanel("Card Number: ");
        add(cardNumber);

        expiryMonth = new LongPanel("mm");
        add(expiryMonth);

        expiryYear = new LongPanel("yyyy");
        add(expiryYear);

        securityCode = new LongPanel("Security Code");
        add(securityCode);

        name = new LongPanel("Name:");
        add(name);

        country = new LongPanel("Country:");
        add(country);

        address = new LongPanel("Address:");
        add(address);

        address2 = new LongPanel("");
        add(address2);

        state = new LongPanel("State:");
        add(state);

        zip = new LongPanel("Zip Code:");
        add(zip);

        phone = new LongPanel("Phone No:");
        add(phone);

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

    @Override
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

    @Override
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
