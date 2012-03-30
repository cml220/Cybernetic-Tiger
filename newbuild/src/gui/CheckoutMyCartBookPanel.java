package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import model.Book;
import controllers.Controller;

public class CheckoutMyCartBookPanel extends BookPanel {


    /**
     * 
     */
    private static final long serialVersionUID = 7804397733163019229L;

    public CheckoutMyCartBookPanel(final Book book){

        super(book);

        DecimalFormat df = new DecimalFormat("###,###,###.##");

        super.getPrimaryButton().setText("Remove from cart");
        super.getPrimaryButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    // remove the book from the cart
                    Controller.removeFromCart(book);
                    PanelsManager.updateCart(true);

                }
                catch (Exception e2){
                    PanelsManager.displayError("Failed to remove from cart. \nPlease contact technical support.");
                }
            }


        });
        super.getButtonsPanel().add(super.getPrimaryButton());

        super.getRentalInfoLabel().setText("Price: " + df.format(book.price));
        super.getRentalInfoPanel().add(super.getRentalInfoLabel());

    }

}
