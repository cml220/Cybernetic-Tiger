/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * The main frame for the NextBooks GUI.
 * Everything in the GUI goes in this.
 * @author Brad
 *
 */
public class LoginFrame extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 2269971701250845501L;

	/**
	 * The window width.
	 */
	private final int windowWidth = 800;

	/**
	 * The window height.
	 */
	private final int windowHeight = 600;

	/**
	 * Constructor; positions the window and adds the inner sections.
	 */
	public LoginFrame() {

		this.setTitle("NextBooks 2.0");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setSize(new Dimension(windowWidth, windowHeight));

		/*
		 * Center the window
		 */
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (dim.width - windowWidth) / 2;
		int y = (dim.height - windowHeight) / 2;

		/*
		 * Move the window
		 */
		this.setLocation(x, y);

		this.setResizable(false);
		this.setLayout(new BorderLayout());

		this.add(new LoginPanel());


	}

}
