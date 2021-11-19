/**
 * 
 */
package prj5;

/**
 * @author Saketh
 *
 */
public class Input {

    /**
     * @param args
     */
    public static void main(String[] args) {
        StateReader stateRead;
        if (args.length == 1) {
            stateRead = new StateReader(args[0]);
        }
        else {
            stateRead = new StateReader(
                "Cases_and_Deaths_by_race_CRDT_Sep2020");
        }
        Output output = new Output(stateRead.getStateList());
        GUIWindow window = new GUIWindow(stateRead.getStateList());

    }

}
