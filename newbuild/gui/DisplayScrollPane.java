package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class DisplayScrollPane extends JScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2561392613587167883L;

	public DisplayScrollPane(JPanel innerPanel){
		
		super(innerPanel,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);		
		
		this.setBorder(PanelsManager.defaultBorder);
		
		this.getVerticalScrollBar().setUnitIncrement(20);
		
	}
	
}
