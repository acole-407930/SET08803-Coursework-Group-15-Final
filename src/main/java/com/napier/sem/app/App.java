package com.napier.sem.app;

import com.napier.sem.controller.CityController;
import com.napier.sem.repository.CityRepoImp;
import com.napier.sem.util.DBConnection;
import com.napier.sem.repository.CountryRepoImp;
import com.napier.sem.controller.CountryController;

//views
import com.napier.sem.view.*;


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

        // ===================== CITY: countries (already in your code) =====================
        CityController cityController = new CityController(new CityRepoImp(con));
        ShowCitiesInCountryByPopulation cityView = new ShowCitiesInCountryByPopulation();

        cityView.displayCities(
                cityController.getCitiesInCountryByPopulation("Japan"),
                "Japan"
        );

        // ===================== CITY: NEW - cities in a DISTRICT =====================
        // This is the ONLY new part added
        showCitiesInDistrictByPopulation districtView = new showCitiesInDistrictByPopulation();

        // Change this to a district that exists in your DB, e.g. "California"


        districtView.displayCities(cityController.getCitiesInDistrictByPopulation("California"),
                "california");

        db.disconnect(con);
    }
}
