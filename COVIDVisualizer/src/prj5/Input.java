/**
 * 
 */
package prj5;

import java.io.FileNotFoundException;

/**
 * @author Saketh
 *
 */
public class Input {

    /**
     * @param args
     * @throws FileNotFoundException
     * @throws StateException
     * @throws NumberFormatException
     */
    public static void main(String[] args)
        throws FileNotFoundException,
        NumberFormatException,
        StateException {
        StateReader stateRead;
        if (args.length == 1) {
            stateRead = new StateReader(args[0]);
        }
        else {

            stateRead = new StateReader(
                "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");

        }
        Output output = new Output(stateRead.getStateList());

    }
}
