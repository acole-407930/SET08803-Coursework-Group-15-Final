package com.napier.sem.app;

import com.napier.sem.util.DBConnection;
import com.napier.sem.repository.CountryRepoImp;
import com.napier.sem.controller.CountryController;
import com.napier.sem.view.showCountriesInDescByPopulation;
import java.sql.Connection;

public class App {
    public static void main(String[] args) {

        DBConnection db = new DBConnection();

        Connection con = db.connect();

        CountryController c_controller = new CountryController(new CountryRepoImp(con));
        showCountriesInDescByPopulation c_view = new showCountriesInDescByPopulation();

        c_view.displayCountries(c_controller.getCountriesByPopulation());

        db.disconnect(con);
    }
}