package gui;

import java.text.DecimalFormat;

public class SearchBookPanel extends BookPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5162648801797138348L;

	public SearchBookPanel(String title, String desc, String author, String location, int amtOnHand, Double price){
		
		super(title, desc, author, location);

		DecimalFormat df = new DecimalFormat("###,###,###.##");
		
		primaryButton.setText("Rent book");
		buttonsPanel.add(primaryButton);

		rentalInfoLabel.setText("Price: " + df.format(price));
		rentalInfoPanel.add(rentalInfoLabel);
		
	}
	
}
