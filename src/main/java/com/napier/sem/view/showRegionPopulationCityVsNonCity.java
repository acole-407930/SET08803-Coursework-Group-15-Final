package com.napier.sem.view;

import com.napier.sem.model.Region;
import java.util.List;

public class showRegionPopulationCityVsNonCity {

    public void displayRegionPopulationCityVsNonCity(List<Region> regions) {

        if (regions == null || regions.isEmpty()) {
            System.out.println("No region population data available.");
            return;
        }

        System.out.println("\n==============================================================================================");
        System.out.println(" POPULATION LIVING IN CITIES VS NOT LIVING IN CITIES – BY REGION");
        System.out.println("==============================================================================================");

        System.out.printf(
                "%-30s %18s %18s %18s %10s %12s%n",
                "Region",
                "Total Population",
                "City Population",
                "Non-City Population",
                "City %",
                "Non-City %"
        );
        System.out.println("--------------------------------------------------------------------------------------------------------------");

        for (Region r : regions) {
            System.out.printf(
                    "%-30s %,18d %,18d %,18d %9.2f%% %11.2f%%%n",
                    r.getRegionName(),
                    r.getTotalCityPopulation(),
                    r.getUrbanPopulation(),
                    r.getNonUrbanPopulation(),
                    r.getUrbanPercentage(),
                    r.getNonUrbanPercentage()
            );
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------\n");
    }
}
