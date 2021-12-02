package prj5;

import cs2.Button;
import cs2.Window;
import cs2.WindowSide;

public class GUIWindow {
    
    private Window window;
    
    public GUIWindow() {
        
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
        
        quitButton.onClick(this, "quitProgram");
        
    }
    
    /**
     * Exits the program
     */
    public void quitProgram(Button button) {
        System.exit(0);
    }
    
}
