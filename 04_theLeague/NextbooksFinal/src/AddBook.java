import obj.Book;
import controller.DatabaseProcess;

/**
 * @author cml220
 */
public class AddBook extends javax.swing.JFrame {
    private Controller controller;

    /** Creates new AddBook frame */
    public AddBook(Controller controller) {
        this.controller = controller;
        initComponents();
        this.setBounds(500,300,280,330);

    }

    /**
     * Initialize the components of the AddBook frame
     */
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        okaybtn.setText("Okay");
        okaybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commitChanges(evt);
            }
        });
        getContentPane().add(okaybtn);
        okaybtn.setBounds(50, 244, 85, 25);

        cancelbtn.setText("Cancel");
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel(evt);
            }
        });
        getContentPane().add(cancelbtn);
        cancelbtn.setBounds(140, 244, 85, 25);

        getContentPane().add(bookTitleLabel);
        bookTitleLabel.setText("Title:");
        bookTitleLabel.setBounds(10, 20, 200, 30);
        getContentPane().add(bookTitleField);
        bookTitleField.setBounds(100, 20, 120, 30);

        getContentPane().add(bookAuthorLabel);
        bookAuthorLabel.setText("Author:");
        bookAuthorLabel.setBounds(10, 52, 200, 30);
        getContentPane().add(bookAuthorField);
        bookAuthorField.setBounds(100, 52, 120, 30);

        getContentPane().add(bookPriceLabel);
        bookPriceLabel.setText("Price:");
        bookPriceLabel.setBounds(10, 84, 200, 30);
        getContentPane().add(bookPriceField);
        bookPriceField.setBounds(100, 84, 120, 30);

        getContentPane().add(bookURLLabel);
        bookURLLabel.setText("URL:");
        bookURLLabel.setBounds(10, 116, 200, 30);
        getContentPane().add(bookURLField);
        bookURLField.setBounds(100, 116, 120, 30);

        getContentPane().add(bookISBNLabel);
        bookISBNLabel.setText("ISBN:");
        bookISBNLabel.setBounds(10, 148, 200, 30);
        getContentPane().add(bookISBNField);
        bookISBNField.setBounds(100, 148, 120, 30);

        getContentPane().add(bookPicURLLabel);
        bookPicURLLabel.setText("picURL:");
        bookPicURLLabel.setBounds(10, 180, 200, 30);
        getContentPane().add(bookPicURLField);
        bookPicURLField.setBounds(100, 180, 120, 30);

        getContentPane().add(bookDescriptionLabel);
        bookDescriptionLabel.setText("Description:");
        bookDescriptionLabel.setBounds(10, 212, 200, 30);
        getContentPane().add(bookDescriptionField);
        bookDescriptionField.setBounds(100, 212, 120, 30);

        pack();
    }

    /**
     * On click of "Okay" commit the addition of the book using DatabaseProcess
     */
    private void commitChanges(java.awt.event.ActionEvent evt) {
        Book b = new Book(bookTitleField.getText(), bookAuthorField.getText(), Float.parseFloat(bookPriceField.getText()), bookURLField.getText(), bookISBNField.getText(), bookPicURLField.getText(), bookDescriptionField.getText());

        try {
            DatabaseProcess db = DatabaseProcess.getInstance();
            db.addBookToCatalogue(b);
            controller.refreshCatalogue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dispose();
    }

    /**
     * On click of "Cancel" dispose this frame
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

    /* AddBook frame component declarations */
    private javax.swing.JLabel bookTitleLabel = new javax.swing.JLabel();
    private javax.swing.JLabel bookAuthorLabel = new javax.swing.JLabel();
    private javax.swing.JLabel bookPriceLabel = new javax.swing.JLabel();
    private javax.swing.JLabel bookURLLabel = new javax.swing.JLabel();
    private javax.swing.JLabel bookISBNLabel = new javax.swing.JLabel();
    private javax.swing.JLabel bookPicURLLabel = new javax.swing.JLabel();
    private javax.swing.JLabel bookDescriptionLabel = new javax.swing.JLabel();

    private javax.swing.JTextField bookTitleField = new javax.swing.JTextField();
    private javax.swing.JTextField bookAuthorField = new javax.swing.JTextField();
    private javax.swing.JTextField bookPriceField = new javax.swing.JTextField();
    private javax.swing.JTextField bookURLField = new javax.swing.JTextField();
    private javax.swing.JTextField bookISBNField = new javax.swing.JTextField();
    private javax.swing.JTextField bookPicURLField = new javax.swing.JTextField();
    private javax.swing.JTextField bookDescriptionField = new javax.swing.JTextField();

    private javax.swing.JButton okaybtn = new javax.swing.JButton();
    private javax.swing.JButton cancelbtn = new javax.swing.JButton();
}


