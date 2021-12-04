package prj5;

import java.io.FileNotFoundException;

/**
 * Class for taking in input and running the program and gui
 * 
 * @author Saketh Rajesh
 * @version 12.03.2021
 */
public class Input {

    /**
     * @param args
     *            name of file
     * @throws FileNotFoundException
     *             thrown when file does not exist
     * @throws NumberFormatException
     *             thrown when when parsed String can not be converted to a
     *             Double Object
     */
    public static void main(String[] args)
        throws FileNotFoundException,
        NumberFormatException {
        StateReader stateRead;
        if (args.length == 1) {
            // initialize new state reader
            stateRead = new StateReader(args[0]);
            // create new gui
            GUIWindow gui = new GUIWindow(stateRead.getStateList());
        }
        else {
            // initialize new state reader
            stateRead = new StateReader(
                "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
            // create new gui
            GUIWindow gui = new GUIWindow(stateRead.getStateList());
        }
    }
}
