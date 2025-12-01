package com.napier.sem.repository;

import com.napier.sem.model.Country;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryRepoImp implements CountryRepo {

    private final Connection con;

    public CountryRepoImp(Connection con) {
        this.con = con;
    }

    @Override
    public List<Country> getAllCountriesOrderByPopulationDesc() {
        String sql = "SELECT co.Code, co.Name AS CountryName, co.Continent, co.Region, co.Population, ci.Name AS CapitalName " +
                "FROM country co LEFT JOIN city ci ON co.Capital = ci.ID " +
                "ORDER BY co.Population DESC, CountryName ASC";
        return executeQuery(sql, null);
    }

    @Override
    public List<Country> getAllCountriesInContinentOrderByPopulationDesc(String continent) {
        String sql = "SELECT co.Code, co.Name AS CountryName, co.Continent, co.Region, co.Population, ci.Name AS CapitalName " +
                "FROM country co LEFT JOIN city ci ON co.Capital = ci.ID " +
                "WHERE co.Continent = ? " +
                "ORDER BY co.Population DESC, CountryName ASC";
        return executeQuery(sql, continent);
    }

    @Override
    public List<Country> getAllCountriesPopulationFromLargestToSmallestByRegion(String region) {
        String sql = "SELECT co.Code, co.Name AS CountryName, co.Continent, co.Region, co.Population, ci.Name AS CapitalName " +
                "FROM country co LEFT JOIN city ci ON co.Capital = ci.ID " +
                "WHERE co.Region = ? " +
                "ORDER BY co.Population DESC, CountryName ASC";
        return executeQuery(sql, region);
    }


    // Top N (Global)
    public List<Country> getTopNMostPopulatedCountries(int N) {
        String sql = "SELECT co.Code, co.Name AS CountryName, co.Continent, co.Region, co.Population, ci.Name AS CapitalName " +
                "FROM country co LEFT JOIN city ci ON co.Capital = ci.ID " +
                "ORDER BY co.Population DESC, CountryName ASC " +
                "LIMIT ?";
        return executeNQuery(sql, N);
    }


    // Top N in a REGION (NEW)
    public List<Country> getTopNCountriesInRegionByPopulation(String region, int N) {
        String sql = "SELECT co.Code, co.Name AS CountryName, co.Continent, co.Region, co.Population, ci.Name AS CapitalName " +
                "FROM country co LEFT JOIN city ci ON co.Capital = ci.ID " +
                "WHERE co.Region = ? " +
                "ORDER BY co.Population DESC, CountryName ASC " +
                "LIMIT ?";

        return executeRegionNQuery(sql, region, N);
    }

    // Top N Countries in N Continent
    @Override
    // Issue #12 - Assigned to Zoe Villanueva
    public List<Country> getTopMostNPopulatedCountriesInNContinent(int N, String continent) {
        String sql = "SELECT co.Code, co.Name AS CountryName, co.Continent, co.Region, co.Population, ci.Name AS CapitalName " +
                "FROM country co LEFT JOIN city ci ON co.Capital = ci.ID " +
                "WHERE co.Continent = ? " +
                "ORDER BY co.Population DESC, CountryName ASC " +
                "LIMIT " + N;  // Directly embed N in the SQL
        return executeQuery(sql, continent);
    }


    private List<Country> executeQuery(String sql, String field) {
        List<Country> countries = new ArrayList<>();
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            if (field != null) {
                pstmt.setString(1, field);
            }
            ResultSet rset = pstmt.executeQuery();
            while (rset.next()) {
                Country cnty = new Country();
                cnty.setCode(rset.getString("Code"));
                cnty.setName(rset.getString("CountryName"));
                cnty.setContinent(rset.getString("Continent"));
                cnty.setRegion(rset.getString("Region"));
                cnty.setPopulation(rset.getInt("Population"));
                cnty.setCapitalName(rset.getString("CapitalName"));
                countries.add(cnty);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching countries: " + e.getMessage());
        }
        return countries;
    }

    private List<Country> executeNQuery(String sql, int N) {

        if (N <= 0) {
            System.out.println("Value of N should be more than zero (0)");
            return new ArrayList<>();
        }

        List<Country> countries = new ArrayList<>();
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, N);
            ResultSet rset = pstmt.executeQuery();
            while (rset.next()) {
                Country cnty = new Country();
                cnty.setCode(rset.getString("Code"));
                cnty.setName(rset.getString("CountryName"));
                cnty.setContinent(rset.getString("Continent"));
                cnty.setRegion(rset.getString("Region"));
                cnty.setPopulation(rset.getInt("Population"));
                cnty.setCapitalName(rset.getString("CapitalName"));
                countries.add(cnty);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching countries: " + e.getMessage());
        }
        return countries;
    }

    private List<Country> executeRegionNQuery(String sql, String region, int N) {

        List<Country> countries = new ArrayList<>();

        if (region == null || region.trim().isEmpty()) {
            System.out.println("Region cannot be null or empty.");
            return countries;
        }

        if (N <= 0) {
            System.out.println("Value of N should be more than zero (0)");
            return countries;
        }

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, region);
            pstmt.setInt(2, N);

            ResultSet rset = pstmt.executeQuery();
            while (rset.next()) {
                Country cnty = new Country();
                cnty.setCode(rset.getString("Code"));
                cnty.setName(rset.getString("CountryName"));
                cnty.setContinent(rset.getString("Continent"));
                cnty.setRegion(rset.getString("Region"));
                cnty.setPopulation(rset.getInt("Population"));
                cnty.setCapitalName(rset.getString("CapitalName"));
                countries.add(cnty);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching countries: " + e.getMessage());
        }

        return countries;
    }
}
