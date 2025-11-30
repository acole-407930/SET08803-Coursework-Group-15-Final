package com.napier.sem.repository;

import com.napier.sem.model.City;
import java.util.List;

public interface CityRepo {
    List<City> getCitiesInCountryByPopulation(String countryName);

    List<City> getCitiesInDistrictByPopulation(String districtName);

    List<City> getTopNMostPopulatedCitiesInWorld(int n);

    List<City> getCitiesInContinentByPopulation(String continentName);


}
