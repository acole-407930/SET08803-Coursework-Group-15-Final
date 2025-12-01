package com.napier.sem.view;

public class showCityPopulation {

    public void displayCityPopulation(String cityName, long population) {
        System.out.println("\n============================================");
        System.out.println("       TOTAL POPULATION OF CITY");
        System.out.println("============================================");

        if (population == 0) {
            System.out.println("City: " + cityName);
            System.out.println("Result: City not found or no population data.");
        } else {
            System.out.printf("City: %-25s | Population: %,d%n", cityName, population);
        }

        System.out.println("============================================\n");
    }
}
