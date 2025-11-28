package com.napier.sem.view;

import com.napier.sem.model.City;
import java.util.List;

public class ShowCitiesInCountryByPopulation {

    public void displayCities(List<City> cities, String countryName) {
        System.out.println("\n------------------------------------------------------------");
        System.out.println(" CITIES IN " + countryName.toUpperCase() + " (Largest → Smallest Population)");
        System.out.println("------------------------------------------------------------");

        for (City c : cities) {
            System.out.printf(
                    "City: %-25s | District: %-15s | Code: %-5s | Population: %,d%n",
                    c.getName(), c.getDistrict(), c.getCountryCode(), c.getPopulation()
            );
        }

        System.out.println("------------------------------------------------------------\n");
    }
}
