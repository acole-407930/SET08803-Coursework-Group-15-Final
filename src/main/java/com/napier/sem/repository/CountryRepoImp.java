package com.napier.sem.repository;
import com.napier.sem.model.Country;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryRepoImp implements CountryRepo{

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
    public List<Country> getAllCountriesInContinentOrderByPopulationDesc(String continent){
        String sql = "SELECT co.Code, co.Name AS CountryName, co.Continent, co.Region, co.Population, ci.Name AS CapitalName " +
                "FROM country co LEFT JOIN city ci ON co.Capital = ci.ID " +
                "WHERE co.Continent = ? " +
                "ORDER BY co.Population DESC, CountryName ASC";
        return executeQuery(sql, continent);
    }

    private List<Country> executeQuery(String sql, String continent) {
        List<Country> countries = new ArrayList<>();
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            if (continent != null) pstmt.setString(1, continent);
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
