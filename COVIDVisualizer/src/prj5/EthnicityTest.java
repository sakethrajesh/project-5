/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * Test class for the ethnicity class
 * 
 * @author Nash Gober
 * @version 2021.11.18
 * 
 */
public class EthnicityTest extends TestCase {
    private Ethnicity white;
    private Ethnicity black;

    /**
     * set up method for the ethnicity test class
     */
    public void setUp() {
        white = new Ethnicity("white", 155, 1000);
        black = new Ethnicity("black", 200, 500);
    }


    /**
     * Test method for the getEthnicityName() method
     * of the EthnicityTest Class
     * tests that getEthnicityName() functions correctly
     */
    public void testGetEthnicityName() {
        assertEquals(white.getEthnicityName(), "white");
        assertEquals(black.getEthnicityName(), "black");
    }


    /**
     * Test method for the getGetDeaths() method
     * of the EthnicityTest Class
     * tests that getGetDeaths() functions correctly
     */
    public void testGetDeaths() {
        assertEquals(155, white.getDeaths());
        assertEquals(200, black.getDeaths());

    }


    /**
     * Test method for the getCases() method
     * of the EthnicityTest Class
     * tests that getCases() functions correctly
     */
    public void testGetCases() {
        assertEquals(1000, white.getCases());
        assertEquals(500, black.getCases());
    }


    /**
     * Test method for the calculatePercentage() method
     * of the EthnicityTest Class
     * tests that calculatePercentage() functions correctly
     */
    public void testCalculatePercentage() {
        Ethnicity asian = new Ethnicity("asian", -1, -1);
        Ethnicity asian1 = new Ethnicity("asian", 1, -1);
        Ethnicity asian2 = new Ethnicity("asian", -1, 1);
        assertEquals(15.5, white.calculatePercentage(), .01);
        assertEquals(40.00, black.calculatePercentage(), .01);
        assertEquals(-1.00, asian.calculatePercentage(), .01);
        assertEquals(-1.00, asian1.calculatePercentage(), .01);
        assertEquals(-1.00, asian2.calculatePercentage(), .01);
    }


    /**
     * Test method for the toString() method
     * of the EthnicityTest Class
     * tests that toString() functions correctly
     */
    public void testToString() {

        Ethnicity asian = new Ethnicity("asian", -1, 100);
        assertEquals("white: 1000 cases, 15.5% CFR", white.toString());
        assertEquals("black: 500 cases, 40% CFR", black.toString());
        assertEquals("asian: 100 cases, -1% CFR", asian.toString());
    }
}
