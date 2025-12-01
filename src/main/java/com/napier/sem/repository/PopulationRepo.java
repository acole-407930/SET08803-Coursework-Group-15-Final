package com.napier.sem.repository;

import com.napier.sem.model.Country;
import com.napier.sem.model.Population;
import java.util.List;

public interface PopulationRepo {

    List<Population> getPopulationByContinentStats();
}
