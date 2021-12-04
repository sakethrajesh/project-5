package prj5;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Iterator;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * GUI Window class
 * Class for creating a window object with data visuals
 * @author Kevin Flint
 * @version 12.03.2021
 */
public class GUIWindow {
    
    private Window window;
    private DoublyLinkedList<State> states;
    private State currentState;
    private SortType sortType;
    
    public GUIWindow(DoublyLinkedList<State> statesList) {
        
        states = statesList;
        currentState = null;
        // data is initially sorted buy cfr
        sortType = SortType.CFR;
        
        // initialize window
        window = new Window("Covid-19 Visualization");
        
        // initialize top buttons
        Button alphaSortButton = new Button("Sort By Alpha");
        Button quitButton = new Button("Quit");
        Button cfrSortButton = new Button("Sort By CFR");
        
        // add buttons to top of window
        window.addButton(alphaSortButton, WindowSide.NORTH);
        window.addButton(quitButton, WindowSide.NORTH);
        window.addButton(cfrSortButton, WindowSide.NORTH);
        
        // initialize bottom buttons (State buttons)
        Button dcButton = new Button("Represent DC");
        Button gaButton = new Button("Represent GA");
        Button mdButton = new Button("Represent MD");
        Button ncButton = new Button("Represent NC");
        Button tnButton = new Button("Represent TN");
        Button vaButton = new Button("Represent VA");
        
        // add buttons to bottom of window
        window.addButton(dcButton, WindowSide.SOUTH);
        window.addButton(gaButton, WindowSide.SOUTH);
        window.addButton(mdButton, WindowSide.SOUTH);
        window.addButton(ncButton, WindowSide.SOUTH);
        window.addButton(tnButton, WindowSide.SOUTH);
        window.addButton(vaButton, WindowSide.SOUTH);
        
        // connect button functionality
        
        // sort buttons
        alphaSortButton.onClick(this, "clickedAlphaSort");
        cfrSortButton.onClick(this, "clickedCFRSort");
        
        // state buttons
        dcButton.onClick(this, "clickedDC");
        gaButton.onClick(this, "clickedGA");
        mdButton.onClick(this, "clickedMD");
        ncButton.onClick(this, "clickedNC");
        tnButton.onClick(this, "clickedTN");
        vaButton.onClick(this, "clickedVA");
        
        // quit button
        quitButton.onClick(this, "quitProgram");
        
    }
    
    /* on click methods for the state buttons */
    
    /**
     * Method called for DC state button
     * @param button
     *      button parameter for cs2 button functionality
     */
    public void clickedDC(Button button) {
        currentState = getState("DC");
        if (sortType == SortType.Alpha) {
            currentState.sortAlphabetical();
        }
        else if (sortType == SortType.CFR) {
            currentState.sortCFR();
        }
        drawInfo();
    }
    
    /**
     * Method called for GA state button
     * @param button
     *      button parameter for cs2 button functionality
     */
    public void clickedGA(Button button) {
        currentState = getState("GA");
        if (sortType == SortType.Alpha) {
            currentState.sortAlphabetical();
        }
        else if (sortType == SortType.CFR) {
            currentState.sortCFR();
        }
        drawInfo();
    }
    
    /**
     * Method called for MD state button
     * @param button
     *      button parameter for cs2 button functionality
     */
    public void clickedMD(Button button) {
        currentState = getState("MD");
        if (sortType == SortType.Alpha) {
            currentState.sortAlphabetical();
        }
        else if (sortType == SortType.CFR) {
            currentState.sortCFR();
        }
        drawInfo();
    }
    
    /**
     * Method called for NC state button
     * @param button
     *      button parameter for cs2 button functionality
     */
    public void clickedNC(Button button) {
        currentState = getState("NC");
        if (sortType == SortType.Alpha) {
            currentState.sortAlphabetical();
        }
        else if (sortType == SortType.CFR) {
            currentState.sortCFR();
        }
        drawInfo();
    }
    
    /**
     * Method called for TN state button
     * @param button
     *      button parameter for cs2 button functionality
     */
    public void clickedTN(Button button) {
        currentState = getState("TN");
        if (sortType == SortType.Alpha) {
            currentState.sortAlphabetical();
        }
        else if (sortType == SortType.CFR) {
            currentState.sortCFR();
        }
        drawInfo();
    }
    
    /**
     * Method called for VA state button
     * @param button
     *      button parameter for cs2 button functionality
     */
    public void clickedVA(Button button) {
        currentState = getState("VA");
        if (sortType == SortType.Alpha) {
            currentState.sortAlphabetical();
        }
        else if (sortType == SortType.CFR) {
            currentState.sortCFR();
        }
        drawInfo();
    }
    
    /* end of on click methods for state buttons */
    
    /* on click methods for sort buttons */
    
    /**
     * Method called for the alpha sort method
     * @param button
     *      button parameter for cs2 button functionality
     */
    public void clickedAlphaSort(Button button) {
        sortType = SortType.Alpha;
        if (currentState != null) {
            // sort the data in the state alphabetically
            currentState.sortAlphabetical();
            // re-draw the data
            drawInfo();
        }
        else {
            System.out.println("Current state is null, can't perform sort");
        }
    }
    
    /**
     * Method called for the cfr sort method
     * @param button
     *      button parameter for cs2 button functionality
     */
    public void clickedCFRSort(Button button) {
        sortType = SortType.CFR;
        if (currentState != null) {
            // sort the data in the state alphabetically
            currentState.sortCFR();;
            // re-draw the data
            drawInfo();
        }
        else {
            System.out.println("Current state is null, can't perform sort");
        }
    }
    
    /* end of on click methods for sort buttons */
    
    /**
     * Exits the program
     */
    public void quitProgram(Button button) {
        System.exit(0);
    }
    
    /**
     * Looks for and returns a state in the states list,
     * specified by its name
     * @param name
     *      name of the state being searched for
     * @return
     *      the state object, specified by its name
     */
    public State getState(String name) {
        Iterator<State> statesIterator = states.iterator();
        while(statesIterator.hasNext()) {
            State current = (State) statesIterator.next();
            if (current.getName().equals(name)) {
                return current;
            }
        }
        return null;
    }
    
    
    /**
     * Draws a visual representation of data contained in a state object,
     * passed to the function as an argument
     * 
     * Note: will need to add state parameter and make visuals dynamically
     * responsive to data
     * 
     */
    public void drawInfo() {
        
        // clear the window
        window.removeAllShapes();
        
        // draw title
        String titleText;
        if (currentState != null) {
            titleText = currentState.getName() + 
                " Case Fatality Ratios By Race";
        }
        else {
            System.out.println("Current state is null, can't draw visuals");
            return;
        }
        TextShape title = new TextShape(window.getWidth()/2, 10, titleText);
        title.moveTo(window.getWidth()/2 - title.getWidth()/2, 10);
        window.addShape(title);
        
        Iterator stateEthnicities = null; 
        stateEthnicities = currentState.getList().iterator();
        
        // specify divider length for separate points of data to sit in
        int horizontalDiv = window.getWidth()/currentState.getList().size();
        
        // initialize data visuals
        
        // declare variables for shape dynamics
        int width;
        int height;
        int x;
        int y;
        
        // declare variable for current data
        Ethnicity current;
        
        // for each data point in the state
        for (int i = 0; i < currentState.getList().size(); i++) {
            
            if (stateEthnicities.hasNext()) {
                current = (Ethnicity) stateEthnicities.next();
            }
            else {
                System.out.println("Could not draw visuals, ran out of data. "
                    + "State does not have correct number of"
                    + " ethnicity data points");
                return;
            }
            
            // initialize variables for shape dynamics
            width = 25;
            double normalizedHeight = current.calculatePercentage() * 25;
            height = (int) normalizedHeight;
            x = horizontalDiv/2 + horizontalDiv * i;
            y = window.getHeight() - height - 175;
            
            // create shapes for data point
            if (current.calculatePercentage() == -1.0) {
                TextShape nullLabel = new TextShape(
                    x, y + height + 10, "NA"
                    );
                TextShape label = new TextShape(
                    x, y + height + 35, current.getEthnicityName()
                    );
                // center null label text ("NA" text)
                nullLabel.moveTo(
                    x + label.getWidth()/2 - nullLabel.getWidth()/2,
                    y + height + 10
                    );
                window.addShape(nullLabel);
                window.addShape(label);
            }
            else {
                Shape bar = new Shape(x, y, width, height, Color.BLUE);
                TextShape label = new TextShape(
                    x, y + height + 10, current.getEthnicityName()
                    );
                DecimalFormat df = new DecimalFormat("#.#");
                TextShape percentage = new TextShape(
                    x, 
                    y + height + 35, 
                    df.format(current.calculatePercentage()) + "%"
                    );
                
                // add to window
                window.addShape(bar);
                window.addShape(label);
                window.addShape(percentage);
            }
            
        }

    }
    
}
