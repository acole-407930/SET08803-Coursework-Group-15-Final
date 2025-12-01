package com.napier.sem.view;

public class showCountryPopulation {

    public void displayCountryPopulation(String countryName, long totalPopulation) {
        System.out.println("\n============================================");
        System.out.println("      TOTAL POPULATION OF COUNTRY");
        System.out.println("============================================");

        if (totalPopulation == 0) {
            System.out.println("Country: " + countryName);
            System.out.println("Result: Country not found or no population data.");
        } else {
            System.out.printf("Country: %-20s | Population: %,d%n", countryName, totalPopulation);
        }

        System.out.println("============================================\n");
    }
}
