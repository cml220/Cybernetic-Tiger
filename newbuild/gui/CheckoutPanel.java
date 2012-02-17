package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import exceptions.GUINoSuchPanelException;

public class CheckoutPanel extends DisplayPanel {

    private static int curPanelNum;
    private static int totalPanelsNum;
    private static JPanel cartMainPanel;
    
    public static final int CART = 0;
    public static final int PAYMENT = 1;
    public static final int VERIFY = 2;
    public static final int THANKYOU = 3;
    
    public CheckoutPanel(){
        
        curPanelNum = 0;
        totalPanelsNum = 0;
        this.setLayout(new BorderLayout());
        
        cartMainPanel = new JPanel();
        cartMainPanel.setLayout(new CardLayout());
     
        /*
         * Add the payment panels in order
         */
        this.addIndexedPanel(new CheckoutMyCartPanel(), CART);
        this.addIndexedPanel(new CheckoutPaymentPanel(), PAYMENT);
        this.addIndexedPanel(new CheckoutVerifyPanel(), VERIFY);
        this.addIndexedPanel(new CheckoutThankyouPanel(), THANKYOU);
        
        this.add(new JScrollPane(cartMainPanel), BorderLayout.CENTER);
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(0,1));
        bottomPanel.add(new CheckoutMyCartExtrasPanel());
        bottomPanel.add(new CheckoutCheckoutProgressPanel(0));
        
        this.add(bottomPanel, BorderLayout.SOUTH);
        
        
    }
    
    private void addIndexedPanel(final JPanel panel, final int stepNo){
        
        cartMainPanel.add(panel, Integer.toString(stepNo));
        totalPanelsNum++;
        
    }
    
    
    public static void nextPaymentStep(){

        if(curPanelNum < totalPanelsNum){
            
            curPanelNum++;
            CardLayout cl = (CardLayout) cartMainPanel.getLayout();
            cl.show(cartMainPanel, Integer.toString(curPanelNum));

            //TODO: Jake 
            //Use ProgressPanel and just enable the buttons as the payment
            //progresses.
            //Rather than having seperate "Extra" panels for each step, just
            //have a static method that changes the text on the button.
            //CheckoutCheckoutProgressPanel.nextPaymentStep()

        }
    }
    
    public static void jumpToPaymentStep(int stepNo) throws GUINoSuchPanelException{
        
        if(stepNo > totalPanelsNum){
            
            throw new GUINoSuchPanelException();
            
        }
        
        CardLayout cl = (CardLayout) cartMainPanel.getLayout();
        cl.show(cartMainPanel, Integer.toString(stepNo));
        
        curPanelNum = stepNo;
        
    }
    
}
