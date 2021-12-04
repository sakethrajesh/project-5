package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class reads the file and parses is to extract State info
 *
 * @author Saketh Rajesh
 * @version 11.19.21
 */
public class StateReader {
    private DoublyLinkedList<State> stateList;
    private String inputFile;

    /**
     *
     * @param fileName
     * @throws FileNotFoundException
     *             thrown when file is not found
     * @throws NumberFormatException
     *             thrown when string can not be cast to Integer
     */
    public StateReader(String fileName)
        throws FileNotFoundException,
        NumberFormatException {
        inputFile = fileName;
        stateList = new DoublyLinkedList<State>();
        DoublereadFile();

    }


    /**
     * Reads the file in class and creates a DoublyLinked list that contains
     * states
     * 
     * @return doublyLinkedList of States
     * @throws FileNotFoundException
     *             thrown when file is not found
     * @throws NumberFormatException
     *             thrown when string can not be cast to Integer
     * @throws StateException
     *             thrown when line has null values when split
     */
    private DoublyLinkedList<State> DoublereadFile()
        throws FileNotFoundException,
        NumberFormatException {
        Scanner file = new Scanner(new File(inputFile));
        String[] titles = file.nextLine().split(", *");
        while (file.hasNextLine()) {
            State state = this.readLine(file.nextLine(), titles);
            stateList.add(state);

        }
        return stateList;

    }


    /**
     * This method reads the line and creates a state object from the parsed
     * information
     * 
     * @param line
     *            next line that needs to be parasesd
     * @param titles
     *            titles of the coloms of csv file
     * @return returns a state from informtion on the line
     * @throws NumberFormatException
     *             thrown when there is an error casting string to Integer
     */
    private State readLine(String line, String[] titles)
        throws NumberFormatException {

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


    /**
     * This method finds the index at which the the changes from cases to deaths
     *
     * @param titles
     * @return index of first item that contins deaths
     * @throws StateException
     */
    private int findSplit(String[] titles) {
        for (int i = 0; i < titles.length; i++) {
            if (titles[i].contains("Deaths")) {
                return i;
            }
        }
        return -1;

    }


    /**
     * getterMethod for stateList
     *
     * @return statelist
     */
    public DoublyLinkedList<State> getStateList() {
        return stateList;
    }
}
