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
public class MainFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 2269971701250845501L;

    /**
     * Constructor; positions the window and adds the inner sections.
     */
    public MainFrame() {

        this.setTitle("NextBooks 2.0");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(300, 100, 1000, 700);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        SidePanel sidePanel = new SidePanel();
        MainPanel mainPanel = new MainPanel();

        this.add(mainPanel, BorderLayout.CENTER);
        this.add(sidePanel, BorderLayout.EAST);

    }

}
