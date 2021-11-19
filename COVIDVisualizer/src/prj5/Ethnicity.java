/**
 * 
 */
package prj5;

import java.text.DecimalFormat;

/**
 * @author Nash Gober
 * @version 2021.11.17
 *
 *          Creates an Ethnicity Object to store in a DoublyLinkedList
 */
public class Ethnicity {
    private String ethnicity;
    private int deaths;
    private int cases;

    /**
     * Constructor for Ethnicity, assings parameters to private variables
     * 
     * 
     * @param ethnicity
     *            The name of the ethnicity
     * @param deaths
     *            The number of deaths
     * @param cases
     *            The number of cases
     */
    public Ethnicity(String ethnicity, int deaths, int cases) {
        this.ethnicity = ethnicity;
        this.deaths = deaths;
        this.cases = cases;

    }


    /**
     * 
     * Gets the name of the ethnicity
     * 
     * @return String of the ethnicity's name
     */
    public String getEthnicityName() {
        return this.ethnicity;
    }


    /**
     * Gets the number of deaths
     * 
     * 
     * 
     * @return A Double of the number of deaths
     */
    public int getDeaths() {
        return this.deaths;
    }


    /**
     * Gets the number of cases
     * 
     * 
     * @return A Double of the number of cases
     */
    public int getCases() {
        return this.cases;
    }


    /**
     * Calculates the percentage of total deaths for total cases
     * 
     * 
     * @return A Double of the percentage of total deaths for total cases
     */
    public Double calculatePercentage() {
        if (deaths == -1 || cases == -1) {
            return -1.0;
        }

        return (Double.valueOf(deaths) / Double.valueOf(cases)) * 100.00;

    }


    /**
     * Returns the Ethnicity as a String with all it's comparators
     * 
     * @return A string containing all of Ethnicities information
     * 
     */

    public String toString() {
        String combine = "";
        if (calculatePercentage() == -1.0) {

            combine = this.ethnicity + ": " + cases + " cases, " + String
                .valueOf(calculatePercentage()).substring(0, 2) + "% CFR";
        }
        else {
            combine = this.ethnicity + ": " + cases + " cases, "
                + calculatePercentage() + "% CFR";
        }
        return combine;
    }

}
