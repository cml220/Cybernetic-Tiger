package gui;

public class RentedBookPanel extends BookPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1259781312842495888L;

	public RentedBookPanel(String title, String desc, String author, String location, int daysRemain){
		
		super(title, desc, author, location);
		
		primaryButton.setText("Read Now");
		buttonsPanel.add(primaryButton);
		
		rentalInfoLabel.setText("Days remaining: " + Integer.toString(daysRemain));
		rentalInfoPanel.add(rentalInfoLabel);
		
	}
	
}
