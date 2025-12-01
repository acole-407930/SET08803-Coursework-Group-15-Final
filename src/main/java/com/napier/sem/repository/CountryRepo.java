package com.napier.sem.repository;

import com.napier.sem.model.Country;
import java.util.List;

public interface CountryRepo
{
    List<Country> getAllCountriesOrderByPopulationDesc();
    List<Country> getAllCountriesInContinentOrderByPopulationDesc(String continent);
    List<Country> getAllCountriesPopulationFromLargestToSmallestByRegion(String region);
    List<Country> getTopNMostPopulatedCountries(int N);
    List<Country> getTopNCountriesInRegionByPopulation(String regionName, int n);
    List<Country> getTopMostNPopulatedCountriesInNContinent(int N, String continent);
    long getTotalPopulationOfCountry(String countryName);
}
