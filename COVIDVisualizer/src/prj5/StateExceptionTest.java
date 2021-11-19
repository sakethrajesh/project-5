/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * @author Nash Gober
 * @version 2021.11.18
 * 
 *          Test Class for StateException
 *
 */

public class StateExceptionTest extends TestCase {

    private StateException exception;

    /**
     * 
     * Sets up Test Cases
     * 
     */
    public void setUp() {
        exception = new StateException("no");

    }


    /**
     * Tests the Constructor of StateException
     * 
     * 
     */
    public void testStateException() {

        assertEquals(exception.getMessage(), "no");
    }
}
