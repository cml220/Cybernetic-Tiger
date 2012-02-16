import dbprocess.DatabaseProcess;
import obj.*;

/**
 * @author jih748, jwk881, cml220
 */
public class Pay extends javax.swing.JFrame {
    private User u;
    private int b_num;
    private Cart cart;
    private Controller controller;
    private String form;

    /** Creates new Receipt frame */
    public Pay(User u,int number, Cart cart, Controller controller, String form) {
        this.cart = cart;
        this.u = u;
        this.b_num=number;
        this.controller = controller;
        this.form = form;
        initComponents();
        this.setBounds(500,300,500,200);
        jLabel1.setBounds(0,0,400,100);
        jButton2.setBounds(300,100,80,30);
        jButton1.setBounds(400,100,80,30);
    }


    /**
     * Initialize components of Pay frame
     */
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("     Payment details form (not yet complete)");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 250);

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(280, 260, 94, 25);

        jButton2.setText("Pay");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(160, 260, 60, 25);

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        new Receipt(form).setVisible(true);
        this.setVisible(false);
        DatabaseProcess db = null;
        try {
            db = DatabaseProcess.getInstance();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        try {
            for(int i = 0; i < cart.countBook(); i++) {
                db.addBookToUser(cart.getBookByIndex(i), u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        cart.clear();
        try {
            controller.showBooksOnCart();
            controller.showBooksOnCatalogue();
            controller.showBooksOnRentals();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                //new Pay().setVisible(true);
            }
        });
    }

    /* Pay frame component declarations */
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
}
