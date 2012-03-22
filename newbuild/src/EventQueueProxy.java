/**
 * Stolen shamelessly from:
 * http://ruben42.wordpress.com/2009/03/30/catching-all-runtime-exceptions-in-swing/
 */


import java.awt.AWTEvent;
import java.awt.EventQueue;

import javax.swing.JOptionPane;

/**
 * Modification of the Java Swing event queue which displays exceptions in
 * dialog boxes.
 * @author Modified by Brad Johnson baj231 11044123
 *
 */
public class EventQueueProxy extends EventQueue {

    @Override
    protected void dispatchEvent(final AWTEvent newEvent) {

        try {

            super.dispatchEvent(newEvent);

        } catch (Throwable t) {

            t.printStackTrace();
            String message = t.getMessage();

            if (message == null || message.length() == 0) {

                message = "Fatal: " + t.getClass();

            }

            JOptionPane.showConfirmDialog(null, "Something has failed!\n" +
                    "Send crash information to Cybernetic Tiger?\n" +
                    "(This doesn't actually happen yet)", "Uncaught Exception",
                    JOptionPane.YES_NO_OPTION);

            /*
             * TODO: Add option to send stack trace to Cybernetic Tiger?
             */
        }
    }
}