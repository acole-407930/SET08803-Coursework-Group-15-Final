package com.napier.sem.view;

import com.napier.sem.model.Country;
import java.util.List;

public class showTopNCountriesInRegionByPopulation {

    public void displayCountries(List<Country> countries, String regionName, int n) {
        System.out.println("==============================================================================================");
        System.out.println(" TOP " + n + " MOST POPULATED COUNTRIES IN REGION: " + regionName.toUpperCase());
        System.out.println("==============================================================================================");

        System.out.printf("%-5s %-35s %-15s %-25s %15s %-25s%n",
                "Code", "Country", "Continent", "Region", "Population", "Capital");
        System.out.println("----------------------------------------------------------------------------------------------");

        if (countries == null || countries.isEmpty()) {
            System.out.println("No countries found for this region.");
            System.out.println("==============================================================================================");
            return;
        }

        for (Country c : countries) {
            System.out.printf("%-5s %-35s %-15s %-25s %,15d %-25s%n",
                    c.getCode(),
                    c.getName(),
                    c.getContinent(),
                    c.getRegion(),
                    c.getPopulation(),
                    c.getCapitalName() != null ? c.getCapitalName() : "N/A"
            );
        }

        System.out.println("==============================================================================================");
    }
}
