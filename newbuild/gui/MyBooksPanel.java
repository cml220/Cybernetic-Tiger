/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.GridLayout;
import javax.swing.JPanel;


public class MyBooksPanel extends JPanel 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -25250717196528793L;

	public MyBooksPanel()
	{
		
		/*
		 * Stack panels vertically, 1 column
		 */
		this.setLayout(new GridLayout(0,1));
		
		/*
		 * Load the book panels
		 */
		this.loadBooks();
		
	}
	
	private void loadBooks()
	{
		
		/*
		 * Skeleton implementation
		 * In future, this will create book panels from the database/cache
		 */
		this.add(new OwnedBookPanel());
		this.add(new OwnedBookPanel());
		this.add(new OwnedBookPanel());
		this.add(new OwnedBookPanel());
		this.add(new OwnedBookPanel());
		this.add(new OwnedBookPanel());
		this.add(new OwnedBookPanel());
		this.add(new OwnedBookPanel());
		this.add(new OwnedBookPanel());
		this.add(new OwnedBookPanel());
		this.add(new OwnedBookPanel());
		this.add(new OwnedBookPanel());
		this.add(new OwnedBookPanel());
		this.add(new OwnedBookPanel());
		this.add(new OwnedBookPanel());
		this.add(new OwnedBookPanel());
		this.add(new OwnedBookPanel());
		this.add(new OwnedBookPanel());


		
	}
	
}
