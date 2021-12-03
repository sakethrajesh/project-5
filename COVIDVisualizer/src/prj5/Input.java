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
            
            // test code
            
            System.out.println("ಠ_ಠ");
            /*
            DoublyLinkedList<State> states = new DoublyLinkedList<State>();
            
            DoublyLinkedList<Ethnicity> list = new DoublyLinkedList<Ethnicity>();
            list.add(new Ethnicity("asain", 254, 5407));
            list.add(new Ethnicity("black", 13365, 179563));
            list.add(new Ethnicity("latinx", 2269, 97118));
            list.add(new Ethnicity("other", 170, 108784));
            list.add(new Ethnicity("white", 1924, 70678));
            list.add(new Ethnicity("other2", 170, 108784));
            
            State state = new State("DC", list);
            
            states.add(state);
            */
            // end of test code
            
            // create new gui
            GUIWindow gui = new GUIWindow(stateRead.getStateList());
            
            
        }
        //Output output = new Output(stateRead.getStateList());

    }
}
