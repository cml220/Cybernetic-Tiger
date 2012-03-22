import gui.LoginFrame;

import java.awt.EventQueue;
import java.awt.Toolkit;

public class Main {

    public static void main(String[] args){

        /*
         * Change eventqueue so that it displays dialog box for unhandled exceptions
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