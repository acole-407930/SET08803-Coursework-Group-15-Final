package com.napier.sem.controller;

import com.napier.sem.model.Region;
import com.napier.sem.repository.RegionRepo;

import java.util.List;

public class RegionController {

    private final RegionRepo regionRepo;

    public RegionController(RegionRepo regionRepo) {this.regionRepo = regionRepo;}

    public List<Region> getRegionCityVsNonCityPopulation() {return regionRepo.getRegionCityVsNonCityPopulation();}
}
