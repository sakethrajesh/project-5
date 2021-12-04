package prj5;

import student.TestCase;

/**
 * Test class for the SortTest class
 * 
 * @author <Kevin Flint> <flintkt>
 * @version <11.19.2021>
 *
 */
public class SortTypeTest extends TestCase {

    private SortType alpha;
    private SortType cfr;

    /**
     * Setup method for the DoublyLinkedListTest class
     */
    public void setUp() {
        alpha = SortType.Alpha;
        cfr = SortType.CFR;
    }


    /**
     * Test method for the Alpha enum element
     * of the SortTypeTest Class
     * tests that Alpha enum element functions correctly
     */
    public void testAlpha() {
        assertEquals(alpha, SortType.Alpha);
    }


    /**
     * Test method for the CFR enum element
     * of the SortTypeTest Class
     * tests that CFR enum element functions correctly
     */
    public void testCFR() {
        assertEquals(cfr, SortType.CFR);
    }

}
