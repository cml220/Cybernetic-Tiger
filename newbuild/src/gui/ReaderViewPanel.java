package gui;


import java.awt.GridLayout;
import java.net.MalformedURLException;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.Book;
import controllers.Controller;
import exceptions.BookOpenFailed;
import exceptions.ControllerNotInitializedException;


public class ReaderViewPanel extends JPanel {
    private static final long serialVersionUID = 1284781213344837566L;
    public ReaderViewPanel(){
        super(new GridLayout(1, 1));

        /**
         * 
         */
        tabbedPane = new JTabbedPane();

        this.add(tabbedPane);
    }
    private static JTabbedPane tabbedPane;

    public static void OpenNewBook(Book book) throws MalformedURLException, ControllerNotInitializedException, BookOpenFailed {

        JPanel tab = Controller.openReader(book);
        tabbedPane.addTab(book.title, tab);
    }

}
