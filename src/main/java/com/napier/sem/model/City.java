package com.napier.sem.model;

public class City {

    private int id;
    private String name;
    private String countryCode;
    private String countryName;  // <-- NEW FIELD
    private String district;
    private int population;

    // --- Constructors ---
    public City() {
    }

    public City(int id, String name, String countryCode, String countryName, String district, int population) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.countryName = countryName;   // <-- NEW PARAM
        this.district = district;
        this.population = population;
    }

    // --- Getters and Setters ---
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

    public String getCountryName() { return countryName; }  // <-- NEW GETTER
    public void setCountryName(String countryName) { this.countryName = countryName; }  // <-- NEW SETTER

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public int getPopulation() { return population; }
    public void setPopulation(int population) { this.population = population; }

    // --- toString ---
    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +   // <-- NEW
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }
}
