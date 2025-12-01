package com.napier.sem.view;

import com.napier.sem.model.Country;
import com.napier.sem.util.Reportable;

import java.util.List;

public class showTopNCountriesPopulation {
    public void displayCountries(List<Country> countries, int N) {
        System.out.println("Top " + N + " Countries Population in the world:");
        for (Country c : countries) {
            System.out.printf(
                    "Code: %s | Name: %s | Continent: %s | Region: %s | Population: %,d | Capital: %s%n",
                    c.getCode(), c.getName(), c.getContinent(),
                    c.getRegion(), c.getPopulation(), c.getCapitalName()
            );
        }

        Reportable.generateCountryReports(countries, "topNCountriesPopulatedInWorld.md");
    }
}
