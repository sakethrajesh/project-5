package prj5;

import student.TestCase;

public class StateTest extends TestCase {
    
    private State state;
    
    /**
     *  Setup method for the DoublyLinkedListTest class
     */
    public void setUp() {
        DoublyLinkedList<Ethnicity> list = new DoublyLinkedList<Ethnicity>();
        list.add(new Ethnicity("white", 1924, 70678));
        list.add(new Ethnicity("black", 13365, 179563));
        list.add(new Ethnicity("latinx", 2269, 97118));
        list.add(new Ethnicity("asain", 254, 5407));
        list.add(new Ethnicity("other", 170, 108784));
        state = new State("DC", list);
    }
    
    public void testSortCFR() {
        state.sortCFR();
        for (int i = 0; i < state.getList().size(); i++) {
            System.out.println( ((Ethnicity)state.getList().get(i)).toString());
        }
    }
    
    public void testSortAlphabetical() {
        state.sortAlphabetical();
        for (int i = 0; i < state.getList().size(); i++) {
            System.out.println( ((Ethnicity)state.getList().get(i)).toString());
        }
    }
    
    
    
}
