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

    // =========================================================
    //  38) Total Population of a District
    // =========================================================
    @Override
    public long getTotalPopulationOfDistrict(String districtName) {
        long totalPopulation = 0;

        if (con == null || districtName == null || districtName.trim().isEmpty()) {
            System.out.println("Invalid input or database connection.");
            return 0;
        }

        String sql = "SELECT SUM(Population) AS TotalPop FROM city WHERE District = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, districtName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                totalPopulation = rs.getLong("TotalPop");
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving total population of district: " + e.getMessage());
        }

        return totalPopulation;
    // 3) TOP N MOST POPULATED CITIES IN A COUNTRY (NEW)
    // =========================================================
    @Override
    public List<City> getTopNCitiesInCountryByPopulation(String countryName, int n) {
        List<City> cities = new ArrayList<>();

        if (con == null || countryName == null || countryName.trim().isEmpty()) {
            System.out.println("Invalid input or database connection.");
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
                        "WHERE co.Name = ? " +
                        "ORDER BY ci.Population DESC, CityName ASC " +
                        "LIMIT ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, countryName);
            stmt.setInt(2, n);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                cities.add(new City(
                        rs.getInt("ID"),
                        rs.getString("CityName"),
                        rs.getString("CountryCode"),
                        rs.getString("CountryName"),
                        rs.getString("District"),
                        rs.getInt("Population")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving Top N most populated cities in country: " + e.getMessage());
        }

        return cities;
    }

    // Issue #16 - Cities in Continent Population Largest to Smallest
    @Override
    public List<City> getCitiesInContinentByPopulation(String continentName) {
        List<City> cities = new ArrayList<>();

        if (con == null) {
            System.out.println("Database connection is null.");
            return cities;
        }

        if (continentName == null || continentName.trim().isEmpty()) {
            System.out.println("Continent name cannot be null or empty.");
            return cities;
        }

        String sql =
                "SELECT ci.ID, ci.Name AS CityName, ci.CountryCode, co.Name AS CountryName, " +
                        "ci.District, ci.Population " +
                        "FROM city ci " +
                        "JOIN country co ON ci.CountryCode = co.Code " +
                        "WHERE co.Continent = ? " +
                        "ORDER BY ci.Population DESC, CityName ASC";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, continentName.trim());

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
            System.out.println("Error retrieving cities in continent by population: " + e.getMessage());
        }

        return cities;
    }
    // #21 - Top N Most Populated Cities in a Continent Where N is Provided
    @Override
    public List<City> getNCitiesInNContinentByPopulation(String continentName, Integer topN) {
        List<City> cities = new ArrayList<>();

        if (con == null) {
            System.out.println("Database connection is null.");
            return cities;
        }

        if (continentName == null || continentName.trim().isEmpty()) {
            System.out.println("Continent name cannot be null or empty.");
            return cities;
        }

        StringBuilder sql = new StringBuilder(
                "SELECT ci.ID, ci.Name AS CityName, ci.CountryCode, co.Name AS CountryName, " +
                        "ci.District, ci.Population " +
                        "FROM city ci " +
                        "JOIN country co ON ci.CountryCode = co.Code " +
                        "WHERE co.Continent = ? " +
                        "ORDER BY ci.Population DESC, CityName ASC");

        // Add LIMIT clause if topN is provided
        if (topN != null && topN > 0) {
            sql.append(" LIMIT ?");
        }

        try (PreparedStatement stmt = con.prepareStatement(sql.toString())) {
            stmt.setString(1, continentName.trim());

            if (topN != null && topN > 0) {
                stmt.setInt(2, topN);
            }

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
            System.out.println("Error retrieving cities in continent by population: " + e.getMessage());
        }

        return cities;
    }

    @Override
    public List<City> getNCitiesInRegionByPopulation(String regionName, Integer topN) {
        List<City> cities = new ArrayList<>();

        if (con == null) {
            System.out.println("Database connection is null.");
            return cities;
        }

        if (regionName == null || regionName.trim().isEmpty()) {
            System.out.println("Region name cannot be null or empty.");
            return cities;
        }

        StringBuilder sql = new StringBuilder(
                "SELECT ci.ID, ci.Name AS CityName, ci.CountryCode, co.Name AS CountryName, " +
                        "ci.District, ci.Population " +
                        "FROM city ci " +
                        "JOIN country co ON ci.CountryCode = co.Code " +
                        "WHERE co.Region = ? " +
                        "ORDER BY ci.Population DESC, CityName ASC");

        // Add LIMIT clause if topN is provided
        if (topN != null && topN > 0) {
            sql.append(" LIMIT ?");
        }

        try (PreparedStatement stmt = con.prepareStatement(sql.toString())) {
            stmt.setString(1, regionName.trim());

            if (topN != null && topN > 0) {
                stmt.setInt(2, topN);
            }

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
            System.out.println("Error retrieving cities in region by population: " + e.getMessage());
        }

        return cities;
    }


}
