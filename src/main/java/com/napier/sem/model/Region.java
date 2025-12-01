package com.napier.sem.model;

public class Region {

    private String regionName;
    private String cityName;
    private long totalCityPopulation;      // was int
    private long urbanPopulation;          // was int
    private double urbanPercentage;
    private long nonUrbanPopulation;       // was int
    private double nonUrbanPercentage;

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
