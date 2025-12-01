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
    public List<City> getCitiesInContinentByPopulation(String continentName) {return cityRepo.getCitiesInContinentByPopulation(continentName);}

    public List<City> getTopNCitiesInCountryByPopulation(String countryName, int n) {return cityRepo.getTopNCitiesInCountryByPopulation(countryName, n);}

    public List<City> getNCitiesInNContinentByPopulation(String continentName, int n) {return cityRepo.getNCitiesInNContinentByPopulation(continentName, n);} }
