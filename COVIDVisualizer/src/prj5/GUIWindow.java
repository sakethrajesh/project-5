package prj5;

import java.awt.Color;
import java.util.Iterator;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

public class GUIWindow {
    
    private Window window;
    private DoublyLinkedList<State> states;
    private State currentState;
    
    
    public GUIWindow(DoublyLinkedList<State> statesList) {
        
        states = statesList;
        currentState = null;
        
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
    
    public void clickedDC(Button button) {
        currentState = getState("DC");
        drawInfo();
    }
    
    public void clickedGA(Button button) {
        currentState = getState("GA");
        drawInfo();
    }
    
    public void clickedMD(Button button) {
        currentState = getState("MD");
        drawInfo();
    }
    
    public void clickedNC(Button button) {
        currentState = getState("NC");
        drawInfo();
    }
    
    public void clickedTN(Button button) {
        currentState = getState("TN");
        drawInfo();
    }
    
    public void clickedVA(Button button) {
        currentState = getState("VA");
        drawInfo();
    }
    
    /* end of on click methods for state buttons */
    
    /* on click methods for sort buttons */
    
    public void clickedAlphaSort(Button button) {
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
    
    public void clickedCFRSort(Button button) {
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
        String titleText = "Case Fatality Ratios By Race";
        TextShape title = new TextShape(window.getWidth()/2, 10, titleText);
        window.addShape(title);
        
        // specify divider length for separate points of data to sit in
        int horizontalDiv = window.getWidth()/5;
        
        Iterator stateEthnicities = null; 
        if (currentState != null) {
            stateEthnicities = currentState.getList().iterator();
        }
        
        // initialize data visuals
        
        // declare variables for shape dynamics
        int width;
        int height;
        int x;
        int y;
        
        // declare variable for current data
        Ethnicity current;
        
        for (int i = 0; i < 5; i++) {
            
            if (stateEthnicities != null && stateEthnicities.hasNext()) {
                current = (Ethnicity) stateEthnicities.next();
            }
            else {
                System.out.println("Could not draw visuals, ran out of data. "
                    + "State does not have correct number of"
                    + " ethnicity data points OR State does not exist");
                return;
            }
            
            // initialize variables for shape dynamics
            width = 25;
            height = current.calculatePercentage().intValue() * 20;
            x = horizontalDiv/2 + horizontalDiv * i;
            y = window.getHeight()/2 - height/2;
            
            // create shapes for data point
            Shape bar = new Shape(x, y, width, height, Color.BLUE);
            TextShape label = new TextShape(
                x, y + height + 10, current.getEthnicityName()
                );
            TextShape percentage = new TextShape(
                x, y + height + 35, current.calculatePercentage().toString()
                );
            
            // add to window
            window.addShape(bar);
            window.addShape(label);
            window.addShape(percentage);
            
        }
        
        
        /*
        // first
        


        
        // second
        width = 25;
        height = 50;
        x = x + horizontalDiv;
        y = window.getHeight()/2 - height/2;
        Shape second = new Shape(x, y, width, height, Color.BLUE);
        
        TextShape secondLabel = new TextShape(x, y + height + 10, "second");
        TextShape secondPercentage = new TextShape(x, y + height + 35, "%");
        
        // third
        width = 25;
        height = 50;
        x = x + horizontalDiv;
        y = window.getHeight()/2 - height/2;
        Shape third = new Shape(x, y, width, height, Color.BLUE);
        
        TextShape thirdLabel = new TextShape(x, y + height + 10, "third");
        TextShape thirdPercentage = new TextShape(x, y + height + 35, "%");
        
        // fourth
        width = 25;
        height = 50;
        x = x + horizontalDiv;
        y = window.getHeight()/2 - height/2;
        Shape fourth = new Shape(x, y, width, height, Color.BLUE);
        
        TextShape fourthLabel = new TextShape(x, y + height + 10, "fourth");
        TextShape fourthPercentage = new TextShape(x, y + height + 35, "%");
        
        // fifth
        width = 25;
        height = 50;
        x = x + horizontalDiv;
        y = window.getHeight()/2 - height/2;
        Shape fifth = new Shape(x, y, width, height, Color.BLUE);
        
        TextShape fifthLabel = new TextShape(x, y + height + 10, "fifth");
        TextShape fifthPercentage = new TextShape(x, y + height + 35, "%");
        
        // add to window
        window.addShape(first);
        window.addShape(firstLabel);
        window.addShape(firstPercentage);
        window.addShape(second);
        window.addShape(secondLabel);
        window.addShape(secondPercentage);
        window.addShape(third);
        window.addShape(thirdLabel);
        window.addShape(thirdPercentage);
        window.addShape(fourth);
        window.addShape(fourthLabel);
        window.addShape(fourthPercentage);
        window.addShape(fifth);
        window.addShape(fifthLabel);
        window.addShape(fifthPercentage);
        
        */
        
    }
    
}
