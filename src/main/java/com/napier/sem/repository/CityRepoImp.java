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

    // =========================================================
    // 18) Cities in Country (Largest → Smallest) + Country Name
    // =========================================================
    @Override
    public List<City> getCitiesInCountryByPopulation(String countryName) {
        List<City> cities = new ArrayList<>();

        if (con == null || countryName == null || countryName.trim().isEmpty()) {
            System.out.println("Invalid input or database connection.");
            return cities;
        }

        String sql =
                "SELECT ci.ID, ci.Name AS CityName, ci.CountryCode, ci.District, ci.Population, co.Name AS CountryName " +
                        "FROM city ci " +
                        "JOIN country co ON ci.CountryCode = co.Code " +
                        "WHERE co.Name = ? " +
                        "ORDER BY ci.Population DESC, CityName ASC";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, countryName);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                City city = new City(
                        rs.getInt("ID"),
                        rs.getString("CityName"),
                        rs.getString("CountryCode"),
                        rs.getString("CountryName"),
                        rs.getString("District"),
                        rs.getInt("Population")
                );
                cities.add(city);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving cities by country: " + e.getMessage());
        }

        return cities;
    }

    // =========================================================
    // 19) Cities in District (Largest → Smallest) + Country Name
    // =========================================================
    @Override
    public List<City> getCitiesInDistrictByPopulation(String districtName) {
        List<City> cities = new ArrayList<>();

        if (con == null || districtName == null || districtName.trim().isEmpty()) {
            System.out.println("Invalid input or database connection.");
            return cities;
        }

        String sql =
                "SELECT ci.ID, ci.Name AS CityName, ci.CountryCode, co.Name AS CountryName, ci.District, ci.Population " +
                        "FROM city ci " +
                        "JOIN country co ON ci.CountryCode = co.Code " +
                        "WHERE ci.District = ? " +
                        "ORDER BY ci.Population DESC, CityName ASC";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, districtName);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                City city = new City(
                        rs.getInt("ID"),
                        rs.getString("CityName"),
                        rs.getString("CountryCode"),
                        rs.getString("CountryName"),
                        rs.getString("District"),
                        rs.getInt("Population")
                );
                cities.add(city);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving cities by district: " + e.getMessage());
        }

        return cities;
    }

    // =========================================================
    //  20) Top N Most Populated Cities in the World
    // =========================================================
    @Override
    public List<City> getTopNMostPopulatedCitiesInWorld(int n) {
        List<City> cities = new ArrayList<>();

        if (con == null) {
            System.out.println("Database connection is null.");
            return cities;
        }

        if (n <= 0) {
            System.out.println("N must be greater than 0.");
            return cities;
        }

        String sql =
                "SELECT ci.ID, ci.Name AS CityName, ci.CountryCode, co.Name AS CountryName, " +
                        "ci.District, ci.Population " +
                        "FROM city ci " +
                        "JOIN country co ON ci.CountryCode = co.Code " +
                        "ORDER BY ci.Population DESC, CityName ASC " +
                        "LIMIT ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, n);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                City city = new City(
                        rs.getInt("ID"),
                        rs.getString("CityName"),
                        rs.getString("CountryCode"),
                        rs.getString("CountryName"),
                        rs.getString("District"),
                        rs.getInt("Population")
                );
                cities.add(city);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving top N most populated cities in world: " + e.getMessage());
        }

        return cities;
    }
}
