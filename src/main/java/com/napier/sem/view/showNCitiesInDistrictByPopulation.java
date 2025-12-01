package com.napier.sem.view;

import com.napier.sem.model.City;
import java.util.List;

public class showNCitiesInDistrictByPopulation {

    public void displayCities(List<City> cities, String districtName, int n) {
        System.out.println("==============================================================================================");
        System.out.println(" TOP " + n + " MOST POPULATED CITIES IN " + districtName.toUpperCase());
        System.out.println("==============================================================================================");

        System.out.printf("%-30s %-25s %-30s %15s%n",
                "City", "Country", "District", "Population");
        System.out.println("----------------------------------------------------------------------------------------------");

        if (cities == null || cities.isEmpty()) {
            System.out.println("No cities found for this district.");
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