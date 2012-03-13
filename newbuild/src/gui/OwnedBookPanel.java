/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

public class OwnedBookPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5401241274318892383L;

	/*
	 * Panel for displaying a single RENTED book and its information
	 */
	public OwnedBookPanel(){
		
		this.setLayout(new BorderLayout());
		
		/*
		 * Make each book panel 200 pixels tall.  Let the panel its in determine its width.
		 */
		this.setPreferredSize(new Dimension(this.getWidth(), 200));
		
		/*
		 * This will be the book cover
		 */
		JButton bookIcon = new JButton("Book Image Placeholder");
		bookIcon.setPreferredSize(new Dimension(200, 180));
		
		/*
		 * Book cover goes on the left side
		 */
		this.add(bookIcon, BorderLayout.WEST);
		
		
	}
	
}
