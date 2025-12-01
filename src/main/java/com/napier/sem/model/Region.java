package com.napier.sem.model;

public class Region {
    private final String regionName;
    private final String cityName;
    private final long totalCityPopulation;
    private final long urbanPopulation;
    private final double urbanPercentage;
    private final long nonUrbanPopulation;
    private final double nonUrbanPercentage;

    public Region(String regionName,
                  String cityName,
                  long totalCityPopulation,
                  long urbanPopulation,
                  double urbanPercentage,
                  long nonUrbanPopulation,
                  double nonUrbanPercentage) {

        this.regionName = regionName;
        this.cityName = cityName;
        this.totalCityPopulation = totalCityPopulation;
        this.urbanPopulation = urbanPopulation;
        this.urbanPercentage = urbanPercentage;
        this.nonUrbanPopulation = nonUrbanPopulation;
        this.nonUrbanPercentage = nonUrbanPercentage;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getCityName() {
        return cityName;
    }

    public long getTotalCityPopulation() {
        return totalCityPopulation;
    }

    public long getUrbanPopulation() {
        return urbanPopulation;
    }

    public double getUrbanPercentage() {
        return urbanPercentage;
    }

    public long getNonUrbanPopulation() {
        return nonUrbanPopulation;
    }

    public double getNonUrbanPercentage() {
        return nonUrbanPercentage;
    }
}
