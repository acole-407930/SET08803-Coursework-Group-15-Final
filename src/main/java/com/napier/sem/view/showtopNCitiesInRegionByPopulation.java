package com.napier.sem.view;

import com.napier.sem.model.City;
import java.util.List;

public class showtopNCitiesInRegionByPopulation {

// Issue #22

    public void displayCities(List<City> cities, String regionName, int n) {
        System.out.println("==============================================================================================");
        System.out.println(" TOP " + n + " MOST POPULATED CITIES IN " + regionName.toUpperCase());
        System.out.println("==============================================================================================");

        System.out.printf("%-30s %-25s %-30s %15s%n",
                "City", "Country", "District", "Population");
        System.out.println("----------------------------------------------------------------------------------------------");

        if (cities == null || cities.isEmpty()) {
            System.out.println("No cities found for this region.");
            System.out.println("==============================================================================================");
            return;
        }

        for (City c : cities) {
            System.out.printf("%-30s %-25s %-20s %,15d%n",
                    c.getName(),          // City Name
                    c.getCountryName(),   // Country Name
                    c.getDistrict(),      // District
                    c.getPopulation()     // Population
            );
        }

        System.out.println("==============================================================================================");
    }
}