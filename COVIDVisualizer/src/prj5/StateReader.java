/**
 * 
 */
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Saketh
 *
 */
public class StateReader {
    private DoublyLinkedList<State> stateList;
    private String inputFile;

    public StateReader(String fileName)
        throws FileNotFoundException,
        NumberFormatException,
        StateException {
        inputFile = fileName;
        stateList = new DoublyLinkedList<State>();
        DoublereadFile();

    }


    public DoublyLinkedList<State> DoublereadFile()
        throws FileNotFoundException,
        NumberFormatException,
        StateException {
        Scanner file = new Scanner(new File(inputFile));
        String[] titles = file.nextLine().split(", *");
        while (file.hasNextLine()) {
            State state = this.readLine(file.nextLine(), titles);
            stateList.add(state);

        }
        return stateList;

    }


    private State readLine(String line, String[] titles)
        throws NumberFormatException,
        StateException {

        String[] strSplit = line.split(",");
        Integer[] deathRates = new Integer[this.findSplit(titles) - 1];
        for (int i = this.findSplit(titles); i < strSplit.length; i++) {
            if (strSplit[i].equals("NA")) {
                deathRates[i - this.findSplit(titles)] = -1;

            }
            else {
                Integer converted = Integer.valueOf(strSplit[i]);
                deathRates[i - this.findSplit(titles)] = converted;
            }
        }
        Integer[] cases = new Integer[this.findSplit(titles)];
        for (int i = 1; i < this.findSplit(titles); i++) {
            if (strSplit[i].equals("NA")) {
                cases[i - 1] = -1;

            }
            else {
                Integer converted = Integer.valueOf(strSplit[i]);
                cases[i - 1] = converted;
            }
        }
        String[] ethnicities = { "white", "black", "latinx", "asian", "other" };
        DoublyLinkedList<Ethnicity> e = new DoublyLinkedList<Ethnicity>();
        for (int i = 0; i < cases.length - 1; i++) {
            Ethnicity ethnicity = new Ethnicity(ethnicities[i], deathRates[i],
                cases[i]);
            e.add(ethnicity);
        }

        State state = new State(strSplit[0], e);
        return state;

    }


    private int findSplit(String[] titles) throws StateException {
        if (titles == null) {
            throw new StateException("titles is null");
        }
        for (int i = 0; i < titles.length; i++) {
            if (titles[i].contains("Deaths")) {
                return i;
            }
        }
        return -1;

    }


    public DoublyLinkedList<State> getStateList() {
        return stateList;
    }
}
