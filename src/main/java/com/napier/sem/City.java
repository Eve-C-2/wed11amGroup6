package com.napier.sem;

/**
 * Represents a city
 */
public class City {
    /**
     * City Name
     */
    private String cityName;

    /**
     * City Country
     */
    private String cityCountry;

    /**
     * City District
     */
    private String cityDistrict;

    /**
     * City District
     */
    private Integer cityPopulation;

    //CONSTRUCTOR 1
    public City() {}

    //CONSTRUCTOR 2
    public City(String cityName, String cityCountry, String cityDistrict, Integer cityPopulation) {
        this.cityName = cityName;
        this.cityCountry = cityCountry;
        this.cityDistrict = cityDistrict;
        this.cityPopulation = cityPopulation;
    }

    //GETTERS
    public String getCityName()
    {
        return cityName;
    }

    public String getCityCountry()
    {
        return cityCountry;
    }

    public String getCityDistrict()
    {
        return cityDistrict;
    }

    public Integer getCityPopulation()
    {
        return cityPopulation;
    }

    //SETTERS
    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public void setCityCountry(String cityCountry)
    {
        this.cityCountry = cityCountry;
    }

    public void setCityDistrict(String cityDistrict)
    {
        this.cityDistrict = cityDistrict;
    }

    public void setCityPopulation(Integer cityPopulation)
    {
        this.cityPopulation = cityPopulation;
    }
}


