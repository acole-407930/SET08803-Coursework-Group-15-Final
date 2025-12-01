package com.napier.sem.view;

import com.napier.sem.model.City;
import com.napier.sem.util.Reportable;

import java.util.List;

public class showCitiesInContinentByPopulation {

    public void displayCities(List<City> cities, String continentName) {
        System.out.println("==============================================================================================");
        System.out.println(" CITIES IN " + continentName.toUpperCase() + " CONTINENT (Largest → Smallest Population)");
        System.out.println("==============================================================================================");

        System.out.printf("%-30s %-25s %-20s %15s%n",
                "City", "Country", "District", "Population");
        System.out.println("----------------------------------------------------------------------------------------------");

        if (cities == null || cities.isEmpty()) {
            System.out.println("No cities found for " + continentName + " continent.");
            System.out.println("==============================================================================================");
            return;
        }

        for (City c : cities) {
            System.out.printf("%-30s %-25s %-20s %,15d%n",
                    c.getName(),
                    c.getCountryName(),
                    c.getDistrict(),
                    c.getPopulation()
            );
        }

        System.out.println("==============================================================================================");

        Reportable.generateCitiesReport(cities, "citiesPopulationInContinentDesc");
    }
}