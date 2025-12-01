package com.napier.sem.repository;

import com.napier.sem.model.Population;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PopulationRepoImp implements PopulationRepo {

        private final Connection con;

        public PopulationRepoImp(Connection con) {this.con = con;}

    @Override
    public List<Population> getPopulationByContinentStats() {
        List<Population> populationList = new ArrayList<>();

        if (con == null) {
            System.out.println("Database connection is null.");
            return populationList;
        }

        // SQL query - only get the 4 fields that match your constructor
        String sql = "SELECT " +
                "co.Continent, " +
                "SUM(co.Population) AS total_population, " +
                "COALESCE(SUM(ci.Population), 0) AS city_population, " +
                "(SUM(co.Population) - COALESCE(SUM(ci.Population), 0)) AS non_city_population " +
                "FROM country co " +
                "LEFT JOIN city ci ON co.Code = ci.CountryCode " +
                "GROUP BY co.Continent " +
                "ORDER BY total_population DESC";

        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Create Population object with 4 parameters (matching your constructor)
                Population population = new Population(
                        rs.getString("Continent"),
                        rs.getLong("total_population"),
                        rs.getLong("city_population"),
                        rs.getLong("non_city_population")
                );
                populationList.add(population);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving population statistics by continent: " + e.getMessage());
        }

        return populationList;
    }
}
