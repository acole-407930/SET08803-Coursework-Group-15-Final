package com.napier.sem.controller;

import com.napier.sem.model.Population;
import com.napier.sem.repository.PopulationRepo;
import com.napier.sem.repository.PopulationRepo;

import java.util.List;

public class PopulationController {

    private final PopulationRepo populationRepo;

    public PopulationController(PopulationRepo regionRepo) {this.populationRepo = regionRepo;}

    public List<Population> getPopulationByContinentStats() {return populationRepo.getPopulationByContinentStats();}




}
