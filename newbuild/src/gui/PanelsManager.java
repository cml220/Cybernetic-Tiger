/*
 * Framework written by Brad Johnson
 * NextBooks
 * 2011-2012
 */

package gui;

import java.awt.Color;import java.sql.SQLException;import javax.swing.JComponent;import javax.swing.border.LineBorder;

/**
 * Singleton to store the panels used by this program as well as fonts and
 * colors.
 * @author Brad
 *
 */
public final class PanelsManager {

    /**
     * Hidden constructor.
     */
    private PanelsManager() {

        //hiding the constructor

    }

    /**
     * status variable used to ensure that the panels manager has been
     * initialised.
     */
    private static boolean initialised;

    /*
     * Colours used throughout the program
     */

    /**
     * Colour primarily used for unselected tabs.
     */
    public static final Color UNSELECTEDBLUE = new Color(82, 112, 139);

    /**
     * Colour primarily used for selected tabs.
     */
    public static final Color SELECTEDBLUE = new Color(43, 105, 162);

    /**
     * Colour primarily used for the background.
     */
    public static final Color BACKGROUNDBLUE = new Color(33, 44, 66);

    /**
     * Colour primarily used for raised-style buttons like search and
     * advanced.
     */
    public static final Color RAISEDBUTTONBLUE = new Color(121, 199, 255);

    /**
     * Borders used throughout the program.
     */
    public static final LineBorder DEFAULTBORDER =
        new LineBorder(PanelsManager.SELECTEDBLUE, 5);

    /**
     * Fonts used throughout the program.
     */
    public static final String BODYFONT = "Tahoma";

    /**
     * The default tab, selected on startup of the app.
     */
    private static Tab defaultTab;

    /*
     * indices for the "search area" panel
     */

    /**
     * My books panel.
     */
    public static final int MYBOOKS = 0;

    /**
     * Advanced search panel.
     */
    public static final int ADVSEARCH = 1;

    /**
     * Search results panel.
     */
    public static final int SEARCHRESULTS = 2;

    /**
     * My account panel.
     */
    public static final int MYACCOUNT = 3;

    /**
     * My cart panel.
     */
    public static final int MYCART = 4;    /**     * Catalogue panel.     */    public static final int CATALOGUE = 5;

    /**
     * how many panels the array will hold.
     * THIS MUST BE CHANGED MANUALLY
     */
    private static final int NUMPANELS = 6;

    /**
     * An array holding each of the panels that can go in the "search results"
     * space.
     */
    private static JComponent[] panelsArray;

    /**
     * An array holding custom 'pre search' strings that will go in the search
     * bar if it is empty and not selected
     */
    private static String[] preSearchStringsArray;

    /**
     * The default 'pre search' string for panels who don't have a custom
     * string assigned to them
     */
    private static String defaultPreSearchString = " Search Available Books";

    /**
     * Initializes the Panels Manager by constructing the array of panels
     * and filling it with all of the panels to be used by the app.
     */
    public static void initialise() {

        /*
         * Set the default tab to null.
         * We do this so that the program can check if the default is being
         * set
         * twice.
         * This is not allowed.
         */
        defaultTab = null;

        panelsArray = new JComponent[NUMPANELS];
        preSearchStringsArray = new String[NUMPANELS];

        /*
         * Define each of the display panels that will be used in the GUI
         */
        panelsArray[MYBOOKS]
                    = new DisplayScrollPane(new MyBooksPanel());
        preSearchStringsArray[MYBOOKS] = " Search My Books";

        panelsArray[ADVSEARCH]
                    = new AdvSearchPanel();        preSearchStringsArray[ADVSEARCH] = " You are in the advanced search pane";
        panelsArray[SEARCHRESULTS]
                    = new DisplayScrollPane(new SearchResultsPanel());
        /* TODO: Creating a test User object can potentially throw an SQLException.
         * Once the MyAccountPanel is updated to use the current user instead of the test User,
         * this try-catch block can be eliminated
         * */
        try {
            panelsArray[MYACCOUNT]
                        = new MyAccountPanel();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } //new MyAccountPanel();

        panelsArray[MYCART] =
            new CheckoutPanel(); //new MyCheckoutPanel();
        preSearchStringsArray[MYCART] = " Search My Cart";        // the catalogue, containing all the items :D        panelsArray[CATALOGUE]                    = new DisplayScrollPane(new CataloguePanel());

        initialised = true;

    }

    /**
     * Returns the desired JPanel when passed in a constant defined in this
     * class.
     * @param panelNum the index of the panel to fetch from panelsArray
     * @precond PanelsManager is initialized ==> panelsArray is initialized
     * @precond panelNum is not outside the range of panelsArray
     * @precond panelNum is not negative
     * @return a descendent of JPanel from panelsArray, using panelNum as an
     * index of panelsArray.
     */
    public static JComponent getPanel(final int panelNum) {

        /*
         * precond PanelsManager is initialized ==> panelsArray is initialized
         */
        if (!initialised) {
            throw new RuntimeException("Tried to fetch panel when panels "
                    + "manager not initialized.");
        }

        /*
         * precond panelNum is not outside the range of panelsArray
         */
        if (panelNum >= NUMPANELS) {

            throw new RuntimeException("Invalid panel request, " + panelNum
                    + ".  Max: " + (NUMPANELS - 1));

        }

        /*
         * panelNum is not negative
         */
        if (panelNum < 0) {

            throw new RuntimeException("Invalid panel request, " + panelNum
                    + ".  Only positive integers allowed");

        }

        /*
         * returns a descendent of JPanel from panelsArray, using panelNum as an
         * index of panelsArray.
         */
        return panelsArray[panelNum];

    }

    /**
     * @return the number of panels managed by this class
     */
    public static int getNumPanels() {

        return NUMPANELS;

    }

    /**
     * @return the 'pre search string' that goes in the searchbox before any
     * text is entered.
     */
    public static String getPreSearchString(int panelNum){

        if(preSearchStringsArray[panelNum] == null){

            return defaultPreSearchString;

        }

        return preSearchStringsArray[panelNum];

    }

    /**
     * Sets the default panel that the app will open on startup.
     * @param defaultPanelTab - the tab which, when pressed, opens the
     * default panel
     */
    public static void setDefaultPanel(final Tab defaultPanelTab) {

        if (defaultTab != null) {

            throw new RuntimeException("Default tab was set twice.  "
                    + " Check for duplicate calls to 'setDefaultPanel'");

        }

        defaultTab = defaultPanelTab;

    }

    /**
     * Clicks the tab to take us to the default panel.
     */
    public static void goToDefaultPanel() {

        if (defaultTab == null) {

            throw new RuntimeException("Default tab was never set.  Set exactly"
                    + " one tab in TabsPanel.java using"
                    + " PanelsManager.setDefaultpanel(Tab)");

        }

        defaultTab.doClick();
        defaultTab.requestFocus();

    }
}
