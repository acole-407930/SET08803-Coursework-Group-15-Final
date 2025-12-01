package com.napier.sem.view;

import com.napier.sem.model.City;
import java.util.List;

public class showNCitiesInNContinentByPopulation {

    public void displayCities(List<City> cities, String continentName, int n) {
        // Validate inputs
        if (continentName == null || continentName.trim().isEmpty()) {
            System.out.println("Error: Continent name cannot be null or empty.");
            return;
        }

        if (n <= 0) {
            System.out.println("Error: Number of cities (N) must be greater than 0.");
            return;
        }

        System.out.println("\n" + "=".repeat(120));
        System.out.println(" TOP " + n + " MOST POPULATED CITIES IN " + continentName.toUpperCase());
        System.out.println("=".repeat(120));

        // Table header
        System.out.printf("%-4s %-25s %-20s %-25s %-20s %15s%n",
                "Rank", "City Name", "Country", "District", "Continent", "Population");
        System.out.println("-".repeat(120));

        if (cities == null || cities.isEmpty()) {
            System.out.println("No cities found for continent: " + continentName);
            System.out.println("=".repeat(120));
            return;
        }

        // Display cities with ranking
        int displayCount = Math.min(cities.size(), n);

        for (int i = 0; i < displayCount; i++) {
            City city = cities.get(i);

            // Handle potential null values
            String cityName = city.getName() != null ? city.getName() : "N/A";
            String country = city.getCountryName() != null ? city.getCountryName() : "N/A";
            String district = city.getDistrict() != null ? city.getDistrict() : "N/A";
            int population = city.getPopulation();

            // Display city information
            System.out.printf("%-4d %-25s %-20s %-25s %-20s %,15d%n",
                    i + 1,
                    truncateString(cityName, 24),
                    truncateString(country, 19),
                    truncateString(district, 24),
                    truncateString(continentName, 19),
                    population
            );
        }

        System.out.println("=".repeat(120));
    }

    private String truncateString(String str, int maxLength) {
        if (str == null) return "N/A";
        if (str.length() <= maxLength) return str;
        return str.substring(0, maxLength - 3) + "...";
    }
}