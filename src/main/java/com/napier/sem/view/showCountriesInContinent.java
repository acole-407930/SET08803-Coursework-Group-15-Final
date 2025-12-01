package com.napier.sem.view;

import com.napier.sem.model.Country;
import com.napier.sem.util.Reportable;

import java.util.List;

public class showCountriesInContinent {

    public void displayCountries(List<Country> countries) {

        if (countries == null || countries.isEmpty()) {
            System.out.println("No countries found for this continent.");
            return;
        }

        System.out.println("\n==============================================================================================");
        System.out.println(" COUNTRIES IN SELECTED CONTINENT — LARGEST TO SMALLEST POPULATION");
        System.out.println("==============================================================================================");

        System.out.printf(
                "%-6s %-40s %-20s %-25s %15s %-20s%n",
                "Code",
                "Country",
                "Continent",
                "Region",
                "Population",
                "Capital"
        );

        System.out.println("-------------------------------------------------------------------------------------------------------------");

        for (Country c : countries) {
            System.out.printf(
                    "%-6s %-40s %-20s %-25s %,15d %-20s%n",
                    c.getCode(),
                    c.getName(),
                    c.getContinent(),
                    c.getRegion(),
                    c.getPopulation(),
                    c.getCapitalName()
            );
        }

        System.out.println("-------------------------------------------------------------------------------------------------------------\n");

        Reportable.generateCountryReports(countries, "countriesPopulationInSelectedContinent.md");
    }
}
