package com.napier.sem.view;

import com.napier.sem.model.Country;
import com.napier.sem.util.Reportable;

import java.util.List;


public class showTopMostNPopulatedCountriesInNContinent {
    public void displayCountries(List<Country> countries, int N, String continent) {
        System.out.println("\n------------------------------------------------------------\n");
        System.out.println("Top " + N + " Most Populated Countries in " + continent + ":");
        System.out.println("\n --------------------------------------------------------");
        if (countries == null || countries.isEmpty()) {
            System.out.println("No countries found for continent: " + continent);
            return;
        }

        for (Country c : countries) {
            System.out.printf(
                    "Code: %s | Name: %s | Continent: %s | Region: %s | Population: %,d | Capital: %s%n",
                    c.getCode(), c.getName(), c.getContinent(),
                    c.getRegion(), c.getPopulation(), c.getCapitalName()
            );
        }

        //generate the .md report equivalent...
        Reportable.generateCountryReports(countries, "topNMostPopulatedCountriesInContinent.md");

    }
}

