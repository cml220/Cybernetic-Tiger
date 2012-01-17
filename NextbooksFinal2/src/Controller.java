
import java.net.URL;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.sun.pdfview.PDFViewer;

import controller.*;
import obj.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Profile.java
 *
 * Created on Sep 28, 2011, 9:29:38 PM
 */
/**
 *
 * @author jih748
 */
public class Controller extends javax.swing.JFrame {
	
	/**
	 * The index of the first book in the catalogue.
	 */
	private int catalogueBookId;
	/**
	 * The index of the first book in the cart.
	 */
	private int cartId;
	/**
	 * The index of the first book in your rentals.
	 */
	private int rentalId;
	/**
	 * The catalogue from the database.
	 */
	private LinkedList<Book> catalogue;
	/**
	 * The users rentals.
	 */
	private LinkedList<Book> rentals;
	
	/**
	 * Points to itself for purposes of passing itself easily to
	 * action listeners.
	 */
	private Controller myself;
	/**
	 * The cart.
	 */
	private Cart cart;
    //private int[] purchase_label_array; //need modify
    
    /**
     * The users username.
     */
    public User theUser;
    
    /** Creates new form Profile */
    public Controller(User theUser) {
    	myself = this;
    	this.theUser = theUser;
    	rentals = new LinkedList<Book>();
    	catalogueBookId=0;
    	cartId=0;
        initComponents();
        cart=new Cart();
        this.setBounds(400,200,970,720);
        try {
        	showBooksOnRentals();
        	showBooksOnCatalogue();
			showBooksOnCart();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }
    
    public void refreshCatalogue() {
    	try {
    		catalogue.clear();
    		DatabaseProcess db = DatabaseProcess.getInstance();
    		catalogue = db.getCatalogue();
    		showBooksOnCatalogue();
    	}
    	catch (Exception e) { e.printStackTrace(); }
    }
    
    public void refreshRentals() {
    	try {
    		rentals.clear();
    		DatabaseProcess db = DatabaseProcess.getInstance();
    		rentals = db.getBooksByUser(theUser);
    		showBooksOnRentals();
    	}
    	catch (Exception e) { e.printStackTrace(); }
    }
    
    private String isAdmin(String user) {
    	try {
    		DatabaseProcess db = DatabaseProcess.getInstance();
    		return db.getAdminStatus(user);
    	}
    	catch (Exception e)	{ e.printStackTrace(); }
    	return "false";
    }
    
    private String getUserIMG(String user) {
    	String img = null;
    	try {
    		DatabaseProcess db = DatabaseProcess.getInstance();
    		img = db.getUserIMG(user);
    	}
    	catch (Exception e) { e.printStackTrace(); }
    	
    	return img;
    }
    
    /**
     * Initializes the Jlabel components.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        rentalsPanel = new javax.swing.JPanel();
        rentalsPic1 = new javax.swing.JLabel();
        rentalsPic2 = new javax.swing.JLabel();
        rentalsPic3 = new javax.swing.JLabel();
        rentalsPic4 = new javax.swing.JLabel();
        CataloguePanel = new javax.swing.JPanel();
        book1button = new javax.swing.JButton();
        book2button = new javax.swing.JButton();
        book3button = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        CartPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        book4button=new javax.swing.JButton();
        cataloguePic1 =new javax.swing.JLabel();
        cataloguePic2 = new javax.swing.JLabel();
        cataloguePic3 = new javax.swing.JLabel();
        cataloguePic4 = new javax.swing.JLabel();
        editProfile = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        
        book1title=new javax.swing.JLabel();
        book2title=new javax.swing.JLabel();
        book3title=new javax.swing.JLabel();
        book4title=new javax.swing.JLabel();
        
        book1author=new javax.swing.JLabel();
        book2author=new javax.swing.JLabel();
        book3author=new javax.swing.JLabel();
        book4author=new javax.swing.JLabel();
        
        book1price=new javax.swing.JLabel();
        book2price=new javax.swing.JLabel();
        book3price=new javax.swing.JLabel();
        book4price=new javax.swing.JLabel();
        
        catalogueNextPage=new javax.swing.JButton();
        cataloguePreviousPage=new javax.swing.JButton();
        rentNextPage=new javax.swing.JButton();
        rentPreviousPage=new javax.swing.JButton();
        cartNextPage=new javax.swing.JButton();
        cartPreviousPage=new javax.swing.JButton();
        
        cartBook1 =new javax.swing.JLabel();
        cartBook2 = new javax.swing.JLabel();
        cartBook3 = new javax.swing.JLabel();
        cartBook4 = new javax.swing.JLabel();
        
        cartBook1title=new javax.swing.JLabel();
        cartBook2title=new javax.swing.JLabel();
        cartBook3title=new javax.swing.JLabel();
        cartBook4title=new javax.swing.JLabel();
        
        cartBook1author=new javax.swing.JLabel();
        cartBook2author=new javax.swing.JLabel();
        cartBook3author=new javax.swing.JLabel();
        cartBook4author=new javax.swing.JLabel();
        
        rentalsBook1title=new javax.swing.JLabel();
        rentalsBook2title=new javax.swing.JLabel();
        rentalsBook3title=new javax.swing.JLabel();
        rentalsBook4title=new javax.swing.JLabel();
        
        rentalsBook1author=new javax.swing.JLabel();
        rentalsBook2author=new javax.swing.JLabel();
        rentalsBook3author=new javax.swing.JLabel();
        rentalsBook4author=new javax.swing.JLabel();
        
        cartBook1price=new javax.swing.JLabel();
        cartBook2price=new javax.swing.JLabel();
        cartBook3price=new javax.swing.JLabel();
        cartBook4price=new javax.swing.JLabel();
        
        cartBook1button = new javax.swing.JButton();
        cartBook2button = new javax.swing.JButton();
        cartBook3button = new javax.swing.JButton();
        cartBook4button = new javax.swing.JButton();  
        
        searchBox = new JComboBox();
        
        checkoutButton = new JButton();
        
        addBook = new JButton();
        removeBook = new JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTabbedPane1.setName("Current Rentals"); // NOI18N

        rentalsPanel.setBackground(new java.awt.Color(255, 255, 255));
        rentalsPanel.setOpaque(false);
        rentalsPanel.setLayout(null);
    	
        
        rentalsPanel.add(rentalsPic1);
        rentalsPic1.setBounds(40, 30, 120, 160);
        rentalsPic1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                OpenBook(1);
            }
        });

        rentalsPanel.add(rentalsPic2);
        rentalsPic2.setBounds(320, 30, 120, 160);
        rentalsPic2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                OpenBook(2);
            }
        });

        rentalsPanel.add(rentalsPic3);
        rentalsPic3.setBounds(40, 230, 120, 160);
        rentalsPic3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                OpenBook(3);
            }
        });
        
        rentalsPanel.add(rentalsPic4);
        rentalsPic4.setBounds(320, 230, 120, 160);
        rentalsPic4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                OpenBook(4);
            }
        });
        
      //book info listeners
    	cataloguePic1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                OpenBookInfo(0);
            }
        });
    	cataloguePic2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                OpenBookInfo(1);
            }
        });
    	cataloguePic3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                OpenBookInfo(2);
            }
        });
    	cataloguePic4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                OpenBookInfo(3);
            }
        });

        jTabbedPane1.addTab("Current Rentals", rentalsPanel);

        CataloguePanel.setOpaque(false);
        CataloguePanel.setLayout(null);
        
        CartPanel.setLayout(null);
//------------------------------------------------
//books
        //catalogue tab
        	CataloguePanel.add(cataloguePic1);
        	cataloguePic1.setBounds(40,30,120,160);
        	cataloguePic1.setVisible(false);

        	CataloguePanel.add(cataloguePic2);
        	cataloguePic2.setBounds(320,30,120,160);
        	cataloguePic2.setVisible(false);
        	
        	CataloguePanel.add(cataloguePic3);
        	cataloguePic3.setBounds(40,230,120,160);
        	cataloguePic3.setVisible(false);
         
        	CataloguePanel.add(cataloguePic4);
        	cataloguePic4.setBounds(320,230,120,160);
        	cataloguePic4.setVisible(false);
        
        //cart tab
        	CartPanel.add(cartBook1);
        	cartBook1.setBounds(40,30,120,160);
        	cartBook1.setVisible(false);
        	
        	CartPanel.add(cartBook2);
        	cartBook2.setBounds(320,30,120,160);
        	cartBook2.setVisible(false);
        	
        	CartPanel.add(cartBook3);
        	cartBook3.setBounds(40,230,120,160);
        	cartBook3.setVisible(false);
        	
        	CartPanel.add(cartBook4);
        	cartBook4.setBounds(320,230,120,160);
        	cartBook4.setVisible(false);
        
        
//books end
//----------------------------------
//book titles
        //catalogue tab
        	CataloguePanel.add(book1title);
        	book1title.setBounds(170,30,80,20);
        	book1title.setVisible(false);
        	book1title.setFont(new java.awt.Font("Verdana", 0, 10));
            book1title.setForeground(new java.awt.Color(204, 255, 255));
        	
        	CataloguePanel.add(book2title);
        	book2title.setBounds(450,30,80,20);
        	book2title.setVisible(false);
        	book2title.setFont(new java.awt.Font("Verdana", 0, 10));
            book2title.setForeground(new java.awt.Color(204, 255, 255));
        	
        	CataloguePanel.add(book3title);
        	book3title.setBounds(170,230,80,20);
        	book3title.setVisible(false);
        	book3title.setFont(new java.awt.Font("Verdana", 0, 10));
            book3title.setForeground(new java.awt.Color(204, 255, 255));
        	
        	CataloguePanel.add(book4title);
        	book4title.setBounds(450,230,80,20);
        	book4title.setVisible(false);
        	book4title.setFont(new java.awt.Font("Verdana", 0, 10));
            book4title.setForeground(new java.awt.Color(204, 255, 255));
        //cart tab
        	CartPanel.add(cartBook1title);
        	cartBook1title.setBounds(170,30,80,20);
        	cartBook1title.setVisible(false);
        	cartBook1title.setFont(new java.awt.Font("Verdana", 0, 10));
        	cartBook1title.setForeground(new java.awt.Color(204, 255, 255));
        	
        	CartPanel.add(cartBook2title);
        	cartBook2title.setBounds(450,30,80,20);
        	cartBook2title.setVisible(false);
        	cartBook2title.setFont(new java.awt.Font("Verdana", 0, 10));
        	cartBook2title.setForeground(new java.awt.Color(204, 255, 255));
        	
        	CartPanel.add(cartBook3title);
        	cartBook3title.setBounds(170,230,80,20);
        	cartBook3title.setVisible(false);
        	cartBook3title.setFont(new java.awt.Font("Verdana", 0, 10));
        	cartBook3title.setForeground(new java.awt.Color(204, 255, 255));
        	
        	CartPanel.add(cartBook4title);
        	cartBook4title.setBounds(450,230,80,20);
        	cartBook4title.setVisible(false);
        	cartBook4title.setFont(new java.awt.Font("Verdana", 0, 10));
        	cartBook4title.setForeground(new java.awt.Color(204, 255, 255));
        //rentals tab
        	rentalsPanel.add(rentalsBook1title);
        	rentalsBook1title.setBounds(170,30,80,20);
        	rentalsBook1title.setVisible(false);
        	rentalsBook1title.setFont(new java.awt.Font("Verdana", 0, 10));
        	rentalsBook1title.setForeground(new java.awt.Color(204, 255, 255));
        	
        	rentalsPanel.add(rentalsBook2title);
        	rentalsBook2title.setBounds(450,30,80,20);
        	rentalsBook2title.setVisible(false);
        	rentalsBook2title.setFont(new java.awt.Font("Verdana", 0, 10));
        	rentalsBook2title.setForeground(new java.awt.Color(204, 255, 255));
        	
        	rentalsPanel.add(rentalsBook3title);
        	rentalsBook3title.setBounds(170,230,80,20);
        	rentalsBook3title.setVisible(false);
        	rentalsBook3title.setFont(new java.awt.Font("Verdana", 0, 10));
        	rentalsBook3title.setForeground(new java.awt.Color(204, 255, 255));
        	
        	rentalsPanel.add(rentalsBook4title);
        	rentalsBook4title.setBounds(450,230,80,20);
        	rentalsBook4title.setVisible(false);
        	rentalsBook4title.setFont(new java.awt.Font("Verdana", 0, 10));
        	rentalsBook4title.setForeground(new java.awt.Color(204, 255, 255));
//book authors 
        //catalogue tab
        	CataloguePanel.add(book1author);
        	book1author.setBounds(170,60,80,20);
        	book1author.setVisible(false);
        	book1author.setFont(new java.awt.Font("Verdana", 0, 10));
        	book1author.setForeground(new java.awt.Color(204, 255, 255));
        	
        	CataloguePanel.add(book2author);
        	book2author.setBounds(450,60,80,20);
        	book2author.setVisible(false);
        	book2author.setFont(new java.awt.Font("Verdana", 0, 10));
        	book2author.setForeground(new java.awt.Color(204, 255, 255));
        	
        	CataloguePanel.add(book3author);
        	book3author.setBounds(170,260,80,20);
        	book3author.setVisible(false);
        	book3author.setFont(new java.awt.Font("Verdana", 0, 10));
        	book3author.setForeground(new java.awt.Color(204, 255, 255));
        	
        	CataloguePanel.add(book4author);
        	book4author.setBounds(450,260,80,20);
        	book4author.setVisible(false);
        	book4author.setFont(new java.awt.Font("Verdana", 0, 10));
        	book4author.setForeground(new java.awt.Color(204, 255, 255));
        //cart tab
        	CartPanel.add(cartBook1author);
        	cartBook1author.setBounds(170,60,80,20);
        	cartBook1author.setVisible(false);
        	cartBook1author.setFont(new java.awt.Font("Verdana", 0, 10));
        	cartBook1author.setForeground(new java.awt.Color(204, 255, 255));
        	
        	CartPanel.add(cartBook2author);
        	cartBook2author.setBounds(450,60,80,20);
        	cartBook2author.setVisible(false);
        	cartBook2author.setFont(new java.awt.Font("Verdana", 0, 10));
        	cartBook2author.setForeground(new java.awt.Color(204, 255, 255));
        	
        	CartPanel.add(cartBook3author);
        	cartBook3author.setBounds(170,260,80,20);
        	cartBook3author.setVisible(false);
        	cartBook3author.setFont(new java.awt.Font("Verdana", 0, 10));
        	cartBook3author.setForeground(new java.awt.Color(204, 255, 255));
        	
        	CartPanel.add(cartBook4author);
        	cartBook4author.setBounds(450,260,80,20);
        	cartBook4author.setVisible(false);
        	cartBook4author.setFont(new java.awt.Font("Verdana", 0, 10));
        	cartBook4author.setForeground(new java.awt.Color(204, 255, 255));
        //rental tab
        	rentalsPanel.add(rentalsBook1author);
        	rentalsBook1author.setBounds(170,60,80,20);
        	rentalsBook1author.setVisible(false);
        	rentalsBook1author.setFont(new java.awt.Font("Verdana", 0, 10));
        	rentalsBook1author.setForeground(new java.awt.Color(204, 255, 255));
        	
        	rentalsPanel.add(rentalsBook2author);
        	rentalsBook2author.setBounds(450,60,80,20);
        	rentalsBook2author.setVisible(false);
        	rentalsBook2author.setFont(new java.awt.Font("Verdana", 0, 10));
        	rentalsBook2author.setForeground(new java.awt.Color(204, 255, 255));
        	
        	rentalsPanel.add(rentalsBook3author);
        	rentalsBook3author.setBounds(170,260,80,20);
        	rentalsBook3author.setVisible(false);
        	rentalsBook3author.setFont(new java.awt.Font("Verdana", 0, 10));
        	rentalsBook3author.setForeground(new java.awt.Color(204, 255, 255));
        	
        	rentalsPanel.add(rentalsBook4author);
        	rentalsBook4author.setBounds(450,260,80,20);
        	rentalsBook4author.setVisible(false);
        	rentalsBook4author.setFont(new java.awt.Font("Verdana", 0, 10));
        	rentalsBook4author.setForeground(new java.awt.Color(204, 255, 255));
        	
//book prices
        //catalogue tab
        	CataloguePanel.add(book1price);
        	book1price.setBounds(170,90,80,20);
        	book1price.setVisible(false);
        	book1price.setFont(new java.awt.Font("Verdana", 0, 10));
        	book1price.setForeground(new java.awt.Color(204, 255, 255));
        	
        	CataloguePanel.add(book2price);
        	book2price.setBounds(450,90,80,20);
        	book2price.setVisible(false);
        	book2price.setFont(new java.awt.Font("Verdana", 0, 10));
        	book2price.setForeground(new java.awt.Color(204, 255, 255));
        	
        	CataloguePanel.add(book3price);
        	book3price.setBounds(170,290,80,20);
        	book3price.setVisible(false);
        	book3price.setFont(new java.awt.Font("Verdana", 0, 10));
        	book3price.setForeground(new java.awt.Color(204, 255, 255));
        	
        	CataloguePanel.add(book4price);
        	book4price.setBounds(450,290,80,20);
        	book4price.setVisible(false);
        	book4price.setFont(new java.awt.Font("Verdana", 0, 10));
        	book4price.setForeground(new java.awt.Color(204, 255, 255));
        //cart tab
        	CartPanel.add(cartBook1price);
        	cartBook1price.setBounds(170,90,80,20);
        	cartBook1price.setVisible(false);
        	cartBook1price.setFont(new java.awt.Font("Verdana", 0, 10));
        	cartBook1price.setForeground(new java.awt.Color(204, 255, 255));
        	
        	CartPanel.add(cartBook2price);
        	cartBook2price.setBounds(450,90,80,20);
        	cartBook2price.setVisible(false);
        	cartBook2price.setFont(new java.awt.Font("Verdana", 0, 10));
        	cartBook2price.setForeground(new java.awt.Color(204, 255, 255));
        	
        	CartPanel.add(cartBook3price);
        	cartBook3price.setBounds(170,290,80,20);
        	cartBook3price.setVisible(false);
        	cartBook3price.setFont(new java.awt.Font("Verdana", 0, 10));
        	cartBook3price.setForeground(new java.awt.Color(204, 255, 255));
        	
        	CartPanel.add(cartBook4price);
        	cartBook4price.setBounds(450,290,80,20);
        	cartBook4price.setVisible(false);
        	cartBook4price.setFont(new java.awt.Font("Verdana", 0, 10));
        	cartBook4price.setForeground(new java.awt.Color(204, 255, 255));

//----------------------------------    
//buttons: book buttons
       //catalogue tab
        book1button.setText("Add to Cart");
        book1button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					addBook1ToCart(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        CataloguePanel.add(book1button);
        book1button.setBounds(35, 200, 120, 29);
        book1button.setVisible(false);

        book2button.setText("Add to Cart");
        book2button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					addBook2ToCart(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        CataloguePanel.add(book2button);
        book2button.setBounds(330, 200, 120, 29);
        book2button.setVisible(false);

        book3button.setText("Add to Cart");
        book3button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					addBook3ToCart(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        CataloguePanel.add(book3button);
        book3button.setBounds(35, 400, 120, 29);
        book3button.setVisible(false);
        
        book4button.setText("Add to Cart");
        book4button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					addBook4ToCart(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        CataloguePanel.add(book4button);
        book4button.setBounds(330, 400, 120, 29);
        book4button.setVisible(false);

       
        
        
     //cart tab
        cartBook1button.setText("Remove");
        cartBook1button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                	removeCart1(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        CartPanel.add(cartBook1button);
        cartBook1button.setBounds(35, 200, 120, 29);
        cartBook1button.setVisible(false);

        cartBook2button.setText("Remove");
        cartBook2button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                	removeCart2(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        CartPanel.add(cartBook2button);
        cartBook2button.setBounds(330, 200, 120, 29);
        cartBook2button.setVisible(false);

        cartBook3button.setText("Remove");
        cartBook3button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                	removeCart3(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        CartPanel.add(cartBook3button);
        cartBook3button.setBounds(35, 400, 120, 29);
        cartBook3button.setVisible(false);
        
        cartBook4button.setText("Remove");
        cartBook4button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                	removeCart4(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        CartPanel.add(cartBook4button);
        cartBook4button.setBounds(330, 400, 120, 29);
        cartBook4button.setVisible(false);
        
        
//buttons: next/previous page button
        CataloguePanel.add(catalogueNextPage);
        catalogueNextPage.setText("NEXT");
        catalogueNextPage.setBounds(550,450,80,30);
        catalogueNextPage.setVisible(false);
        catalogueNextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catalogueNextButtonActionPerformed(evt);
            }
        });
        CataloguePanel.add(cataloguePreviousPage);
        cataloguePreviousPage.setText("PREV");
        cataloguePreviousPage.setBounds(465,450,80,30);
        cataloguePreviousPage.setVisible(false);
        cataloguePreviousPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cataloguePreviousButtonActionPerformed(evt);
            }
        });
        
        CartPanel.add(cartNextPage);
        cartNextPage.setText("NEXT");
        cartNextPage.setBounds(550,450,80,30);
        cartNextPage.setVisible(false);
        cartNextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartNextButtonActionPerformed(evt);
            }
        });
        CartPanel.add(cartPreviousPage);
        cartPreviousPage.setText("PREV");
        cartPreviousPage.setBounds(465,450,80,30);
        cartPreviousPage.setVisible(false);
        cartPreviousPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartPreviousButtonActionPerformed(evt);
            }
        });
        
        rentalsPanel.add(rentNextPage);
        rentNextPage.setText("NEXT");
        rentNextPage.setBounds(550,450,80,30);
        rentNextPage.setVisible(false);
        rentNextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentNextPage(evt);
            }
        });
        rentalsPanel.add(rentPreviousPage);
        rentPreviousPage.setText("PREV");
        rentPreviousPage.setBounds(465,450,80,30);
        rentPreviousPage.setVisible(false);
        rentPreviousPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentPrevPage(evt);
            }
        });
        
        
//buttons end
//----------------------------------
        
        
//Search thingy
        searchBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Title", "Author", "ISBN"}));
        searchBox.setBounds(440, 0, 100, 28);
        jTextField1.setBounds(540, 0, 110, 28);
        jTextField1.setText("Search");
        jTextField1.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
        		if (arg0.getKeyCode() == KeyEvent.VK_ENTER)
        		{
        			searchCatalogue(searchBox.getSelectedIndex(), jTextField1.getText());
        		}
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
			}
        });
        CataloguePanel.add(jTextField1);
        CataloguePanel.add(searchBox);
        
//Search thingy end
        
        
        CartPanel.add(checkoutButton);
        checkoutButton.setBounds(335,450,120,30);
        checkoutButton.setText("Checkout");
        checkoutButton.addActionListener(new ActionListener()
        {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Confirm(cart.countBook(), theUser, cart, myself).setVisible(true);				
			}        	
        });
        
        /*
        //book pic label
        bookpic1.setIcon(new javax.swing.ImageIcon("src/assets/BOOK1.png")); // NOI18N
        jPanel2.add(bookpic1);
        bookpic1.setBounds(40, 30, 116, 160);
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        bookpic2.setIcon(new javax.swing.ImageIcon("src/assets/BOOK2.png")); // NOI18N
        jPanel2.add(bookpic2);
        bookpic2.setBounds(240, 30, 105, 158);

        bookpic3.setIcon(new javax.swing.ImageIcon("src/assets/BOOK3.png")); // NOI18N
        jPanel2.add(bookpic3);
        bookpic3.setBounds(440, 30, 120, 156);

      */
        
 
//-----------------------------------------------------------------
        //------------------------------------------------------------------

        jTabbedPane1.addTab("Catalogue", CataloguePanel);

        CartPanel.setOpaque(false);
        jTabbedPane1.addTab("Cart", CartPanel);

        /*jPanel4.setOpaque(false);
        jPanel4.setLayout(null);
        jPanel4.add(jLabel15);
        jLabel15.setBounds(50, 40, 110, 130);
        jPanel4.add(jLabel16);
        jLabel16.setBounds(230, 40, 120, 130);
        jPanel4.add(jLabel17);
        jLabel17.setBounds(420, 40, 120, 130);*/

   

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(60, 130, 660, 570);
        jTabbedPane1.getAccessibleContext().setAccessibleName("tab");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("tab");
        
        
//-----------
//user info
        setUserIMG();
        getContentPane().add(jLabel2);
        jLabel2.setBounds(820, 10, 140, 170);

        jLabel3.setText(theUser.getUserName());
        getContentPane().add(jLabel3);
        jLabel3.setBounds(850, 160, 100, 25);
        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18));
        
        logout.setText("Logout");
        getContentPane().add(logout);
        logout.setBounds(830,190,120,30);
        logout.addActionListener(new ActionListener()
        {
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		new NextBook().setVisible(true);
        		myself.dispose();
        	}
        });
        
        editProfile.setText("Edit Info");
        getContentPane().add(editProfile);
        editProfile.setBounds(830, 222, 120, 30);
        editProfile.addActionListener(new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Profile(theUser, myself).setVisible(true);
				setUserIMG();
			}        	
        });
        
        if(isAdmin(theUser.getUserName()).contentEquals("true")) {
        	addBook.setText("Add Book");
        	getContentPane().add(addBook);
        	addBook.setBounds(830, 254, 120, 30);
        	addBook.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    new AddBook(myself).setVisible(true);
                }
            });
        	
        	removeBook.setText("Remove Book");
        	getContentPane().add(removeBook);
        	removeBook.setBounds(830, 286, 120, 30);
        	removeBook.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                	try {
                		new RemoveBook(myself).setVisible(true);
                	}
                	catch (Exception e) { e.printStackTrace(); }
                }
            });
        }
        
        /**jLabel4.setText("USER INFO:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(820, 190, 80, 16);

        jLabel5.setText("XXX");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(850, 240, 24, 16);

        jLabel6.setText("XXX");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(850, 220, 40, 16);

        jLabel7.setText("NAVIGATION AREA");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(830, 310, 160, 16);



        jLabel8.setText("SEARCH");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(900, 350, 70, 30);**/

        jLabel1.setIcon(new javax.swing.ImageIcon("src/assets/profile_pic.png"));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 970, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    

//catalogue book addtocart buttons action performed


//------------------------------
/**
 * Adds the first book on screen to the cart.
 * @param evt
 * @throws Exception
 */
private void addBook1ToCart(java.awt.event.ActionEvent evt) throws Exception {
    
	Book b = catalogue.get(catalogueBookId);
	cart.addBook(b);
	book1button.setVisible(false);
	showBooksOnCart();

}

/**
 * Adds the second book on screen to the cart.
 * @param evt
 * @throws Exception
 */
private void addBook2ToCart(java.awt.event.ActionEvent evt) throws Exception {
	Book b = catalogue.get(catalogueBookId+1);
	cart.addBook(b);
	book2button.setVisible(false);    
	showBooksOnCart();
	}

/**
 * Adds the third book on screen to the cart.
 * @param evt
 * @throws Exception
 */
private void addBook3ToCart(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_jButton3ActionPerformed
	Book b = catalogue.get(catalogueBookId+2);
	cart.addBook(b);
	book3button.setVisible(false);
	showBooksOnCart();
	}

/**
 * Adds the last book on screen to the cart.
 * @param evt
 * @throws Exception
 */
private void addBook4ToCart(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_jButton1ActionPerformed
	Book b = catalogue.get(catalogueBookId+3);
	cart.addBook(b);
	book4button.setVisible(false);   
	showBooksOnCart();
	}


/**
 * Removes the first book on screen from the cart.
 * @param evt
 * @throws Exception
 */
private void removeCart1(java.awt.event.ActionEvent evt) throws Exception{
	cart.removeBookById(cartId);
	showBooksOnCart();
	showBooksOnCatalogue();
}

/**
 * Removes the second book on screen from the cart.
 * @param evt
 * @throws Exception
 */
private void removeCart2(java.awt.event.ActionEvent evt) throws Exception{
	cart.removeBookById(cartId+1);
	showBooksOnCart();
	showBooksOnCatalogue();
}

/**
 * Removes the third book on the screen from the cart.
 * @param evt
 * @throws Exception
 */
private void removeCart3(java.awt.event.ActionEvent evt) throws Exception{
	cart.removeBookById(cartId+2);
	showBooksOnCart();
	showBooksOnCatalogue();
}

/**
 * Removes the last book on the screen from the cart.
 * @param evt
 * @throws Exception
 */
private void removeCart4(java.awt.event.ActionEvent evt) throws Exception{
	cart.removeBookById(cartId+3);
	showBooksOnCart();
	showBooksOnCatalogue();
}

//---------------------------------

/**
 * Increments the catalogue listings by four.
 * Four items are listed per catalogue page.
 * @param evt
 */
private void catalogueNextButtonActionPerformed(java.awt.event.ActionEvent evt){
	catalogueBookId=catalogueBookId+4;
	try {
		showBooksOnCatalogue();
	} catch (Exception e) {

		e.printStackTrace();
	}
}

/**
 * Decrements the listing of the catalogue by four.
 * Four items are listed per page.
 * @param evt
 */
private void cataloguePreviousButtonActionPerformed(java.awt.event.ActionEvent evt){
	catalogueBookId=catalogueBookId-4;
		try {
			showBooksOnCatalogue();
		} catch (Exception e) {

			e.printStackTrace();
		}
}

/**
 * Increments the id's listed in the cart by four.
 * Four items are listed per page so it advances
 * to the next page of the cart.
 * @param evt
 */
private void cartNextButtonActionPerformed(java.awt.event.ActionEvent evt){
	cartId=cartId+4;
	try {
		showBooksOnCart();
	} catch (Exception e) {

		e.printStackTrace();
	}
}

/**
 * Opens up the next page of the cart's listing.
 * Pages are 4 items per page, so it decrements the page by 4.
 * @param evt
 */
private void cartPreviousButtonActionPerformed(java.awt.event.ActionEvent evt){
	cartId=cartId-4;
	try {
		showBooksOnCart();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//-----------




private void rentNextPage(java.awt.event.ActionEvent evt) {
	rentalId=rentalId+4;
	try {
		showBooksOnRentals();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

private void rentPrevPage(java.awt.event.ActionEvent evt) {
	rentalId=rentalId-4;
	try {
		showBooksOnRentals();
	} catch (Exception e) {
		e.printStackTrace();
	}
    
}


private void OpenBook(int _rentalId)
{
	try{
		String url = rentals.get(_rentalId-1).getBookURL();
		if(url == null)	{ return; }
		else {
			PDFViewer viewer = new PDFViewer(true);
			viewer.doOpen(url);
		}
	}
	catch(Exception e){ e.printStackTrace(); }
}

private void OpenBookInfo(int catalogueID) {
	try {
		DatabaseProcess db = DatabaseProcess.getInstance();
		int id = catalogue.get(catalogueID).getBookID();
		String form = db.getBookInfo(id);	
		new BookInfo(form).setVisible(true);
	}
	catch (Exception e) { e.printStackTrace(); }
}

/** Helper method for showBooksOnCatalogue() **/
private boolean rentalsHasBook(Book b) {
	if (rentals == null) { return false; }
	for(int i=0; i < rentals.size(); i++) {
		if (rentals.get(i).getBookID() == b.getBookID()) {
			return true;
		}
	}
	return false;
}
public void showBooksOnCatalogue() throws Exception{	
	DecimalFormat dec = new DecimalFormat();
	dec.setMinimumFractionDigits(2);
	dec.setMaximumFractionDigits(2);
	
	DatabaseProcess db = DatabaseProcess.getInstance();
	if(catalogue == null)
	{
		catalogue = db.getCatalogue();
	}
	rentals = db.getBooksByUser(theUser);	//refresh rentals
	
	Book book1, book2, book3, book4, next;
	book1 = book2 = book3 = book4 = next = null;
	//get first 4 book from database
	//next will equal the next book if it exists,
	//for purpose of next tab
	try
	{
		book1 = catalogue.get(catalogueBookId);
		book2 = catalogue.get(catalogueBookId+1);
		book3 = catalogue.get(catalogueBookId+2);
		book4 = catalogue.get(catalogueBookId+3);
		next = catalogue.get(catalogueBookId +4);
	}
	catch (IndexOutOfBoundsException e)
	{

	}

	
	if (book1!=null){
		URL url = new URL(book1.getBookPicURL());
		cataloguePic1.setIcon(new javax.swing.ImageIcon(ImageIO.read(url)));
		book1title.setText(book1.getBookTitle());
		book1author.setText(book1.getBookAuthor());
		book1price.setText("$ "+dec.format(book1.getBookPrice()));
		cataloguePic1.setVisible(true);
		book1title.setVisible(true);
		book1author.setVisible(true);
		if(rentalsHasBook(book1) || cart.containBook((book1.getBookID()))){
			book1button.setVisible(false);
		}
		else{
			book1button.setVisible(true);
		}
		book1price.setVisible(true);
	}
	else{
		this.cataloguePic1.setVisible(false);
		book1title.setVisible(false);
		book1author.setVisible(false);
		book1button.setVisible(false);
		book1price.setVisible(false);
	}
	
	if (book2!=null){
		URL url = new URL(book2.getBookPicURL());
		cataloguePic2.setIcon(new javax.swing.ImageIcon(ImageIO.read(url)));
		book2title.setText(book2.getBookTitle());
		book2author.setText(book2.getBookAuthor());
		book2price.setText("$ "+dec.format(book2.getBookPrice()));
		this.cataloguePic2.setVisible(true);
		book2title.setVisible(true);
		book2author.setVisible(true);
		if(rentalsHasBook(book2) || cart.containBook((book2.getBookID()))){
			book2button.setVisible(false);
		}
		else{
			book2button.setVisible(true);
		}
		book2price.setVisible(true);
	}
	else{
		this.cataloguePic2.setVisible(false);
		book2title.setVisible(false);
		book2author.setVisible(false);
		book2button.setVisible(false);
		book2price.setVisible(false);
	}
	
	if (book3!=null){
		URL url = new URL(book3.getBookPicURL());
		cataloguePic3.setIcon(new javax.swing.ImageIcon(ImageIO.read(url)));
		book3title.setText(book3.getBookTitle());
		book3author.setText(book3.getBookAuthor());
		book3price.setText("$ "+dec.format(book3.getBookPrice()));
		this.cataloguePic3.setVisible(true);
		book3title.setVisible(true);
		book3author.setVisible(true);
		if(rentalsHasBook(book3) || cart.containBook((book3.getBookID()))){
			book3button.setVisible(false);
		}
		else{
			book3button.setVisible(true);
		}
		book3price.setVisible(true);
	}
	else{
		this.cataloguePic3.setVisible(false);
		book3title.setVisible(false);
		book3author.setVisible(false);
		book3button.setVisible(false);
		book3price.setVisible(false);
	}
	
	if (book4!=null){
		URL url = new URL(book4.getBookPicURL());
		cataloguePic4.setIcon(new javax.swing.ImageIcon(ImageIO.read(url)));
		book4title.setText(book4.getBookTitle());
		book4author.setText(book4.getBookAuthor());
		book4price.setText("$ "+dec.format(book4.getBookPrice()));
		this.cataloguePic4.setVisible(true);
		book4title.setVisible(true);
		book4author.setVisible(true);
		if(rentalsHasBook(book4) || cart.containBook((book4.getBookID()))){
			book4button.setVisible(false);
		}
		else{
			book4button.setVisible(true);
		}
		book4price.setVisible(true);
		
	}
	else{
		this.cataloguePic4.setVisible(false);
		book4title.setVisible(false);
		book4author.setVisible(false);
		book4button.setVisible(false);
		book4price.setVisible(false);
	}
	
	if(next!=null){
		catalogueNextPage.setVisible(true);
	}
	else{
		catalogueNextPage.setVisible(false);
	}
	
	if(catalogueBookId != 0){
		cataloguePreviousPage.setVisible(true);
	}
	else{
		cataloguePreviousPage.setVisible(false);
	}
}

public void showBooksOnRentals() throws Exception{
	Book book1, book2, book3, book4, next;
	book1 = book2 = book3 = book4 = next = null;
	try
	{
		DatabaseProcess db = DatabaseProcess.getInstance();
		rentals = db.getBooksByUser(theUser);
	}
	catch(Exception e)
	{
		
	}
	try
	{
		book1 = rentals.get(rentalId);
		book2 = rentals.get(rentalId+1);
		book3 = rentals.get(rentalId+2);
		book4 = rentals.get(rentalId+3);
		next = rentals.get(rentalId+4);
	}
	catch(IndexOutOfBoundsException e) { }
	catch(NullPointerException npe) { /**/ }
	
	if(book1 != null)
	{
		URL url = new URL(book1.getBookPicURL());
		this.rentalsPic1.setIcon(new ImageIcon(ImageIO.read(url)));
		rentalsPic1.setVisible(true);
		rentalsBook1author.setText(book1.getBookAuthor());
		rentalsBook1author.setVisible(true);
		rentalsBook1title.setText(book1.getBookTitle());
		rentalsBook1title.setVisible(true);
	}
	else
	{
		rentalsPic1.setVisible(false);
		rentalsBook1author.setVisible(false);
		rentalsBook1title.setVisible(false);
	}
	if(book2 != null)
	{
		URL url = new URL(book2.getBookPicURL());
		this.rentalsPic2.setIcon(new ImageIcon(ImageIO.read(url)));
		rentalsPic2.setVisible(true);
		rentalsBook2author.setText(book2.getBookAuthor());
		rentalsBook2author.setVisible(true);
		rentalsBook2title.setText(book2.getBookTitle());
		rentalsBook2title.setVisible(true);
		
	}
	else
	{
		rentalsPic2.setVisible(false);
		rentalsBook2author.setVisible(false);
		rentalsBook2title.setVisible(false);
	}
	if(book3 != null)
	{	
		URL url = new URL(book3.getBookPicURL());
		this.rentalsPic3.setIcon(new ImageIcon(ImageIO.read(url)));
		rentalsPic3.setVisible(true);
		rentalsBook3author.setText(book3.getBookAuthor());
		rentalsBook3author.setVisible(true);
		rentalsBook3title.setText(book3.getBookTitle());
		rentalsBook3title.setVisible(true);
	}
	else
	{
		rentalsPic3.setVisible(false);
		rentalsBook3author.setVisible(false);
		rentalsBook3title.setVisible(false);
	}
	if(book4 != null)
	{
		URL url = new URL(book4.getBookPicURL());
		this.rentalsPic4.setIcon(new ImageIcon(ImageIO.read(url)));
		rentalsPic4.setVisible(true);
		rentalsBook4author.setText(book4.getBookAuthor());
		rentalsBook4author.setVisible(true);
		rentalsBook4title.setText(book4.getBookTitle());
		rentalsBook4title.setVisible(true);
	}
	else
	{
		rentalsPic4.setVisible(false);
		rentalsBook4author.setVisible(false);
		rentalsBook4title.setVisible(false);
	}
	
	if(next != null)
	{
		rentNextPage.setVisible(true);
	}
	else
	{
		rentNextPage.setVisible(false);
	}
	
	if(rentalId != 0)
	{
		rentPreviousPage.setVisible(true);
	}
	else
	{
		rentPreviousPage.setVisible(false);
	}
}

public void showBooksOnCart() throws Exception{	
	DecimalFormat dec = new DecimalFormat();
	dec.setMinimumFractionDigits(2);
	dec.setMaximumFractionDigits(2);
	
	Book book1, book2, book3, book4, next;
	book1 = book2 = book3 = book4 = next = null;
	
	try
	{
		book1 = cart.getBookByIndex(cartId);
		book2 = cart.getBookByIndex(cartId+1);
		book3 = cart.getBookByIndex(cartId+2);
		book4 = cart.getBookByIndex(cartId+3);
		next = cart.getBookByIndex(cartId+4);
	}
	catch(IndexOutOfBoundsException e)
	{
	
	}
	
	
	if (book1!=null){
		URL url = new URL(book1.getBookPicURL());
		cartBook1.setIcon(new ImageIcon(ImageIO.read(url)));
		cartBook1title.setText(book1.getBookTitle());
		cartBook1author.setText(book1.getBookAuthor());
		cartBook1price.setText("$ "+dec.format(book1.getBookPrice()));
		this.cartBook1.setVisible(true);
		cartBook1title.setVisible(true);
		cartBook1author.setVisible(true);
		cartBook1button.setVisible(true);
		cartBook1price.setVisible(true);
	}
	else{
		this.cartBook1.setVisible(false);
		cartBook1title.setVisible(false);
		cartBook1author.setVisible(false);
		cartBook1button.setVisible(false);
		cartBook1price.setVisible(false);
	}
	
	if (book2!=null){
		URL url = new URL(book2.getBookPicURL());
		cartBook2.setIcon(new javax.swing.ImageIcon(ImageIO.read(url)));
		cartBook2title.setText(book2.getBookTitle());
		cartBook2author.setText(book2.getBookAuthor());
		cartBook2price.setText("$ "+dec.format(book2.getBookPrice()));
		this.cartBook2.setVisible(true);
		cartBook2title.setVisible(true);
		cartBook2author.setVisible(true);
		cartBook2button.setVisible(true);
		cartBook2price.setVisible(true);
	}
	else{
		this.cartBook2.setVisible(false);
		cartBook2title.setVisible(false);
		cartBook2author.setVisible(false);
		cartBook2button.setVisible(false);
		cartBook2price.setVisible(false);
	}
	
	if (book3!=null){
		URL url = new URL(book3.getBookPicURL());
		cartBook3.setIcon(new javax.swing.ImageIcon(ImageIO.read(url)));
		cartBook3title.setText(book3.getBookTitle());
		cartBook3author.setText(book3.getBookAuthor());
		cartBook3price.setText("$ "+dec.format(book3.getBookPrice()));
		this.cartBook3.setVisible(true);
		cartBook3title.setVisible(true);
		cartBook3author.setVisible(true);
		cartBook3button.setVisible(true);
		cartBook3price.setVisible(true);
	}
	else{
		this.cartBook3.setVisible(false);
		cartBook3title.setVisible(false);
		cartBook3author.setVisible(false);
		cartBook3button.setVisible(false);
		cartBook3price.setVisible(false);
	}
	
	if (book4!=null){
		URL url = new URL(book4.getBookPicURL());
		cartBook4.setIcon(new javax.swing.ImageIcon(ImageIO.read(url)));
		cartBook4title.setText(book4.getBookTitle());
		cartBook4author.setText(book4.getBookAuthor());
		cartBook4price.setText("$ "+dec.format(book4.getBookPrice()));
		this.cartBook4.setVisible(true);
		cartBook4title.setVisible(true);
		cartBook4author.setVisible(true);
		cartBook4button.setVisible(true);
		cartBook4price.setVisible(true);
	}
	else{
		this.cartBook4.setVisible(false);
		cartBook4title.setVisible(false);
		cartBook4author.setVisible(false);
		cartBook4button.setVisible(false);
		cartBook4price.setVisible(false);
	}
	
	if(next!=null){
		cartNextPage.setVisible(true);
	}
	else{
		cartNextPage.setVisible(false);
	}
	
	if(cartId!=0){
		cartPreviousPage.setVisible(true);
	}
	else{
		cartPreviousPage.setVisible(false);
	}
	
}

private void searchCatalogue(int field, String term)
{
	try
	{
		DatabaseProcess db = DatabaseProcess.getInstance();
		if(field == 0)
		{
			catalogue = db.getBookByTitle(term);
		}
		else if (field == 1)
		{
			catalogue = db.getBookByAuthor(term);
		}
		else if (field == 2)
		{
			catalogue.clear();
			catalogue.add(db.getBookByISBN(term));
		}
	}
	catch (Exception e)
	{
	}
	try
	{
		showBooksOnCatalogue();
	}
	catch(Exception e)
	{}
}

public void setUserIMG() {
	String usrimg = getUserIMG(theUser.getUserName());
	if(usrimg.contentEquals("default") || usrimg == null) {
    	jLabel2.setIcon(new javax.swing.ImageIcon("src/assets/touxiang2.png")); // NOI18N
    }
    else {
    	URL url;
		try {
			url = new URL(usrimg);
			jLabel2.setIcon(new javax.swing.ImageIcon(ImageIO.read(url)));
		} catch (Exception e) {
			e.printStackTrace();
		}		
    }
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
            java.util.logging.Logger.getLogger(Controller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Controller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Controller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Controller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
            	try
            	{
            		new Controller(new User("","")).setVisible(true);
            	}
            	catch(Exception e)
            	{
            		
            	}
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton book1button;
    private javax.swing.JButton book2button;
    private javax.swing.JButton book3button;
    private javax.swing.JButton book4button;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel rentalsPic1;
    private javax.swing.JLabel rentalsPic2;
    private javax.swing.JLabel rentalsPic3;
    private javax.swing.JLabel rentalsPic4;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel rentalsPanel;
    private javax.swing.JPanel CataloguePanel;
    private javax.swing.JPanel CartPanel;
    private javax.swing.JButton editProfile;
    private javax.swing.JButton logout;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // book page
    
    private javax.swing.JLabel cataloguePic1;
    private javax.swing.JLabel cataloguePic2;
    private javax.swing.JLabel cataloguePic3;
    private javax.swing.JLabel cataloguePic4;
    
    
    private javax.swing.JLabel book1title;
    private javax.swing.JLabel book2title;
    private javax.swing.JLabel book3title;
    private javax.swing.JLabel book4title;
    
    
    private javax.swing.JLabel book1author;
    private javax.swing.JLabel book2author;
    private javax.swing.JLabel book3author;
    private javax.swing.JLabel book4author;
    
    
    
    private javax.swing.JButton catalogueNextPage;
    private javax.swing.JButton cataloguePreviousPage;
    private javax.swing.JButton rentNextPage;
    private javax.swing.JButton rentPreviousPage;
    private javax.swing.JButton cartNextPage;
    private javax.swing.JButton cartPreviousPage;
    
    
    private javax.swing.JLabel book1price;
    private javax.swing.JLabel book2price;
    private javax.swing.JLabel book3price;
    private javax.swing.JLabel book4price;
    
    //cart books
    private javax.swing.JLabel cartBook1;
    private javax.swing.JLabel cartBook2;
    private javax.swing.JLabel cartBook3;
    private javax.swing.JLabel cartBook4;
    
    
    private javax.swing.JLabel cartBook1price;
    private javax.swing.JLabel cartBook2price;
    private javax.swing.JLabel cartBook3price;
    private javax.swing.JLabel cartBook4price;
    
    private javax.swing.JLabel cartBook1title;
    private javax.swing.JLabel cartBook2title;
    private javax.swing.JLabel cartBook3title;
    private javax.swing.JLabel cartBook4title;
    
    private javax.swing.JLabel cartBook1author;
    private javax.swing.JLabel cartBook2author;
    private javax.swing.JLabel cartBook3author;
    private javax.swing.JLabel cartBook4author;
    
    private javax.swing.JButton cartBook1button;
    private javax.swing.JButton cartBook2button;
    private javax.swing.JButton cartBook3button;
    private javax.swing.JButton cartBook4button;    
    
    private javax.swing.JLabel rentalsBook1title;
    private javax.swing.JLabel rentalsBook2title;
    private javax.swing.JLabel rentalsBook3title;
    private javax.swing.JLabel rentalsBook4title;
    
    private javax.swing.JLabel rentalsBook1author;
    private javax.swing.JLabel rentalsBook2author;
    private javax.swing.JLabel rentalsBook3author;
    private javax.swing.JLabel rentalsBook4author;
    
    private JComboBox searchBox;
    private JComboBox searchBox2;
    private JButton checkoutButton;
    
    private JButton addBook;
    private JButton removeBook;
    
    // End of variables declaration//GEN-END:variables
}
