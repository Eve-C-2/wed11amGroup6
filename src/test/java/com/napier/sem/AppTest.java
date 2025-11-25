package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void displayCountryPopulationsNull()
    {
        app.displayCountryPopulations(null);
    }

    @Test
    void displayCountryPopulationsEmpty()
    {
        ArrayList<Country> countryArrayList = new ArrayList<Country>();
        app.displayCountryPopulations(countryArrayList);
    }

    @Test
    void displayCountryPopulationsContainsNull()
    {
        ArrayList<Country> countryArrayList = new ArrayList<Country>();
        countryArrayList.add(null);
        app.displayCountryPopulations(countryArrayList);
    }

    @Test
    void printSalaries()
    {
        ArrayList<Country> countryArrayList = new ArrayList<Country>();
        Country countryPopulation = new Country();
        countryPopulation.setCode("EVE");
        countryPopulation.setName("Name");
        countryPopulation.setRegion("Region");
        countryPopulation.setPopulation(12345);
        countryPopulation.setContinent("Continent");
        countryPopulation.setCapital(1);
        countryArrayList.add(countryPopulation);
        app.displayCountryPopulations(countryArrayList);
    }

    @Test
    void topNPopulatedCountriesZero()
    {
        ArrayList<Country> countryArrayList = new ArrayList<Country>();
        countryArrayList.add(null);
        app.displayCountryPopulations(countryArrayList);
    }

    @Test
    void displayCityPopulationsEmpty()
    {
        ArrayList<City> cityArrayList = new ArrayList<City>();
        app.displayCityPopulations(cityArrayList);
    }

    @Test
    void displayCityPopulationsContainsNull()
    {
        ArrayList<City> cityArrayList = new ArrayList<City>();
        cityArrayList.add(null);
        app.displayCityPopulations(cityArrayList);
    }

    @Test
    void topNPopulatedCitiesZero()
    {
        ArrayList<City> cityArrayList = new ArrayList<City>();
        cityArrayList.add(null);
        app.displayCityPopulations(cityArrayList);
    }
}