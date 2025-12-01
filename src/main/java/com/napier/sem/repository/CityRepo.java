package com.napier.sem.repository;

import com.napier.sem.model.City;
import java.util.List;

public interface CityRepo {
    List<City> getCitiesInCountryByPopulation(String countryName);

    List<City> getCitiesInDistrictByPopulation(String districtName);

    List<City> getTopNMostPopulatedCitiesInWorld(int n);

    long getTotalPopulationOfDistrict(String districtName);

    List<City> getCitiesInContinentByPopulation(String continentName);

    List<City> getTopNCitiesInCountryByPopulation(String countryName, int n);

    List<City> getNCitiesInNContinentByPopulation(String continentName, Integer topN);

    List<City> getNCitiesInRegionByPopulation(String regionName, Integer topN);

    List<City> getNCitiesInDistrictByPopulation(String districtName, Integer topN);

    long getTotalPopulationOfCity(String cityName);
}


