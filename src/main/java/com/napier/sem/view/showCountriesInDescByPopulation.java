package com.napier.sem.view;

import com.napier.sem.model.Country;
import com.napier.sem.util.Reportable;

import java.util.List;

public class showCountriesInDescByPopulation {

    public void displayCountries(List<Country> countries) {

        if (countries == null || countries.isEmpty()) {
            System.out.println("No country data available.");
            return;
        }

        System.out.println("\n=====================================================================================================");
        System.out.println(" COUNTRIES FROM LARGEST TO SMALLEST BY POPULATION");
        System.out.println("=====================================================================================================");

        System.out.printf(
                "%-6s %-45s %-15s %-30s %15s %-20s%n",
                "Code",
                "Country",
                "Continent",
                "Region",
                "Population",
                "Capital"
        );

        System.out.println("-----------------------------------------------------------------------------------------------------" +
                "-------------------------------");

        for (Country c : countries) {
            System.out.printf(
                    "%-6s %-45s %-15s %-30s %,15d %-20s%n",
                    c.getCode(),
                    c.getName(),
                    c.getContinent(),
                    c.getRegion(),
                    c.getPopulation(),
                    c.getCapitalName()
            );
        }

        System.out.println("-----------------------------------------------------------------------------------------------------" +
                "-------------------------------\n");

        Reportable.generateCountryReports(countries, "countriesPopulationDesc.md");
    }
}
