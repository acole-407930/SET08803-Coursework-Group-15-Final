package com.napier.sem.repository;

import com.napier.sem.model.Country;
import java.util.List;

public interface CountryRepo {
    List<Country> getAllCountriesOrderByPopulationDesc();
}

