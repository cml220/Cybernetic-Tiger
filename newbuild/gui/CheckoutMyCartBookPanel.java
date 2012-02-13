package gui;

import java.text.DecimalFormat;

public class CheckoutMyCartBookPanel extends BookPanel {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7804397733163019229L;

	public CheckoutMyCartBookPanel(String title, String desc, String author, String location, int amtOnHand, Double price){
		
		super(title, desc, author, location);

		DecimalFormat df = new DecimalFormat("###,###,###.##");
		
		primaryButton.setText("Remove from cart");
		buttonsPanel.add(primaryButton);

		rentalInfoLabel.setText("Price: " + df.format(price));
		rentalInfoPanel.add(rentalInfoLabel);
		
	}
	
}
