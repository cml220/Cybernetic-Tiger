package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import model.PaymentInfo;

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
    private final ThreePairsPanel cardDetails;
    private final PairPanel cardNumber;
    private final PairPanel name;
    private final PairPanel country;
    private final PairPanel address;
    private final PairPanel address2;
    private final PairPanel state;
    private final PairPanel zip;
    private final PairPanel phone;


    /**
     * Create the panel, but the option to disable all the fields is available.
     * @param inDisabled
     */
    public CheckoutPaymentFieldsPanel(boolean allText) {

        // the little border
        setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

        setLayout(new GridLayout(0,1));
        setOpaque(false);

        // Start adding labels and fields where appropriate
        // Card
        cardNumber = new PairPanel("Card Number: ", true, allText);
        add(cardNumber);

        cardDetails = new ThreePairsPanel("mm", "yyyy", "Code", allText);
        add(cardDetails);

        name = new PairPanel("Name:", true, allText);
        add(name);

        country = new PairPanel("Country:", true, allText);
        add(country);

        address = new PairPanel("Address:", true, allText);
        add(address);

        address2 = new PairPanel("", true, allText);
        add(address2);

        state = new PairPanel("State:", true, allText);
        add(state);

        zip = new PairPanel("Zip Code:", false, allText);
        add(zip);

        phone = new PairPanel("Phone No:", false, allText);
        add(phone);


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

        JComponent field;

        PairPanel(String value, boolean isLong, boolean allText) {

            this.setLayout(new BorderLayout());
            this.setOpaque(false);

            JPanel labelPanel = new JPanel();

            if (!allText) {

                labelPanel.setSize(new Dimension(100,30));

            } else {

                labelPanel.setSize(new Dimension(100, 10));

            }

            labelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            labelPanel.setOpaque(false);

            JLabel label = new JLabel(value);
            label.setForeground(PanelsManager.UNSELECTEDBLUE);

            labelPanel.add(label);

            JPanel fieldPanel = new JPanel();

            fieldPanel.setOpaque(false);

            if(allText) {

                fieldPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                field = new JLabel();

            } else {

                fieldPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
                field = new StyledTextField(isLong);

            }

            fieldPanel.add(field);

            this.add(labelPanel, BorderLayout.WEST);

            if(allText){

                this.add(fieldPanel, BorderLayout.CENTER);

            } else {

                this.add(fieldPanel, BorderLayout.EAST);

            }
        }

        public String getText() {

            if(field instanceof StyledTextField) {

                return ((StyledTextField) field).getText();

            } else {

                return ((JLabel) field).getText();

            }

        }

        public void setText(String value) {

            if(field instanceof StyledTextField) {

                ((StyledTextField) field).setText(value);

            } else {

                ((JLabel) field).setText(value);

            }

        }

    }

    class ThreePairsPanel extends JPanel {

        /**
         * ID.
         */
        private static final long serialVersionUID = -6192185986196812762L;

        PairPanel[] panels;

        ThreePairsPanel(String val1, String val2, String val3, boolean allText) {

            panels = new PairPanel[3];

            this.setLayout(new BorderLayout());
            this.setOpaque(false);

            panels[MONTH] = new PairPanel(val1, false, allText);
            panels[YEAR] = new PairPanel(val2, false, allText);
            panels[CODE] = new PairPanel(val3, false, allText);

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

    /**
     * Return a PaymentInfo object based on the entered fields.
     */
    public PaymentInfo getPaymentInfo() {

        PaymentInfo pulledInfo = new PaymentInfo();
        pulledInfo.setAddress(getAddress());
        pulledInfo.setAddress2(getAddress2());
        pulledInfo.setCardNumber(getCardNumber());
        pulledInfo.setCountry(getCountry());
        pulledInfo.setExpiryMonth(getExpiryMonth());
        pulledInfo.setExpiryYear(getExpiryYear());
        pulledInfo.setName(getName());
        pulledInfo.setPhone(getPhone());
        pulledInfo.setSecurityCode(getSecurityCode());
        pulledInfo.setState(getState());
        pulledInfo.setZip(getZip());

        return pulledInfo;

    }

    /**
     * Set the text in the boxes given a paymentinfo object.
     */
    public void setFields(PaymentInfo pi) {

        setAddress(pi.getAddress());
        setAddress2(pi.getAddress2());
        setCardNumber(pi.getCardNumber());
        setCountry(pi.getCountry());
        setExpiryMonth(pi.getExpiryMonth());
        setExpiryYear(pi.getExpiryYear());
        setName(pi.getName());
        setPhone(pi.getPhone());
        setSecurityCode(pi.getSecurityCode());
        setState(pi.getState());
        setZip(pi.getZip());

    }
}
