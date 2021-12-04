package prj5;

/**
 * 
 * State Class that representatives states that holds diffrent Ethnicities
 * 
 * @author <Kevin Flint> <flintkt>
 * @version <11.19.2021>
 *
 */
public class State {

    private DoublyLinkedList<Ethnicity> ethnicityList;
    private String name;

    /**
     * 
     * Constructor for the State class
     * Initializes class variables
     * 
     * @param inName
     *            name of the state
     * @param inEthnicityList
     *            list of ethnicities in state
     */
    public State(String inName, DoublyLinkedList<Ethnicity> inEthnicityList) {
        name = inName;
        ethnicityList = inEthnicityList;
    }


    /**
     * Returns the privately stored name of the state
     * 
     * @return
     *         the name of the state
     */
    public String getName() {
        return name;
    }


    /**
     * Gets the state's list of Ethnicities
     * 
     * @return
     *         state's list of Ethnicities
     */
    public DoublyLinkedList<Ethnicity> getList() {
        return ethnicityList;
    }


    /**
     * Sorts the state's list alphabeticaly
     */
    public void sortAlphabetical() {
        for (int i = 0; i < ethnicityList.size(); i++) {
            // find next smallest value in list
            int index = i;
            for (int j = i + 1; j < ethnicityList.size(); j++) {
                if (((Ethnicity)ethnicityList.get(index)).getEthnicityName()
                    .compareTo(((Ethnicity)ethnicityList.get(j))
                        .getEthnicityName()) > 0) {
                    index = j;
                }
            }
            // swap the current value in the list with the smallest value in the
            // list:

            // insert the values at their new positions
            ethnicityList.add(i, ethnicityList.get(index));
            ethnicityList.add(index, ethnicityList.get(i + 1));

            // remove the old values
            ethnicityList.remove(i + 1);
            ethnicityList.remove(index + 1);
        }
    }


    /**
     * Sorts the state's list by cfr
     */
    public void sortCFR() {
        for (int i = 0; i < ethnicityList.size(); i++) {
            // find next smallest value in list
            int index = i;
            for (int j = i + 1; j < ethnicityList.size(); j++) {
                if (((Ethnicity)ethnicityList.get(index))
                    .calculatePercentage() < ((Ethnicity)ethnicityList.get(j))
                        .calculatePercentage()) {
                    index = j;
                }

            }
            // swap the current value in the list with the smallest value in the
            // list:

            // insert the values at their new positions
            ethnicityList.add(i, ethnicityList.get(index));
            ethnicityList.add(index, ethnicityList.get(i + 1));

            // remove the old values
            ethnicityList.remove(i + 1);
            ethnicityList.remove(index + 1);
        }

        for (int i = 0; i < ethnicityList.size() - 1; i++) {

            if (Math.abs(((Ethnicity)ethnicityList.get(i)).calculatePercentage()
                - ((Ethnicity)ethnicityList.get(i + 1))
                    .calculatePercentage()) < 0.01) {
                if (((Ethnicity)ethnicityList.get(i)).getEthnicityName()
                    .compareTo(((Ethnicity)ethnicityList.get(i + 1))
                        .getEthnicityName()) > 0) {
                    // swap two elements
                    ethnicityList.add(i, ethnicityList.get(i + 1));
                    ethnicityList.remove(i + 2);
                }

            }

        }

    }


    /**
     * outputs the states ethnicity list in alphabetical order,
     * then in order by cfr
     * 
     * @return
     *         a string representation of the data in the ethnicity class
     */
    public String toString() {
        String s = this.name + "\n";
        sortAlphabetical();
        for (int i = 0; i < ethnicityList.size(); i++) {
            s += ethnicityList.get(i).toString() + "\n";
        }
        s += "=====" + "\n";
        sortCFR();
        for (int i = 0; i < ethnicityList.size(); i++) {
            s += ethnicityList.get(i).toString();
            if (i < ethnicityList.size() - 1) {
                s += "\n";
            }
        }
        return s;
    }

}
