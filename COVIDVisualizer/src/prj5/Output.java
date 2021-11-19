/**
 * 
 */
package prj5;

import bag.Node;

/**
 * @author Nash Gober
 * @version 2021.11.19
 * 
 * 
 *
 */
public class Output {

    private DoublyLinkedList<State> stateList;

    public Output(DoublyLinkedList<State> stateList) {
        this.stateList = stateList;
        printOutput();

    }


    public void printOutput() {

        for (int i = 0; i < stateList.size(); i++) {
            System.out.println(stateList.get(i).toString());
            System.out.println("=====");

        }

    }


    public String toString() {
        String s = this.name + "\n";
        for (int i = 0; i < ethnicityList.size(); i++) {
            s += ethnicityList.get(i).toString() + "\n";
        }
        sortCFR();
        for (int i = 0; i < ethnicityList.size(); i++) {
            s += ethnicityList.get(i).toString() + "\n";
        }
        sortAlphabetical();

    }

}
