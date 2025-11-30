package com.napier.sem.view;

import com.napier.sem.model.City;
import java.util.List;

public class showTopNMostPopulatedCitiesInWorld {

    public void displayCities(List<City> cities, int n) {
        System.out.println("==============================================================================================");
        System.out.println(" TOP " + n + " MOST POPULATED CITIES IN THE WORLD");
        System.out.println("==============================================================================================");

        System.out.printf("%-30s %-25s %-20s %15s%n",
                "City", "Country", "District", "Population");
        System.out.println("----------------------------------------------------------------------------------------------");

        if (cities == null || cities.isEmpty()) {
            System.out.println("No cities found.");
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
    }
}
