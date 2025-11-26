package com.napier.sem.view;

import com.napier.sem.model.Country;
import java.util.List;

public class showCountriesInDescByPopulation {
    public void displayCountries(List<Country> countries) {
        System.out.println("Countries from largest to smallest in population:");
        for (Country c : countries) {
            System.out.printf(
                    "Code: %s | Name: %s | Continent: %s | Region: %s | Population: %,d | Capital: %s%n",
                    c.getCode(), c.getName(), c.getContinent(),
                    c.getRegion(), c.getPopulation(), c.getCapitalName()
            );
        }
    }
}