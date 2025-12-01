package com.napier.sem.model;

public class Population {
    private String continent;
    private long totalPopulation;
    private long cityPopulation;
    private long nonCityPopulation;

    // Constructors
    public Population() {}

    public Population(String continent, long totalPopulation,
                      long cityPopulation, long nonCityPopulation) {
        this.continent = continent;
        this.totalPopulation = totalPopulation;
        this.cityPopulation = cityPopulation;
        this.nonCityPopulation = nonCityPopulation;
    }

    // Getters and Setters
    public String getContinent() { return continent; }
    public void setContinent(String continent) { this.continent = continent; }

    public long getTotalPopulation() { return totalPopulation; }
    public void setTotalPopulation(long totalPopulation) { this.totalPopulation = totalPopulation; }

    public long getCityPopulation() { return cityPopulation; }
    public void setCityPopulation(long cityPopulation) { this.cityPopulation = cityPopulation; }

    public long getNonCityPopulation() { return nonCityPopulation; }
    public void setNonCityPopulation(long nonCityPopulation) { this.nonCityPopulation = nonCityPopulation; }

    // Helper methods for percentage calculation
    public double getCityPopulationPercentage() {
        if (totalPopulation == 0) return 0;
        return Math.round((cityPopulation * 100.0 / totalPopulation) * 100.0) / 100.0;
    }

    public double getNonCityPopulationPercentage() {
        if (totalPopulation == 0) return 0;
        return Math.round((nonCityPopulation * 100.0 / totalPopulation) * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return String.format("Population{continent='%s', total=%,d, city=%,d (%.1f%%), nonCity=%,d (%.1f%%)}",
                continent, totalPopulation, cityPopulation, getCityPopulationPercentage(),
                nonCityPopulation, getNonCityPopulationPercentage());
    }
}