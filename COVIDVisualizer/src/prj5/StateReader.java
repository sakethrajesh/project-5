/**
 * 
 */
package prj5;

import java.awt.Taskbar.State;
import java.io.File;
import java.util.Scanner;

/**
 * @author Saketh
 *
 */
public class StateReader {
    private DoublyLinkedList<State> stateList;
    private String inputFile; 
    
    public StateReader() {
        
    }
    
    public DoublyLinkedList<State> DoublereadFile(String inputFile) {
        Scanner file = new Scanner(new File(inputFile));
        String[] titles = file.nextLine().split(", *");
        while (file.hasNextLine()) {
            State state = this.readLine(file.nextLine(), titles);
            stateList.add(state);
            
        }
        return stateList;
        
    }
    
    private State readLine(String line, String[] titles) {
        
        String[] strSplit = line.split(", *");
        Integer[] deathRates = new Integer[strSplit.length - 1];
        for (int i = 1; i < this.findSplit(titles); i++) {
            if(strSplit[i].equals("NA")) {
                deathRates[i - 1] = -1;
                
            }
            else {
                Integer converted = Integer.valueOf(strSplit[i]);
                deathRates[i - 1] = converted;
            }   
        }
        Integer[] cases = new Integer[strSplit.length - 1];
        for (int i = this.findSplit(titles); i < titles.length; i++) {
            if(strSplit[i].equals("NA")) {
                cases[i - 1] = -1;
                
            }
            else {
                Integer converted = Integer.valueOf(strSplit[i]);
                cases[i - 1] = converted;
            }   
        }
        DoublyLinkedList<Ethnicity> e = new DoublyLinkedList<Ethnicity>();
        for (int i = 0; i < cases.length; i++) {
            Ethnicity ethnicity = new Ethnicity(strSplit[i], deathRates[i], cases[i]);
            e.add(ethnicity);
        }
        State state = new State(strSplit[0], e);
        return state;
        
    }
    private int findSplit(String[] titles) {
        if(titles == null) {
            throw new StateExeption("titles is null");
        }
        for(int i = 0; i < titles.length; i++) {
            if(titles[i].contains("Cases")) {
                return i;
            }
        }
        return -1;
        
    }
    
    public DoublyLinkedList<State> getStateList(){
        return stateList;
    }
}
