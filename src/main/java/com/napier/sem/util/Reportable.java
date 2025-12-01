package com.napier.sem.util;

import com.napier.sem.model.City;
import com.napier.sem.model.Country;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Reportable {
    public static void generateCountryReports(List<Country> countries, String filename){

        StringBuilder sb = new StringBuilder();

        // Table Headers
        sb.append("| Code | Name | Continent | Region | Population | Capital |\r\n");
        sb.append("| ---  | ---  | ---       | ---    | ---------: | ---     |\r\n");

        // Table Rows
        for (Country c : countries) {
            if (c == null) continue;
            sb.append("| ")
                    .append(c.getCode()).append(" | ")
                    .append(c.getName()).append(" | ")
                    .append(c.getContinent()).append(" | ")
                    .append(c.getRegion()).append(" | ")
                    .append(String.format("%,d", c.getPopulation())).append(" | ")
                    .append(c.getCapitalName()).append(" |\r\n");
        }

        try {
            new File("/app/reports").mkdirs();
            BufferedWriter writer = new BufferedWriter(new FileWriter("/app/reports/" + filename));
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace(); //test
        }
    }

    public static void generateCitiesReport(List<City> cities, String filename){
        StringBuilder sb = new StringBuilder();

        // Table Headers
        sb.append("| City | Country | District | Population |\r\n");
        sb.append("| ---  | ---  | ---    | ---------: |\r\n");

        // Table Rows
        for (City c : cities) {
            if (c == null) continue;
            sb.append("| ")
                    .append(c.getName()).append(" | ")
                    .append(c.getCountryName()).append(" | ")
                    .append(c.getDistrict()).append(" | ")
                    .append(String.format("%,d", c.getPopulation())).append(" |\r\n");
        }

        try {
            new File("/app/reports").mkdirs();
            BufferedWriter writer = new BufferedWriter(new FileWriter("/app/reports/" + filename));
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace(); //test
        }
    }
}
