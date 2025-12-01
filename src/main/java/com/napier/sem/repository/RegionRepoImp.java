package com.napier.sem.repository;

import com.napier.sem.model.Region;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegionRepoImp implements RegionRepo {

    private final Connection con;

    public RegionRepoImp(Connection con) {
        this.con = con;
    }

    @Override
    public List<Region> getRegionCityVsNonCityPopulation() {
        List<Region> regions = new ArrayList<>();

        if (con == null) {
            System.out.println("Database connection is null.");
            return regions;
        }

        String sql =
                "SELECT " +
                        "    r.region_name, " +
                        "    r.total_population, " +
                        "    IFNULL(c.urban_population, 0) AS urban_population, " +
                        "    (r.total_population - IFNULL(c.urban_population, 0)) AS non_urban_population, " +
                        "    (IFNULL(c.urban_population, 0) / r.total_population) * 100.0 AS urban_percentage, " +
                        "    ((r.total_population - IFNULL(c.urban_population, 0)) / r.total_population) * 100.0 AS non_urban_percentage " +
                        "FROM ( " +
                        "    SELECT Region AS region_name, SUM(Population) AS total_population " +
                        "    FROM country " +
                        "    GROUP BY Region " +
                        ") r " +
                        "LEFT JOIN ( " +
                        "    SELECT co.Region AS region_name, SUM(ci.Population) AS urban_population " +
                        "    FROM country co " +
                        "    JOIN city ci ON ci.CountryCode = co.Code " +
                        "    GROUP BY co.Region " +
                        ") c ON c.region_name = r.region_name " +
                        "ORDER BY r.total_population DESC";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String regionName = rs.getString("region_name");
                long totalPopulation = rs.getLong("total_population");
                long urbanPopulation = rs.getLong("urban_population");
                long nonUrbanPopulation = rs.getLong("non_urban_population");
                double urbanPercentage = rs.getDouble("urban_percentage");
                double nonUrbanPercentage = rs.getDouble("non_urban_percentage");

                // cityName is not used in the table, so we just store a placeholder
                Region region = new Region(
                        regionName,
                        "All Cities",
                        totalPopulation,
                        urbanPopulation,
                        urbanPercentage,
                        nonUrbanPopulation,
                        nonUrbanPercentage
                );

                regions.add(region);
            }

        } catch (SQLException e) {
            System.out.println("Error getting region population report: " + e.getMessage());
        }

        return regions;
    }
}
