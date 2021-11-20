package prj5;

import list.ListInterface;
import student.TestCase;

/**
 * 
 * @author <Kevin Flint> <flintkt>
 * @version <11.19.2021>
 *
 */
public class StateTest extends TestCase {
    
    private State state;
    private DoublyLinkedList<Ethnicity> list;
    private DoublyLinkedList<Ethnicity> list2;
    
    /**
     *  Setup method for the DoublyLinkedListTest class
     */
    public void setUp() {
        
        list = new DoublyLinkedList<Ethnicity>();
        list.add(new Ethnicity("asain", 254, 5407));
        list.add(new Ethnicity("black", 13365, 179563));
        list.add(new Ethnicity("latinx", 2269, 97118));
        list.add(new Ethnicity("other", 170, 108784));
        list.add(new Ethnicity("white", 1924, 70678));
        
        list2 = new DoublyLinkedList<Ethnicity>();
        list2.add(new Ethnicity("black", 13365, 179563));
        list2.add(new Ethnicity("asain", 254, 5407));
        list2.add(new Ethnicity("white", 1924, 70678));
        list2.add(new Ethnicity("latinx", 2269, 97118));
        list2.add(new Ethnicity("other", 170, 108784));
        
        state = new State("DC", list);
    }
    
    /**
     * Test method for the getList() method
     * of the StateTest Class
     * tests that getList() functions correctly
     */
    public void testGetList() {
        assertEquals(state.getList(), list);
    }
    
    /**
     * Test method for the sortCFR() method
     * of the StateTest Class
     * tests that sortCFR() functions correctly
     */
    public void testSortCFR() {
        state.sortCFR();
        for (int i = 0; i < state.getList().size(); i++) {
            assertEquals(list2.get(i).toString() , ((Ethnicity)state.getList().get(i)).toString());
        }
    }
    
    /**
     * Test method for the sortAlphabetical() method
     * of the StateTest Class
     * tests that sortAlphabetical() functions correctly
     */
    public void testSortAlphabetical() {
        state.sortAlphabetical();
        for (int i = 0; i < state.getList().size(); i++) {
            assertEquals(list.get(i).toString() , ((Ethnicity)state.getList().get(i)).toString());
        }
    }
    
    /**
     * Test method for the toString() method
     * of the StateTest Class
     * tests that toString() functions correctly
     */
    public void testToString() {
        String s = "DC\n"
            + "asain: 5407 cases, 4.7% CFR\n"
            + "black: 179563 cases, 7.4% CFR\n"
            + "latinx: 97118 cases, 2.3% CFR\n"
            + "other: 108784 cases, 0.2% CFR\n"
            + "white: 70678 cases, 2.7% CFR\n"
            + "=====\n"
            + "black: 179563 cases, 7.4% CFR\n"
            + "asain: 5407 cases, 4.7% CFR\n"
            + "white: 70678 cases, 2.7% CFR\n"
            + "latinx: 97118 cases, 2.3% CFR\n"
            + "other: 108784 cases, 0.2% CFR";
        assertEquals(state.toString(), s);
    }
    
    
    
}