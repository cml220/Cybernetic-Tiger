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

    /**
     * Constants.
     */
    private final int MONTH = 0;
    private final int YEAR = 1;
    private final int CODE = 2;

    // member fields
    private ThreePairsPanel cardDetails;
    private PairPanel cardNumber;
    private PairPanel name;
    private PairPanel country;
    private PairPanel address;
    private PairPanel address2;
    private PairPanel state;
    private PairPanel zip;
    private PairPanel phone;

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
            cardDetails.setEnabled(false);
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

    class StyledTextField extends JTextField {

        /**
         * ID.
         */
        private static final long serialVersionUID = 6491335439006536853L;

        public StyledTextField(boolean isLong) {

            if(isLong){

                this.setColumns(30);

            } else {

                this.setColumns(8);

            }

            this.setFont(new Font("Times New Roman", Font.BOLD,
                    20));
            this.setBorder(PanelsManager.FORMBORDER);

        }

    }

    class PairPanel extends JPanel {

        /**
         * ID.
         */
        private static final long serialVersionUID = 7541096846073319098L;
        StyledTextField field;

        PairPanel(String value, boolean isLong) {

            this.setLayout(new BorderLayout());
            this.setOpaque(false);

            JPanel labelPanel = new JPanel();
            labelPanel.setSize(new Dimension(100,30));

            labelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            labelPanel.setOpaque(false);

            JLabel label = new JLabel(value);
            label.setForeground(PanelsManager.UNSELECTEDBLUE);

            labelPanel.add(label);

            JPanel fieldPanel = new JPanel();
            fieldPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            fieldPanel.setOpaque(false);

            field = new StyledTextField(isLong);
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

    class ThreePairsPanel extends JPanel {

        /**
         * ID.
         */
        private static final long serialVersionUID = -6192185986196812762L;
        PairPanel[] panels;

        ThreePairsPanel(String val1, String val2, String val3) {

            panels = new PairPanel[3];

            this.setLayout(new BorderLayout());

            panels[MONTH] = new PairPanel(val1, false);
            panels[YEAR] = new PairPanel(val2, false);
            panels[CODE] = new PairPanel(val3, false);

            this.add(panels[MONTH], BorderLayout.WEST);
            this.add(panels[YEAR], BorderLayout.CENTER);
            this.add(panels[CODE], BorderLayout.EAST);

        }

        public String getText(int pairNum) {

            return panels[pairNum].getText();

        }

        public void setText(String value, int pairNum) {

            panels[pairNum].setText(value);

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
        cardNumber = new PairPanel("Card Number: ", true);
        add(cardNumber);

        cardDetails = new ThreePairsPanel("mm", "yyyy", "Code");
        add(cardDetails);

        name = new PairPanel("Name:", true);
        add(name);

        country = new PairPanel("Country:", true);
        add(country);

        address = new PairPanel("Address:", true);
        add(address);

        address2 = new PairPanel("", true);
        add(address2);

        state = new PairPanel("State:", true);
        add(state);

        zip = new PairPanel("Zip Code:", false);
        add(zip);

        phone = new PairPanel("Phone No:", false);
        add(phone);

    }

    // public getters for all the field details
    public String getExpiryMonth() {
        return cardDetails.getText(MONTH);
    }

    public String getExpiryYear() {
        return cardDetails.getText(YEAR);
    }

    public String getSecurityCode() {
        return cardDetails.getText(CODE);
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
        this.cardDetails.setText(inExpiryMonth, MONTH);
    }

    public void setExpiryYear(String inExpiryYear) {
        this.cardDetails.setText(inExpiryYear, YEAR);
    }

    public void setSecurityCode(String inSecurityCode) {
        this.cardDetails.setText(inSecurityCode, CODE);
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
