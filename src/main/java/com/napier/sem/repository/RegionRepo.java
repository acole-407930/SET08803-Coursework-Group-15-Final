package com.napier.sem.repository;

import com.napier.sem.model.Region;
import java.util.List;

public interface RegionRepo {


    List<Region> getRegionCityVsNonCityPopulation();
}
