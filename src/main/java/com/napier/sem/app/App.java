package com.napier.sem.app;

import com.napier.sem.util.DBConnection;
import com.napier.sem.repository.CountryRepoImp;
import com.napier.sem.controller.CountryController;

//views
import com.napier.sem.view.showCountriesInDescByPopulation;
import com.napier.sem.view.showCountriesInContinent;
import com.napier.sem.view.showCountriesFromRegion;
import com.napier.sem.view.showTopNCountriesPopulation;


import java.sql.Connection;

public class App {
    public static void main(String[] args) {

        DBConnection db = new DBConnection();

        Connection con = db.connect();

        CountryController c_controller = new CountryController(new CountryRepoImp(con));

        //Views
        showCountriesInDescByPopulation c_view = new showCountriesInDescByPopulation();
        showCountriesInContinent continent_view = new showCountriesInContinent();
        showCountriesFromRegion region_view = new showCountriesFromRegion();
        showTopNCountriesPopulation top_N_C_Pop = new showTopNCountriesPopulation();

        c_view.displayCountries(c_controller.getCountriesByPopulation()); //use case 9
        continent_view.displayCountries(c_controller.getCountriesFromContinent("Asia")); //use case 10
        region_view.displayCountries(c_controller.getCountriesFromRegion("Central America")); //use case 11
        top_N_C_Pop.displayCountries(c_controller.getTopNMostPopulatedCountries(10), 10);

        db.disconnect(con);
    }
}