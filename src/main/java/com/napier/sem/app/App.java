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

        // ===== COUNTRY VIEWS =====
        showCountriesInDescByPopulation c_view = new showCountriesInDescByPopulation();
        showCountriesInContinent continent_view = new showCountriesInContinent();
        showCountriesFromRegion region_view = new showCountriesFromRegion();
        showTopNCountriesPopulation top_N_C_Pop = new showTopNCountriesPopulation();
        showTopMostNPopulatedCountriesInNContinent top_N_Countries_in_Continent = new showTopMostNPopulatedCountriesInNContinent(); // Issue #12

        c_view.displayCountries(c_controller.getCountriesByPopulation()); // use case 9

        continent_view.displayCountries(c_controller.getCountriesFromContinent("Asia")); // use case 10

        region_view.displayCountries(c_controller.getCountriesFromRegion("Central America")); // use case 11

        top_N_C_Pop.displayCountries(c_controller.getTopNMostPopulatedCountries(10), 10);

        top_N_Countries_in_Continent.displayCountries(c_controller.getTopMostNPopulatedCountriesInNContinent(5, "Asia"), 5, "Asia");// Issue #12



        // ===== CITY CONTROLLER =====
        CityController cityController = new CityController(new CityRepoImp(con));

        // ===== CITIES IN COUNTRY (EXISTING) =====
        ShowCitiesInCountryByPopulation cityView = new ShowCitiesInCountryByPopulation();
        cityView.displayCities(
                cityController.getCitiesInCountryByPopulation("Japan"),
                "Japan"
        );


        showCitiesInDistrictInDescByPopulation districtView = new showCitiesInDistrictInDescByPopulation();


        districtView.displayCities(cityController.getCitiesInDistrictByPopulation("Rio de Janeiro"), "Rio de Janeiro");

        db.disconnect(con);
    }
}
