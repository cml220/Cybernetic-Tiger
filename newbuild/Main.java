import gui.MainFrame;
import gui.PanelsManager;

public class Main {

	public static void main(String[] args){
		
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
		
	}
	
}
