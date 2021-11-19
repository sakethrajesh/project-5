/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * @author Nash Gober
 * @version 2021.11.18
 * 
 *          Tests Ethnicity
 */
public class EthnicityTest extends TestCase {
    private Ethnicity white;
    private Ethnicity black;

    public void setUp() {
        white = new Ethnicity("white", 155, 1000);
        black = new Ethnicity("black", 200, 500);

    }


    public void testGetEthnicityName() {
        assertEquals(white.getEthnicityName(), "white");
        assertEquals(black.getEthnicityName(), "black");
    }


    public void testGetDeaths() {
        assertEquals(155, white.getDeaths());
        assertEquals(200, black.getDeaths());

    }


    public void testGetCases() {
        assertEquals(1000, white.getCases());
        assertEquals(500, black.getCases());
    }


    public void testCalculatePercentage() {
        assertEquals(15.5, white.calculatePercentage(), .01);
        assertEquals(40.00, black.calculatePercentage(), .01);
    }


    public void testToString() {

        Ethnicity asian = new Ethnicity("asian", -1, 100);
        assertEquals("white: 1000 cases, 15.5% CFR", white.toString());
        assertEquals("black: 500 cases, 40.0% CFR", black.toString());
        assertEquals("asian: 100 cases, -1.0% CFR", asian.toString());
    }
}
