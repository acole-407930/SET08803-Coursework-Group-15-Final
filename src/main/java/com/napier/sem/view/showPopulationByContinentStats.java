package com.napier.sem.view;

import com.napier.sem.model.Population;
import java.util.List;

public class showPopulationByContinentStats {

    public void displayPopulationStats(List<Population> populations) {
        // Validate input
        if (populations == null || populations.isEmpty()) {
            System.out.println("\nError: No population data available.");
            return;
        }

        System.out.println("\n" + "=".repeat(115));
        System.out.println(" POPULATION STATISTICS BY CONTINENT");
        System.out.println("=".repeat(115));

        // Table header
        System.out.printf("%-25s %15s %15s %15s %15s %15s%n",
                "Name of Continent", "Total Population", "In Cities", "Outside Cities", "% In Cities", "% Outside Cities");
        System.out.println("-".repeat(115));

        // Display population statistics for each continent
        for (Population pop : populations) {
            String continent = pop.getContinent() != null ? pop.getContinent() : "Unknown";

            System.out.printf("%-25s %,15d %,15d %,15d %14.1f%% %14.1f%%%n",
                    continent,
                    pop.getTotalPopulation(),
                    pop.getCityPopulation(),
                    pop.getNonCityPopulation(),
                    pop.getCityPopulationPercentage(),
                    pop.getNonCityPopulationPercentage()
            );
        }

        // Display summary with world totals
        displayWorldTotals(populations);

        System.out.println("=".repeat(115));
    }

    private void displayWorldTotals(List<Population> populations) {
        long totalWorldPopulation = 0;
        long totalCityPopulation = 0;
        long totalNonCityPopulation = 0;

        for (Population pop : populations) {
            totalWorldPopulation += pop.getTotalPopulation();
            totalCityPopulation += pop.getCityPopulation();
            totalNonCityPopulation += pop.getNonCityPopulation();
        }

        System.out.println("-".repeat(115));

        double worldCityPercentage = totalWorldPopulation > 0 ?
                Math.round((totalCityPopulation * 100.0 / totalWorldPopulation) * 10.0) / 10.0 : 0;
        double worldNonCityPercentage = totalWorldPopulation > 0 ?
                Math.round((totalNonCityPopulation * 100.0 / totalWorldPopulation) * 10.0) / 10.0 : 0;

        System.out.printf("%-25s %,15d %,15d %,15d %14.1f%% %14.1f%%%n",
                "WORLD TOTAL",
                totalWorldPopulation,
                totalCityPopulation,
                totalNonCityPopulation,
                worldCityPercentage,
                worldNonCityPercentage
        );
    }
}