/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

	class BookPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5401241274318892383L;

	JPanel rentalInfoPanel, buttonsPanel;
	BookLabel rentalInfoLabel;
	JButton primaryButton;
	
	class BookLabel extends JLabel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		/*
		 * Font styling for the book panel parts
		 */
		public BookLabel(String text, boolean isHeader){
			
			super(text);
			
			if(isHeader)
			{
			
				this.setFont(new Font(PanelsManager.bodyFont, Font.BOLD, 24));
				this.setForeground(PanelsManager.selectedBlue);
			
			}
			else
			{
			
				this.setFont(new Font(PanelsManager.bodyFont, Font.PLAIN, 12));
				this.setForeground(PanelsManager.selectedBlue);
				
			}
			
		}
		
	
	}
	
	/*
	 * Panel for displaying a single RENTED book and its information
	 */
	public BookPanel(String title, String desc, String author, String imageLocation){
		
		super();
		
		this.setLayout(new BorderLayout());
		this.setBorder(new LineBorder(PanelsManager.backgroundBlue, 1));
		
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
		 * Book title
		 */
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new GridLayout(0,1));
		BookLabel titleLabel = new BookLabel(title, true);
		titlePanel.add(titleLabel);
		
		/*
		 * Information panel:  Description, author, ...
		 */
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(0,1));
		BookLabel descLabel = new BookLabel(desc, false);
		BookLabel authorLabel = new BookLabel(author, false);
		infoPanel.add(descLabel);
		infoPanel.add(authorLabel);
		
		/*
		 * Panel which contains title panel at top and info panel at bottom
		 */
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new BorderLayout());
		middlePanel.add(titlePanel, BorderLayout.NORTH);
		middlePanel.add(infoPanel, BorderLayout.CENTER);
		
		/*
		 * Panel containing 'action' button.  
		 * eg: Read now, rent now, etc.
		 */
		buttonsPanel = new JPanel();
		primaryButton = new JButton("");
		
		/*
		 * Information about the rental
		 * eg: price, quantity on hand or days remainings
		 */
		rentalInfoPanel = new JPanel();
		rentalInfoLabel = new BookLabel("", false);
		
		/*
		 * Right half of book panel.
		 * Contains buttons at top and rental into at bottom
		 */
		JPanel rightSidePanel = new JPanel();
		rightSidePanel.setLayout(new BorderLayout());
		rightSidePanel.add(buttonsPanel, BorderLayout.NORTH);
		rightSidePanel.add(rentalInfoPanel, BorderLayout.SOUTH);
		
		/*
		 * Add the three main sections:
		 * Book icon 
		 * Middle panel - title, details
		 * Right Panel - buttons, rental info
		 */
		this.add(bookIcon, BorderLayout.WEST);
		this.add(middlePanel, BorderLayout.CENTER);
		this.add(rightSidePanel, BorderLayout.EAST);
		
	}
	
}
