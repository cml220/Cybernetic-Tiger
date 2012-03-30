import gui.LoginFrame;

import java.awt.EventQueue;
import java.awt.Toolkit;

/**
 * NextBooks is an application for purchasing and reading eBooks.
 * @author Brad Johnson baj231 11044123
 *
 */
public class Main {

    /**
     * Main.
     * @param args
     */
    public static void main(final String[] args) {

        /*
         * Change eventqueue so that it displays dialog box
         * for unhandled exceptions
         */
        EventQueue queue = Toolkit.getDefaultToolkit().getSystemEventQueue();
        queue.push(new EventQueueProxy());

        /*
         * Show login window.
         */

        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);

    }

}