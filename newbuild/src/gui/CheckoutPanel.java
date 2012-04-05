package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controllers.Controller;
import exceptions.GUINoSuchPanelException;

public class CheckoutPanel extends DisplayPanel {

    /**
     * 
     */
    private static final long serialVersionUID = -44778006080533928L;
    private static int curPanelNum;
    private static int totalPanelsNum;
    private static JPanel cartMainPanel;
    private static CheckoutActionsPanel cartActionsPanel;
    private static CheckoutProgressPanel cartProgressPanel;
    private static CheckoutPaymentPanel checkoutPaymentPanel;

    public static final int CART = 0;
    public static final int PAYMENT = 1;
    public static final int VERIFY = 2;
    public static final int THANKYOU = 3;
    private static final int SCROLLSPEED = 20;
    public CheckoutPanel(){

        curPanelNum = 0;
        totalPanelsNum = 0;
        this.setLayout(new BorderLayout());

        cartMainPanel = new JPanel();
        cartMainPanel.setLayout(new CardLayout());

        /*
         * Add the payment panels in order
         */
        JScrollPane cartContentsScrollPane = new JScrollPane(new CheckoutMyCartPanel());

        cartContentsScrollPane.getVerticalScrollBar().setUnitIncrement(SCROLLSPEED);
        CheckoutPanel.addIndexedPanel(cartContentsScrollPane, CART);
        checkoutPaymentPanel = new CheckoutPaymentPanel();
        CheckoutPanel.addIndexedPanel(checkoutPaymentPanel, PAYMENT);
        CheckoutPanel.addIndexedPanel(new CheckoutThankyouPanel(), THANKYOU);

        this.add(cartMainPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(0,1));
        cartActionsPanel = new CheckoutActionsPanel();
        bottomPanel.add(cartActionsPanel);
        cartProgressPanel = new CheckoutProgressPanel();
        bottomPanel.add(cartProgressPanel);

        this.add(bottomPanel, BorderLayout.SOUTH);


    }

    private static void addIndexedPanel(final JComponent panel, final int stepNo){

        cartMainPanel.add(panel, Integer.toString(stepNo));
        totalPanelsNum++;

    }

    private static void updateStage(int inCheckoutStage)
    {
        // Updates the actions panel and progress panel where appropriate

        switch (inCheckoutStage)
        {
        case(CART):		CheckoutActionsPanel.loadCartActions(); 	cartProgressPanel.loadCartProgress(); 		break;	// Cart
        case(PAYMENT):	CheckoutActionsPanel.loadPaymentActions(); 	cartProgressPanel.loadPaymentProgress();	break;	// Payment
        case(VERIFY):	CheckoutActionsPanel.loadVerifyActions(); 	cartProgressPanel.loadVerifyProgress();		break;	// Verify Cart/Payment
        case(THANKYOU):	CheckoutActionsPanel.loadThankyouActions(); cartProgressPanel.loadThankyouProgress();	break;	// Thankyou
        default: 		throw new IllegalArgumentException("Invalid checkout stage." + inCheckoutStage);				// Throw exception, invalid checkout stage
        }

    }


    public static void nextPaymentStep(){

        if(curPanelNum < totalPanelsNum){

            CardLayout cl = (CardLayout) cartMainPanel.getLayout();

            /*
             * Save payment info before proceeding
             */
            if(curPanelNum == PAYMENT) {

                Controller.setSessionPaymentInfo(checkoutPaymentPanel.getPaymentInfo());

                addIndexedPanel(new CheckoutVerifyPanel(), VERIFY);

            }

            /*
             * Processes the payment
             */
            if (curPanelNum == VERIFY) {
                // then we want to go to thankyou after processing
                try {

                    Controller.processPurchase();

                }
                catch(Exception e){
                    e.printStackTrace();

                    PanelsManager.displayError("Failed to process purchase.");

                }
            }

            /*
             * Sets the checkout back to the cart stage as it has now finished
             */
            if (curPanelNum == THANKYOU) {
                // then we want to go to home
                // but first set the checkout back to stage 1 (currPanel -4)
                curPanelNum-=4;
                // goto the default panel :D
                PanelsManager.goToDefaultPanel();
            }

            curPanelNum++;

            cl.show(cartMainPanel, Integer.toString(curPanelNum));

            updateStage(curPanelNum);
        }
    }

    public static void previousPaymentStep(){

        if(curPanelNum > -1){

            curPanelNum--;
            CardLayout cl = (CardLayout) cartMainPanel.getLayout();
            cl.show(cartMainPanel, Integer.toString(curPanelNum));

            updateStage(curPanelNum);
        }
    }

    public static void jumpToPaymentStep(int stepNo) throws GUINoSuchPanelException{

        if(stepNo >= totalPanelsNum){

            throw new GUINoSuchPanelException();

        }

        CardLayout cl = (CardLayout) cartMainPanel.getLayout();
        cl.show(cartMainPanel, Integer.toString(stepNo));

        curPanelNum = stepNo;

        updateStage(curPanelNum);

    }

}
