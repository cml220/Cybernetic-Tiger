/*

 * Framework written by Brad Johnson
 * Contents written by Jeremy Guebert
 * NextBooks
 * 2011-2012

 */



package gui;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;

import model.Book;
import model.User;
import controllers.Controller;
import dbprocess.DatabaseProcess;

/**

 * Panel for editing and viewing a users own account information.

 * @author Brad

 *

 */

public class MyAccountPanel extends StyledPanel {



    /**

     * The user to be performing an update on.

     * This should normally be Controller.getCurrentUser().

     */

    private final User userToShow;



    /**

     * Inner class used for handling button updates

     * @author jlg327

     */

    private class UpdateListener implements ActionListener {



        /**

         * The type of field that must be updated

         * 1 for username, 2 for email

         */

        private final int field;



        /**

         * The new information to put in the appropriate user field

         */

        private String information;

        /**

         * Tells the updater to update the password field

         */

        public static final int PASSWORD_FIELD = 1;



        /**

         * Tells the updater to update the

         */

        public static final int EMAIL_FIELD = 2;

        /**

         * Creates an update listener and tells it which field is to be updated

         * @param string

         */

        public UpdateListener(int field, String information) {

            this.field = field;

            this.information = information;

        }



        /**

         * Handles the case of a user pressing the update button

         */

        @Override

        public void actionPerformed(ActionEvent arg0) {

            String userPassword = "";
            String newPassword = "";

            try {

                userPassword = DatabaseProcess.getInstance().getUserPassWord(userToShow.username);

            } catch (SQLException e1) {

                // TODO Auto-generated catch block

                e1.printStackTrace();

            }

            switch (field) {

            case(PASSWORD_FIELD):
                information = passwordPanel.getText();
            newPassword = information;
            break;

            case(EMAIL_FIELD):
                information = emailPanel.getText();
            userToShow.email = information;
            newPassword = userPassword;
            break;

            default:

                // This is an error case - the only things that are allowed to be updated

                // at present are username and email - This should probably throw an Exception

                break;

            }

            try {

                Controller.changeUserInfo(userToShow.username, userToShow, userPassword, newPassword);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    /**

     * Serial version ID, added for improved system performance and maintenance

     */

    private static final long serialVersionUID = -6750536388415434300L;
    private LabeledInputField passwordPanel;
    private LabeledInputField emailPanel;



    /**

     * Constructs the panel.
     * @throws SQLException I'm pretty sure this will be eliminated when testing code is removed and real code is implemented

     */

    public MyAccountPanel() throws SQLException {



        this.setLayout(new GridLayout(0, 1));
        this.setOpaque(false);


        JLabel headerLabel = new JLabel("Account Details");
        headerLabel.setForeground(PanelsManager.UNSELECTEDBLUE);

        // TODO: Make update buttons work

        userToShow = Controller.getCurrentUser();

        // Stop constructing things if the current user is null
        if (userToShow != null) {

            userToShow.rentals = new ArrayList<Book>();

            // Handle the username
            JLabel usernameLabel = new JLabel("Username: " + userToShow.username);
            usernameLabel.setForeground(PanelsManager.UNSELECTEDBLUE);

            // Handle the password

            passwordPanel = new LabeledInputField("Password:", "Update");
            passwordPanel.setText("********");
            passwordPanel.addActionListener(new UpdateListener(UpdateListener.PASSWORD_FIELD, passwordPanel.getText()));

            // Handle the email

            emailPanel = new LabeledInputField("Email:", "Update");
            emailPanel.setText(userToShow.email);
            emailPanel.addActionListener(new UpdateListener(UpdateListener.EMAIL_FIELD, emailPanel.getText()));

            // Handle the isAdmin flag

            JLabel isAdminLabel = new JLabel("Administrator:   " + userToShow.isAdmin);
            isAdminLabel.setForeground(PanelsManager.UNSELECTEDBLUE);

            // Handle the list of book rentals

            String bookList = "";

            if (userToShow.rentals != null) {
                for (Book b : userToShow.rentals) {
                    bookList += b.title + "\n";
                }
            }

            JLabel rentalsLabel = new JLabel("Rentals:\n" + bookList);
            rentalsLabel.setForeground(PanelsManager.UNSELECTEDBLUE);

            // Add all of the components to the overall panel

            this.add(headerLabel);

            this.add(usernameLabel);

            this.add(passwordPanel);

            this.add(emailPanel);

            this.add(isAdminLabel);

            this.add(rentalsLabel);
        }

    }

}

