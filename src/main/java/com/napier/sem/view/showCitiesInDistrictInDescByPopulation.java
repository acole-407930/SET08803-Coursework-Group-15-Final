package com.napier.sem.view;

import com.napier.sem.model.City;
import java.util.List;

public class showCitiesInDistrictInDescByPopulation {

    public void displayCities(List<City> cities, String districtName) {
        System.out.println("========================================================");
        System.out.println(" Cities in District: " + districtName + " (Largest → Smallest Population)");
        System.out.println("========================================================");

        System.out.printf("%-25s %-20s %-20s %15s%n",
                "City", "Country", "District", "Population");
        System.out.println("--------------------------------------------------------------------------");

        if (cities == null || cities.isEmpty()) {
            System.out.println("No cities found for this district.");
            System.out.println("========================================================");
            return;
        }

        for (City c : cities) {
            System.out.printf("%-25s %-20s %-20s %,15d%n",
                    c.getName(),
                    c.getCountryName(),
                    c.getDistrict(),
                    c.getPopulation());
        }

        System.out.println("========================================================");
    }
}
