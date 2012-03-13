import gui.LoginFrame;

public class Main {

    public static void main(String[] args){

        /*
         * Show login window.
         */
    	/* added try/catch block to catch all propagated errors */
    	try {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());    		
    	}

    }

}
