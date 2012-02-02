/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2269971701250845501L;

	public MainFrame(){
		
		this.setTitle("NextBooks 2.0");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 900, 700);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		SidePanel sidePanel = new SidePanel();
		MainPanel mainPanel = new MainPanel();

		this.add(mainPanel, BorderLayout.CENTER);

		this.add(sidePanel, BorderLayout.EAST);
		
	}
	
}
