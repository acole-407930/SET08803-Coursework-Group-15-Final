package com.napier.sem.controller;

import com.napier.sem.model.Country;
import com.napier.sem.repository.CountryRepo;
import java.util.List;

public class CountryController
{
    private final CountryRepo countryRepo;

    public CountryController(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    public List<Country> getCountriesByPopulation() {
        return countryRepo.getAllCountriesOrderByPopulationDesc();
    }

    public List<Country> getCountriesFromContinent(String continent) {return countryRepo.getAllCountriesInContinentOrderByPopulationDesc(continent); }

    public List<Country> getCountriesFromRegion(String region) {return countryRepo.getAllCountriesPopulationFromLargestToSmallestByRegion(region); }

    public List<Country> getTopNMostPopulatedCountries(int N) {return countryRepo.getTopNMostPopulatedCountries(N);}

    public List<Country> getTopNCountriesInRegionByPopulation(String regionName, int n) {return countryRepo.getTopNCountriesInRegionByPopulation(regionName, n);}

}
