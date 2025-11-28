package com.napier.sem.repository;

import com.napier.sem.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityRepoImp implements CityRepo {

    private final Connection con;

    public CityRepoImp(Connection con) {
        this.con = con;
    }

    @Override
    public List<City> getCitiesInCountryByPopulation(String countryName) {
        List<City> cities = new ArrayList<>();

        // Safety checks
        if (con == null) {
            System.out.println("Database connection is null.");
            return cities;
        }

        if (countryName == null || countryName.trim().isEmpty()) {
            System.out.println("Country name cannot be null or empty.");
            return cities;
        }

        // Use normal string concatenation instead of """ text block """
        String sql =
                "SELECT ci.ID, ci.Name AS City, ci.CountryCode, ci.District, ci.Population " +
                        "FROM city ci " +
                        "JOIN country co ON ci.CountryCode = co.Code " +
                        "WHERE co.Name = ? " +
                        "ORDER BY ci.Population DESC, ci.Name ASC;";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, countryName);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                City city = new City(
                        rs.getInt("ID"),
                        rs.getString("City"),
                        rs.getString("CountryCode"),
                        rs.getString("District"),
                        rs.getInt("Population")
                );
                cities.add(city);
            }

        } catch (SQLException e) {
            System.out.println("SQL Query Failed: " + e.getMessage());
        }

        return cities;
    }
}
