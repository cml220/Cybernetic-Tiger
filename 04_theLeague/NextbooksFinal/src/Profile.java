import controller.DatabaseProcess;
import obj.User;

/**
 *
 * @author cml220
 */
public class Profile extends javax.swing.JFrame {
    private User u;
    private Controller controller;
    private String url = "";

    /** Creates new Profile frame */
    public Profile(User u, Controller controller) {
        this.u=u;
        this.controller = controller;
        initComponents();
        this.setBounds(500,300,300,170);

    }

    /**
     * Initialize Profile frame components
     */
    private void initComponents() {
        imgprompt = new javax.swing.JLabel();
        imgurl = new javax.swing.JTextField();
        okaybtn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        okaybtn.setText("Okay");
        okaybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commitChanges(evt);
            }
        });
        getContentPane().add(okaybtn);
        okaybtn.setBounds(95, 90, 85, 25);

        cancelbtn.setText("Cancel");
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel(evt);
            }
        });
        getContentPane().add(cancelbtn);
        cancelbtn.setBounds(180, 90, 85, 25);

        getContentPane().add(imgprompt);
        imgprompt.setText("Enter a profile image url:");
        imgprompt.setBounds(10, 20, 200, 30);

        getContentPane().add(imgurl);
        imgurl.setBounds(150, 20, 120, 30);

        pack();
    }

    /**
     * On click "Okay" commit changes to the user using DatabaseProcess
     */
    private void commitChanges(java.awt.event.ActionEvent evt) {
        url = imgurl.getText();
        try {
            DatabaseProcess db = DatabaseProcess.getInstance();
            db.editUserProfilePic(url, u.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        controller.setUserIMG();
        this.dispose();
    }

    /**
     * On click "Cancel" dispose this frame
     * @param evt
     */
    private void cancel(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                // new Confirm(1).setVisible(true);
            }
        });
    }

    /* Profile frame component declarations */
    private javax.swing.JLabel imgprompt;
    private javax.swing.JTextField imgurl;
    private javax.swing.JButton okaybtn;
    private javax.swing.JButton cancelbtn;
}

