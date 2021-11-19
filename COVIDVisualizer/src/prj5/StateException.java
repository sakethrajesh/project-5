/**
 * 
 */
package prj5;

/**
 * @author Nash Gober
 * @version 2021.11.18
 * 
 *          Creates a custom exception StateException
 *
 */
@SuppressWarnings("serial")
public class StateException extends Exception {

    /**
     * Constructor for the StateException
     * 
     * 
     * @param string
     */
    public StateException(String string) {
        super(string);
    }

}
