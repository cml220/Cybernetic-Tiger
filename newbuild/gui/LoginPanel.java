package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controllers.Controller;
import exceptions.ControllerNotInitializedException;

/**
 * Panel for logging into the system.
 * @author Brad Johnson baj231 11044123
 *
 */
public class LoginPanel extends JPanel {

    /**
     * Label with formatting for the login page.
     * @author Brad Johnson baj231 11044123
     *
     */
    class LoginLabel extends JLabel {

        /**
         * 
         */
        private static final long serialVersionUID = -6307916833027834382L;

        /**
         * Label style used throughout this panel.
         * @param caption - the text to show
         */
        LoginLabel(final String caption) {

            super(caption);
            this.setForeground(Color.WHITE);

        }

    }

    /**
     * Panel with label and input form.
     * @author Brad Johnson baj231 11044123
     *
     */
    class InputWithLabelPanel extends JPanel {

        /**
         * ID.
         */
        private static final long serialVersionUID = 2068050659946866149L;

        /**
         * The text entry field.
         */
        private JTextField inputField;

        private final int fieldWidth = 10;

        /**
         * Construct a panel with a label and input field.
         * @param labelText the text to put in the label
         * @param isPassword set true to hide characters
         */
        public InputWithLabelPanel(final String labelText,
                final boolean isPassword) {

            super();
            this.setLayout(new FlowLayout());

            /*
             * Set the background to invisible so the pretty background can
             * show through.
             */
            this.setOpaque(false);

            JLabel label = new LoginLabel(labelText);

            /*
             * If this panel has a password field, hide the characters.
             */
            if (isPassword) {

                inputField = new JPasswordField();

            } else {

                inputField = new JTextField();

            }

            inputField.setColumns(fieldWidth);

            this.add(label);
            this.add(inputField);

        }

        @Override
        /**
         * place the text cursor in the text box in this panel.
         */
        public void requestFocus() {

            this.inputField.requestFocus();

        }

        /**
         * Get the text from the text field in this panel.
         * @return the text from the textField in this panel.
         */
        public String getText() {

            return inputField.getText();

        }

    }

    /**
     * ID.
     */
    private static final long serialVersionUID = -5100212021194753173L;

    /**
     * Panel for entering login information.
     */
    public LoginPanel() {

        /*
         * Initialize the main controller.
         */
        Controller.initialize();

        /*
         * Align all JComponents along the center.
         */
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        /*
         * A text area for the username with label.
         */
        final InputWithLabelPanel usernamePanel =
                new InputWithLabelPanel("Username", false);
        usernamePanel.requestFocus();

        /*
         * A text area for the password with label.
         */
        final InputWithLabelPanel passwordPanel =
                new InputWithLabelPanel("Password", true);

        /*
         * Log in button.
         */
        JButton loginButton = new JButton("Log In");
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {

                /*
                 * Try login information
                 */
                try {

                    /*
                     * If the login info is correct, open up the program.
                     */
                    try {
						if (Controller.checkLogin(usernamePanel.getText(),
						        passwordPanel.getText())) {

						    /*
						     * Initialize the GUI manager
						     */
						    PanelsManager.initialise();

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

						} else {

						    /*
						     * If the login information didn't match anything in
						     * the database, prompt the user.
						     */
						    JOptionPane.showMessageDialog(null,
						            "Could not validate account.\nCheck your password.",
						            "Login Error", JOptionPane.ERROR_MESSAGE);

						}
					} catch (HeadlessException e) {
					    JOptionPane.showMessageDialog(null,
					            "Error Logging In (Headless Exception from checkLogin)",
					            "Login Error", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					} catch (SQLException e) {
					    JOptionPane.showMessageDialog(null,
					            "Error Logging In (SQLException from checkLogin)",
					            "Login Error", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}

                    /*
                     * If the controller failed to initialize, prompt the user.
                     */
                } catch (ControllerNotInitializedException e) {

                    JOptionPane.showMessageDialog(null,
                            "Controller not initialized", "Fatal Error",
                            JOptionPane.ERROR_MESSAGE);

                }

            }

        });

        /*
         * Button for skipping the login step.
         * TODO: Remove this before deployment.
         */
        JButton debugButton = new JButton("SKIP (Debug)");
        debugButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {

                /*
                 * Initialize the GUI manager
                 */
                PanelsManager.initialise();

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

            }

        });

        /*
         * Blank space to center the input areas.
         */
        this.add(Box.createRigidArea(new Dimension(100, 200)));

        /*
         * Input areas.
         */
        this.add(usernamePanel);
        this.add(passwordPanel);

        /*
         * Buttons
         */
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setOpaque(false);
        buttonPanel.add(loginButton);
        buttonPanel.add(debugButton);
        this.add(buttonPanel);

        /*
         * Blank space to center the input areas.
         */
        this.add(Box.createRigidArea(new Dimension(100, 200)));

    }

    @Override
    /**
     * Draw background on the panel.
     * @param g the default graphics on the panel
     */
    public void paintComponent(final Graphics g) {

        Image background = null;

        /*
         * Load the image for the background
         */
        background = (new ImageIcon(getClass().getResource("bg.jpg"))).getImage();


        super.paintComponent(g);

        /*
         * Paint the background
         */
        if (background != null) {

            g.drawImage(background, 0, 0, background.getWidth(this),
                    background.getHeight(this), this);

        }

    }

}
