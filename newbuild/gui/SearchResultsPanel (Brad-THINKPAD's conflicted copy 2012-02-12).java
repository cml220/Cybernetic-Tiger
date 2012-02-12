/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class SearchResultsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7862774713466486186L;

	public SearchResultsPanel(){
		
		this.setLayout(new GridLayout(0,1));
		
		this.loadBooks();
		
		//TODO: Search results
		
	}
	
	private void loadBooks()
	{
		
		/*
		 * Skeleton implementation
		 * In future, this will create book panels from the database/cache
		 */
		this.add(new SearchBookPanel("Oxford English Dictionary", "Words and stuff.","some guy", "http://somewhere", 15, 22.50));
		this.add(new SearchBookPanel("Collins Pocket French Dictionary", "French words and stuff.", "un garcon", "http://lesomewherre", 19, 19.75));
		this.add(new SearchBookPanel("College Physics", "PHYSICS", "Physics person", "httphysics", 12, 99.99));
		this.add(new SearchBookPanel("A Clockwork Orange", "No time for the old in-out in-out love.","Anthony Burgess", "http://droogs", 155, 12.63));
		this.add(new SearchBookPanel("Another Clockwork Orange", "No time for the old in-out in-out love.","Anthony Burgess", "http://droogs", 155, 12.63));
		this.add(new SearchBookPanel("An Additional Clockwork Orange", "No time for the old in-out in-out love.","Anthony Burgess", "http://droogs", 155, 12.63));
		this.add(new SearchBookPanel("Not A Clockwork Orange", "No time for the old in-out in-out love.","Anthony Burgess", "http://droogs", 155, 12.63));
		
		
	}
	
}
