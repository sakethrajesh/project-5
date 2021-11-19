package prj5;

public class State {
    
    private DoublyLinkedList<Ethnicity> ethnicityList;
    private String name;
    
    public State(String inName, DoublyLinkedList<Ethnicity> inEthnicityList) {
        name = inName;
        ethnicityList = inEthnicityList;
    }
    
    public DoublyLinkedList<Ethnicity> getList() {
        return ethnicityList;
    }
    
    public void sortAlphabetical() {
        for (int i = 0; i < ethnicityList.size(); i++) {
            // find next smallest value in list
            int index = i;
            for (int j = i+1; j < ethnicityList.size(); j++) {
                if ( ((Ethnicity) ethnicityList.get(index)).getEthnicityName().compareTo( ((Ethnicity) ethnicityList.get(j)).getEthnicityName() ) > 0 ) {
                    index = j;
                }
            }
            // swap the current value in the list with the smallest value in the list:
            
            // insert the values at their new positions
            ethnicityList.add(i, ethnicityList.get(index));
            ethnicityList.add(index, ethnicityList.get(i+1));
            
            // remove the old values
            ethnicityList.remove(i+1);
            ethnicityList.remove(index+1);
        }
    }
    
    public void sortCFR() {
        for (int i = 0; i < ethnicityList.size(); i++) {
            // find next smallest value in list
            int index = i;
            for (int j = i+1; j < ethnicityList.size(); j++) {
                if ( ((Ethnicity) ethnicityList.get(index)).calculatePercentage() < ((Ethnicity) ethnicityList.get(j)).calculatePercentage() ) {
                    index = j;
                }
            }
            // swap the current value in the list with the smallest value in the list:
            
            // insert the values at their new positions
            ethnicityList.add(i, ethnicityList.get(index));
            ethnicityList.add(index, ethnicityList.get(i+1));
            
            // remove the old values
            ethnicityList.remove(i+1);
            ethnicityList.remove(index+1);
        }
    }
    
    public String toString() {
        String s = this.name + "\n";
        sortAlphabetical();
        for (int i = 0; i < ethnicityList.size(); i++) {
            s += ethnicityList.get(i).toString() + "\n";
        }
        sortCFR();
        for (int i = 0; i < ethnicityList.size(); i++) {
            s += ethnicityList.get(i).toString() + "\n";
        }
        return s;
    }

}

/*
String s = "";

// call first sort
for (int i = 0; j < ethnicityList.size(); j++) {
    s += ethnicityList.get(i).toString();
}
*/