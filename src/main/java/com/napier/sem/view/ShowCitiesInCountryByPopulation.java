package com.napier.sem.view;

import com.napier.sem.model.City;
import com.napier.sem.util.Reportable;

import java.util.List;

public class ShowCitiesInCountryByPopulation {

    public void displayCities(List<City> cities, String countryName) {
        System.out.println("\n------------------------------------------------------------");
        System.out.println(" CITIES IN " + countryName.toUpperCase() + " (Largest → Smallest Population)");
        System.out.println("------------------------------------------------------------");

        System.out.printf("%-25s %-20s %-20s %15s%n",
                "City", "Country", "District", "Population");
        System.out.println("--------------------------------------------------------------------------");

        for (City c : cities) {
            System.out.printf("%-25s %-20s %-20s %,15d%n",
                    c.getName(),
                    c.getCountryName(),
                    c.getDistrict(),
                    c.getPopulation()
            );
        }

        System.out.println("------------------------------------------------------------\n");

        Reportable.generateCitiesReport(cities, "citiesPopulationInCountryDesc");
    }
}