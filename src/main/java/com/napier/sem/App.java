package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public void displayCountriesPopulationFromContinentFromLargestToSmallest(String continent){
        try {
            //List of country objects
            List<Country> countries = new ArrayList<>();

            //create an SQL statement
            Statement stmt = con.createStatement();

            //Query
            String strSelect = "SELECT " +
                                    "co.Code, " +
                                    "co.Name AS CountryName, " +
                                    "co.Continent, " +
                                    "co.Region, " +
                                    "co.Population, " +
                                    "ci.Name AS CapitalName " +
                                "FROM " +
                                    "country co " +
                                "LEFT JOIN " +
                                    "city ci " +
                                "ON " +
                                    "co.Capital = ci.ID " +
                                "WHERE " +
                                    "co.Continent ='" + continent + "' " +
                                " Order By " +
                                    "Population Desc;" +
                                    "CountryName ASC";

            ResultSet rset = stmt.executeQuery(strSelect);

            // Iterate through all rows
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

            // Display results
            System.out.println("Countries from largest to smallest in population:");

            for (Country country : countries) {
                System.out.printf(
                        "Code: %s | Name: %s | Continent: %s | Region: %s | Population: %,d | Capital: %s%n",
                        country.getCode(),
                        country.getName(),
                        country.getContinent(),
                        country.getRegion(),
                        country.getPopulation(),
                        country.getCapitalName()
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Failed to get countries information");
        }
    }

    public void displayCountriesFromLargestToSmallestInPopulation() {
        try {
            // List of country objects
            List<Country> countries = new ArrayList<>();

            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Query
            String strSelect =
                    "SELECT " +
                            "co.Code, " +
                            "co.Name AS CountryName, " +
                            "co.Continent, " +
                            "co.Region, " +
                            "co.Population, " +
                            "ci.Name AS CapitalName " +
                            "FROM " +
                            "country co " +
                            "LEFT JOIN " +
                            "city ci " +
                            "ON " +
                            "co.Capital = ci.ID " +
                            "ORDER BY " +
                            "co.Population DESC, " +
                            "CountryName ASC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Iterate through all rows
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

            // Display results
            System.out.println("Countries from largest to smallest in population:");
            for (Country country : countries) {
                System.out.printf(
                        "Code: %s | Name: %s | Continent: %s | Region: %s | Population: %,d | Capital: %s%n",
                        country.getCode(),
                        country.getName(),
                        country.getContinent(),
                        country.getRegion(),
                        country.getPopulation(),
                        country.getCapitalName()
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Failed to get countries information");
        }
    }

    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        //a.displayCountriesFromLargestToSmallestInPopulation();
        a.displayCountriesPopulationFromContinentFromLargestToSmallest("Asia");

        // Disconnect from database
        a.disconnect();
    }
}