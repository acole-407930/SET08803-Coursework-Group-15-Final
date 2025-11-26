package com.napier.sem.controller;

import com.napier.sem.model.Country;
import com.napier.sem.repository.CountryRepo;
import java.util.List;

public class CountryController {
    private final CountryRepo countryRepo;

    public CountryController(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    public List<Country> getCountriesByPopulation() {
        return countryRepo.getAllCountriesOrderByPopulationDesc();
    }
}