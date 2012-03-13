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
		
		super.getPrimaryButton().setText("Remove from cart");
		super.getButtonsPanel().add(super.getPrimaryButton());

		super.getRentalInfoLabel().setText("Price: " + df.format(price));
		super.getRentalInfoPanel().add(super.getRentalInfoLabel());
		
	}
	
}
