package prj5;

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
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
        
        drawInfo();
        
    }
    
    /**
     * Exits the program
     */
    public void quitProgram(Button button) {
        System.exit(0);
    }
    
    /**
     * Draws a visual representation of data contained in a state object,
     * passed to the function as an argument
     * 
     * Note: will need to add state parameter and make visuals dynamically
     * responsive to data
     * 
     */
    public void drawInfo(/*State state*/) {
        
        // draw title
        String titleText = "Case Fatality Ratios By Race";
        TextShape title = new TextShape(window.getWidth()/2, 10, titleText);
        window.addShape(title);
        
        // specify divider length for separate points of data to sit in
        int horizontalDiv = window.getWidth()/5;
        
        // initialize data visuals
        
        // first
        
        int width = 25;
        int height = 50;
        int x = horizontalDiv/2;
        int y = window.getHeight()/2 - height/2;
        Shape first = new Shape(x, y, width, height, Color.BLUE);
        
        TextShape firstLabel = new TextShape(x, y + height + 10, "first");
        TextShape firstPercentage = new TextShape(x, y + height + 35, "%");
        
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
        
    }
    
}
