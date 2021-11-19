/**
 * 
 */
package prj5;

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


    public String toString() {
        String combine = this.ethnicity + ": " + cases + " cases, "
            + calculatePercentage() + "% CFR";
        return combine;
    }

}
