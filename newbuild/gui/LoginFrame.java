/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.BorderLayout;

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
     * Constructor; positions the window and adds the inner sections.
     */
    public LoginFrame() {

        this.setTitle("NextBooks 2.0");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(500, 200, 800, 600);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        this.add(new LoginPanel());

    }

}
