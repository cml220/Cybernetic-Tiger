package controllers;
import model.Book;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.util.PropertiesManager;

public class ReaderController {

	public ReaderController()
	{
		
	}
	

	//the SwingController is an icepdf class needed
	SwingController controller = new SwingController();
	
	//the properties manager is needed to remove the open,print, and save functions
    private PropertiesManager properties = new PropertiesManager(System.getProperties(), ResourceBundle.getBundle(PropertiesManager.DEFAULT_MESSAGE_BUNDLE));
 
    public boolean getProperties(){
    	if(properties.getBoolean(PropertiesManager.PROPERTY_SHOW_UTILITY_OPEN) == false && properties.getBoolean(PropertiesManager.PROPERTY_SHOW_UTILITY_PRINT) == false && properties.getBoolean(PropertiesManager.PROPERTY_SHOW_UTILITY_SAVE) == false){
    		return true;
    	}
    	return false;
    }
	
	public JPanel openBook(Book book) throws MalformedURLException
	{

		//this creates the URL
		URL url = new URL(book.pdfURL);

		properties.setBoolean(PropertiesManager.PROPERTY_SHOW_UTILITY_OPEN, false);
		properties.setBoolean(PropertiesManager.PROPERTY_SHOW_UTILITY_PRINT, false);
		properties.setBoolean(PropertiesManager.PROPERTY_SHOW_UTILITY_SAVE, false);
		
        SwingViewBuilder factory = new SwingViewBuilder(controller, properties);

        JPanel viewerComponentPanel = factory.buildViewerPanel();

        // add copy keyboard command
        ComponentKeyBinding.install(controller, viewerComponentPanel);

        // add interactive mouse link annotation support via callback
        controller.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                        controller.getDocumentViewController()));

        JFrame applicationFrame = new JFrame();
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationFrame.getContentPane().add(viewerComponentPanel);

        // Now that the GUI is all in place, we can open the PDF
        controller.openDocument(url);

        // show the component
        applicationFrame.pack();
        applicationFrame.setVisible(true);
        return viewerComponentPanel;
	}
}