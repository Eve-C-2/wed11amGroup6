package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
    }

    @Test
    void testGetCountry()
    {
        Country c = app.getCountry("GBR");
        assertNotNull(c, "Country should not be null");
        assertEquals("GBR", c.getCode());
        assertEquals("United Kingdom", c.getName());
    }

    @Test
    void testCountriesByPopulationDesc()
    {
        ArrayList<Country> countries = app.countriesByPopulationDesc();
        assertNotNull(countries);
        assertFalse(countries.isEmpty(), "Countries list should not be empty");

        // Check that they are sorted in descending order
        for (int i = 1; i < countries.size(); i++)
        {
            assertTrue(
                    countries.get(i - 1).getPopulation() >= countries.get(i).getPopulation(),
                    "Countries should be sorted by population descending"
            );
        }
    }

    //unit test for top n populated countries
//    @Test
//    void TopNPopulatedCountriesZero()
//    {
//        Country c = app.topNPopulatedCountries(0);
//        assertNotNull(c, "N should not be null");
//    }
}
