package com.napier.sem.view;

public class showTotalPopulationOfDistrict {
    /**
     * Displays the total population of a given district.
     *
     * @param districtName The name of the district.
     * @param totalPopulation The calculated population value.
     */
    public void displayTotalPopulation(String districtName, long totalPopulation) {

        System.out.println("============================================================");
        System.out.println("                Total Population Report                     ");
        System.out.println("============================================================");
        System.out.println("District Selected: " + districtName);
        System.out.println("Total Population of " + districtName + ": " + totalPopulation);
        System.out.println("============================================================");
    }
}

