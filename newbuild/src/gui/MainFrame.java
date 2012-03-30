/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JFrame;

import controllers.Controller;
import exceptions.ControllerNotInitializedException;

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
     * The width of the window.
     */
    private final int windowWidth = 1000;

    /**
     * The height of the window.
     */
    private final int windowHeight = 700;

    /**
     * Constructor; positions the window and adds the inner sections.
     */
    public MainFrame() {

        this.setTitle("NextBooks 2.0");

        /*
         * When the window is closed, save the user's cart to the database.
         */
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent we) {

                try {

                    Controller.updateCart();
                    System.exit(0);

                } catch (SQLException e) {

                    PanelsManager.displayError("Could not connect to the" +
                            "database.\nCart not saved");
                    e.printStackTrace();

                } catch (ControllerNotInitializedException e) {

                    PanelsManager.displayError("Controller not initialized.");
                    e.printStackTrace();

                }

            }

        });

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

        SidePanel sidePanel = new SidePanel();
        MainPanel mainPanel = new MainPanel();

        this.add(mainPanel, BorderLayout.CENTER);
        this.add(sidePanel, BorderLayout.EAST);

    }

}
