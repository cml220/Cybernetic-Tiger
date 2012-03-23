package gui;

import gui.PanelsManager.InitTask;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class LoadingPanel extends StyledPanel implements PropertyChangeListener {

    /**
     * ID.
     */
    private static final long serialVersionUID = -7661627309702862617L;
    private JProgressBar progBar = null;
    private JLabel status = null;

    public static LoadingPanel instance;

    public static boolean initialized = false;

    /**
     * An intermediate panel to show the user info while the program loads.
     */
    public LoadingPanel() {

        super("bg.jpg");

        status = new JLabel(PanelsManager.getLoadStatus());
        status.setForeground(Color.WHITE);

        if(!initialized) {


            this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

            /*
             * Create a statically accessible instance of this panel
             */
            instance = this;

            /*
             * A progress bar to display how far along the loading process is
             */
            progBar = new JProgressBar(0, PanelsManager.getNumPanels());
            JPanel progBarPanel = new JPanel();
            progBarPanel.setLayout(new FlowLayout());
            progBarPanel.setOpaque(false);
            progBarPanel.add(progBar);

            /*
             * A verbose text label to inform the user what is happening
             */
            JPanel statusPanel = new JPanel();
            statusPanel.setLayout(new FlowLayout());
            statusPanel.setOpaque(false);
            statusPanel.add(status);

            /*
             * Put the panel together
             */
            this.add(Box.createVerticalStrut(250));
            this.add(progBarPanel);
            this.add(statusPanel);
            this.add(Box.createVerticalStrut(250));

            /*
             * Start initializing the Panels Manager in a separate thread
             */
            InitTask task = PanelsManager.getInitTask();
            task.addPropertyChangeListener(this);
            task.execute();

            /*
             * Show wait cursor
             */
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

            initialized = true;

        }
    }

    /**
     * What will happen when everything is done loading.
     */
    public void finish() {

        /*
         * Construct the GUI
         */
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);

        /*
         * Open the GUI to the default tab
         */
        PanelsManager.goToDefaultPanel();

        getTopLevelAncestor().setVisible(false);

        /*
         * Turn off the wait cursor
         */
        setCursor(null);

    }

    @Override
    /**
     * Reacts to a change in the InitTask thread.
     */
    public void propertyChange(PropertyChangeEvent evt) {

        /*
         * Update the status displays
         */
        if ("progress" == evt.getPropertyName()) {

            this.progBar.setValue(PanelsManager.getProgress());
            this.status.setText(PanelsManager.getLoadStatus());

        }
    }

}
