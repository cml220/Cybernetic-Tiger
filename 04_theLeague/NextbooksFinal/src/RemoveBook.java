import controller.DatabaseProcess;

/**
 * @author cml220
 */
public class RemoveBook extends javax.swing.JFrame {
    private Controller controller;
    private int bookid = -1;

    /** Creates new form Profile */
    public RemoveBook(Controller controller) {
        this.controller = controller;
        initComponents();
        this.setBounds(500,300,300,170);

    }

    /**
     * Initialize the components of the AddBook frame
     */
    private void initComponents() {
        bookidprompt = new javax.swing.JLabel();
        bookidfield = new javax.swing.JTextField();
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

        getContentPane().add(bookidprompt);
        bookidprompt.setText("Enter the id of the book:");
        bookidprompt.setBounds(10, 20, 200, 30);

        getContentPane().add(bookidfield);
        bookidfield.setBounds(150, 20, 120, 30);

        pack();
    }

    /**
     * On click of "Okay" commit the removal of the book using DatabaseProcess
     */
    private void commitChanges(java.awt.event.ActionEvent evt) {
        bookid = Integer.parseInt(bookidfield.getText());
        try {
            DatabaseProcess db = DatabaseProcess.getInstance();
            db.removeBookFromCatalogue(bookid);
            controller.refreshCatalogue();
            controller.refreshRentals();
        } catch (Exception e) {
            e.printStackTrace();
        }
        controller.setUserIMG();
        this.dispose();
    }

    /**
     * On click "Cancel" dispose this frame
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

    /* RemoveBook frame component declarations */
    private javax.swing.JLabel bookidprompt;
    private javax.swing.JTextField bookidfield;
    private javax.swing.JButton okaybtn;
    private javax.swing.JButton cancelbtn;
}


