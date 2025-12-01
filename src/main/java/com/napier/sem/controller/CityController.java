package com.napier.sem.controller;

import com.napier.sem.model.City;
import com.napier.sem.repository.CityRepo;

import java.util.List;

public class CityController {

    private final CityRepo cityRepo;

    public CityController(CityRepo cityRepo) {this.cityRepo = cityRepo;}

    public List<City> getCitiesInCountryByPopulation(String countryName) {return cityRepo.getCitiesInCountryByPopulation(countryName);}

    public List<City> getCitiesInDistrictByPopulation(String districtName) {return cityRepo.getCitiesInDistrictByPopulation(districtName);}

    public List<City> getTopNMostPopulatedCitiesInWorld(int n) {return cityRepo.getTopNMostPopulatedCitiesInWorld(n);}

    public long getTotalPopulationOfDistrict(String districtName) {return cityRepo.getTotalPopulationOfDistrict(districtName);
    }

}
