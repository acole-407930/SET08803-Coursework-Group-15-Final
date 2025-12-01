package com.napier.sem.app;

import com.napier.sem.controller.CityController;
import com.napier.sem.repository.CityRepoImp;
import com.napier.sem.util.DBConnection;
import com.napier.sem.repository.CountryRepoImp;
import com.napier.sem.controller.CountryController;
import com.napier.sem.repository.RegionRepoImp;
import com.napier.sem.controller.RegionController;
import com.napier.sem.view.showRegionPopulationCityVsNonCity;


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
        showTopMostNPopulatedCountriesInNContinent topCountriesInContinent = new showTopMostNPopulatedCountriesInNContinent();

        c_view.displayCountries(c_controller.getCountriesByPopulation());                     // use case 9
        continent_view.displayCountries(c_controller.getCountriesFromContinent("Asia"));       // use case 10
        region_view.displayCountries(c_controller.getCountriesFromRegion("Central America"));  // use case 11
        top_N_C_Pop.displayCountries(c_controller.getTopNMostPopulatedCountries(10), 10);
        topCountriesInContinent.displayCountries(c_controller.getTopMostNPopulatedCountriesInNContinent(5, "Asia"), 5, "Asia");

        // ===== CITY CONTROLLER =====
        CityController cityController = new CityController(new CityRepoImp(con));


        ShowCitiesInCountryByPopulation cityView = new ShowCitiesInCountryByPopulation();
        cityView.displayCities(cityController.getCitiesInCountryByPopulation("Japan"), "Japan");// use case 18


        showCitiesInDistrictInDescByPopulation districtView = new showCitiesInDistrictInDescByPopulation();
        districtView.displayCities(cityController.getCitiesInDistrictByPopulation("Rio de Janeiro"), "Rio de Janeiro");// use case 19

        // TOP N IN REGION
        showTopNCountriesInRegionByPopulation regionTopNView = new showTopNCountriesInRegionByPopulation();
        regionTopNView.displayCountries(c_controller.getTopNCountriesInRegionByPopulation("Middle East", 10), "Middle East", 10);


        showtopNCitiesInCountryByPopulation topCitiesInCountryView = new showtopNCitiesInCountryByPopulation();
        topCitiesInCountryView.displayCities(cityController.getTopNCitiesInCountryByPopulation("Myanmar", 10), "Myanmar", 10);

        //Issue #16 - Show Cities In Continent by Population
        showCitiesInContinentByPopulation citiesInContinentByPopulation = new showCitiesInContinentByPopulation(); // Issue #12
        citiesInContinentByPopulation.displayCities(cityController.getCitiesInContinentByPopulation("Asia"), "Asia");

        //Issue #21
        showNCitiesInNContinentByPopulation citiesInNContinentByPopulation = new showNCitiesInNContinentByPopulation();
        citiesInNContinentByPopulation.displayCities(cityController.getNCitiesInNContinentByPopulation("Europe", 3),"Europe",3 ); // Add the missing 'n' parameter - number of cities to show);
        RegionController regionController = new RegionController(new RegionRepoImp(con));
        showRegionPopulationCityVsNonCity regionView = new showRegionPopulationCityVsNonCity();

        regionView.displayRegionPopulationCityVsNonCity(regionController.getRegionCityVsNonCityPopulation());


        db.disconnect(con);
    }
}
