package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App
{
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Get Employee
        //Country country = a.getCountry("BIH");
        // Display results
        //a.displayCountry(country);

        //country by population desc
        ArrayList<Country> countryList = a.countriesByPopulationDesc();
        //print population countries desc
        a.displayCountryPopulations(countryList);

        // Disconnect from database
        a.disconnect();
    }

    public Country getCountry(String countryCode)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2 "
                            + "FROM country "
                            + "WHERE Code = '" + countryCode + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                Country country = new Country();
                country.Code = rset.getString("Code");
                country.Name = rset.getString("Name");
                country.Continent = rset.getString("Continent");
                country.Region = rset.getString("Region");
                country.SurfaceArea = rset.getFloat("SurfaceArea");
                country.IndepYear = rset.getInt("IndepYear");
                country.Population = rset.getInt("Population");
                country.LifeExpectancy = rset.getFloat("LifeExpectancy");
                country.GNP = rset.getFloat("GNP");
                country.GNPOld = rset.getFloat("GNPOld");
                country.LocalName = rset.getString("LocalName");
                country.GovernmentForm = rset.getString("GovernmentForm");
                country.HeadOfState = rset.getString("HeadOfState");
                country.Capital = rset.getInt("Capital");
                country.Code2 = rset.getString("Code2");
                return country;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displayCountry(Country country)
    {
        if (country != null)
        {
            System.out.println(
                    country.Code + " "
                            + country.Name + " "
                            + country.Continent + "\n"
                            + country.Region + "\n"
                            + country.SurfaceArea + "\n"
                            + country.IndepYear + "\n"
                            + country.Population + "\n"
                            + country.LifeExpectancy + "\n"
                            + country.GNP + "\n"
                            + country.GNPOld + "\n"
                            + country.LocalName + "\n"
                            + country.GovernmentForm + "\n"
                            + country.HeadOfState + "\n"
                            + country.Capital + "\n"
                            + country.Code2 + "\n");
        }
    }

    public ArrayList<Country> countriesByPopulationDesc()
    {
        //create arraylist
        ArrayList<Country> countryList = new ArrayList<>();

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return country if valid.
            // Check each one is returned
            while (rset.next())
            {
                Country countryPopulation = new Country();
                countryPopulation.Code = rset.getString("Code");
                countryPopulation.Name = rset.getString("Name");
                countryPopulation.Continent = rset.getString("Continent");
                countryPopulation.Region = rset.getString("Region");
                countryPopulation.Population = rset.getInt("Population");
                countryPopulation.Capital = rset.getInt("Capital");

                countryList.add(countryPopulation);
            }

            return countryList;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country by population");
            return null;
        }
    }

    public void displayCountryPopulations(ArrayList<Country> countryList)
    {
        if (countryList != null)
        {
            for (Country countryPopulation : countryList)
            {
                if (countryPopulation == null)
                    continue;
                System.out.println(
                        countryPopulation.Code + " "
                                + countryPopulation.Name + " "
                                + countryPopulation.Continent + " "
                                + countryPopulation.Region + " "
                                + countryPopulation.Population + " "
                                + countryPopulation.Capital + "\n");
            }
        }
        else
            System.out.println("No entries in countries by population desc.");
    }

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
}
