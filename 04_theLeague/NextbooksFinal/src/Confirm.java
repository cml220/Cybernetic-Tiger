import java.text.DecimalFormat;

import obj.*;
/**
 *
 * @author jih748, jwk881, cml220
 */
public class Confirm extends javax.swing.JFrame {
    private int book_number;
    private User u;
    private Cart cart;
    private Controller controller;
    private String form;

    /** Creates new Confirm frame */
    public Confirm(int book_number, User u, Cart c, Controller controller) {
        this.book_number=book_number;
        this.u=u;
        cart = c;
        this.controller = controller;
        initComponents();
        this.setBounds(500,300,300,270);

    }

    /**
     * Initialize components of Confirm frame
     */
    private void initComponents() {
        DecimalFormat dec = new DecimalFormat();
        dec.setMinimumFractionDigits(2);
        dec.setMaximumFractionDigits(2);

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setText("Purchase");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(95, 190, 85, 25);

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(180, 190, 85, 25);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(5, -75, 400, 300);
        booksBought();
        jLabel1.setText("<html>" + form + "<br>Total: $" + dec.format(cart.getTotalPrice()) + "</html>");

        pack();
    }

    /**
     * Set the form data that consists of titles and prices of all books in the transaction
     */
    private void booksBought() {
        DecimalFormat dec = new DecimalFormat();
        dec.setMinimumFractionDigits(2);
        dec.setMaximumFractionDigits(2);

        form = "";
        for(int i=0; i < cart.countBook(); i++) {
            form += cart.getBookByIndex(i).getBookTitle() + " -- $" + dec.format(cart.getBookByIndex(i).getBookPrice()) + "<br>";
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        new Pay(u, book_number, cart, controller, form).setVisible(true);
        this.setVisible(false);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
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

    /* Confirm frame component declarations */
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
}
