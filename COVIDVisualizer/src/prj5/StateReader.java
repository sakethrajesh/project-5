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
            State state = this.readLine(file.nextLine());
            stateList.add(state);
            
        }
        
    }
    
    private State readLine(String line) {
        String[] strSplit = line.split(", *");
        Integer[] deathRates = new Integer[strSplit.length - 1];
        for (int i = 1; i < strSplit.length; i++) {
            if(strSplit[i].equals("NA")) {
                deathRates[i - 1] = -1;
            }
            else {
                Integer converted = Integer.valueOf(strSplit[i]);
                deathRates[i - 1] = converted;
            }
            
            
        }
        
        
    }
    
    public DoublyLinkedList<State> getStateList(){
        return stateList;
    }
}
