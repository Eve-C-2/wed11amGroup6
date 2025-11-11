package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
        countryPopulation.Code = "EVE";
        countryPopulation.Name = "Name";
        countryPopulation.Region = "Region";
        countryPopulation.Population = 12345;
        countryPopulation.Continent = "Continent";
        countryPopulation.Capital = 1;
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
}