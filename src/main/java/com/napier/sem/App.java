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
        if(args.length < 1){
            a.connect("localhost:33060", 30000);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]));
        }

            // GET COUNTRY
        //Country country = a.getCountry("BIH");
            // DISPLAY RESULTS
        //a.displayCountry(country);

            //COUNTRY BY POPULATION DESCENDING
        //ArrayList<Country> countryList = a.countriesByPopulationDesc();
            //PRINT POPULATION COUNTRIES DESC
        //a.displayCountryPopulations(countryList);

        //TOP N POPULATED COUNTRIES
        //ArrayList<Country> topNCountries = a.topNPopulatedCountries(5);
        //a.displayCountryPopulations(topNCountries);

        //CITY BY POPULATION DESCENDING
        ArrayList<City> cityList = a.citiesByPopulationDesc();
        //PRINT POPULATION CITIES DESC
        a.displayCityPopulations(cityList);

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
                country.setCode(rset.getString("Code"));
                country.setName(rset.getString("Name"));
                country.setContinent(rset.getString("Continent"));
                country.setRegion(rset.getString("Region"));
                country.setSurfaceArea(rset.getFloat("SurfaceArea"));
                country.setIndepYear(rset.getInt("IndepYear"));
                country.setPopulation(rset.getInt("Population"));
                country.setLifeExpectancy(rset.getFloat("LifeExpectancy"));
                country.setGnp(rset.getFloat("GNP"));
                country.setOldGnp(rset.getFloat("GNPOld"));
                country.setLocalName(rset.getString("LocalName"));
                country.setGovForm(rset.getString("GovernmentForm"));
                country.setHeadOfState(rset.getString("HeadOfState"));
                country.setCapital(rset.getInt("Capital"));
                country.setCode2(rset.getString("Code2"));
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
                    country.getCode() + " "
                            + country.getName() + " "
                            + country.getContinent() + "\n"
                            + country.getRegion() + "\n"
                            + country.getSurfaceArea() + "\n"
                            + country.getIndepYear() + "\n"
                            + country.getPopulation() + "\n"
                            + country.getLifeExpectancy() + "\n"
                            + country.getGnp() + "\n"
                            + country.getOldGnp() + "\n"
                            + country.getLocalName() + "\n"
                            + country.getGovForm() + "\n"
                            + country.getHeadOfState() + "\n"
                            + country.getCapital() + "\n"
                            + country.getCode2() + "\n");
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
                countryPopulation.setCode(rset.getString("Code"));
                countryPopulation.setName(rset.getString("Name"));
                countryPopulation.setContinent(rset.getString("Continent"));
                countryPopulation.setRegion(rset.getString("Region"));
                countryPopulation.setPopulation(rset.getInt("Population"));
                countryPopulation.setCapital(rset.getInt("Capital"));

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
                        countryPopulation.getCode() + " "
                                + countryPopulation.getName() + " "
                                + countryPopulation.getContinent() + " "
                                + countryPopulation.getRegion() + " "
                                + countryPopulation.getPopulation() + " "
                                + countryPopulation.getCapital() + "\n");
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
        public void connect(String location, int delay) {
            try {
                // Load Database driver
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Could not load SQL driver");
                System.exit(-1);
            }

            int retries = 10;
            for (int i = 0; i < retries; ++i) {
                System.out.println("Connecting to database...");
                try {
                    // Wait a bit for db to start
                    Thread.sleep(delay);
                    // Connect to database
                    con = DriverManager.getConnection("jdbc:mysql://" + location
                                    + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                            "root", "example");
                    System.out.println("Successfully connected");
                    break;
                } catch (SQLException sqle) {
                    System.out.println("Failed to connect to database attempt " +                                  Integer.toString(i));
                    System.out.println(sqle.getMessage());
                } catch (InterruptedException ie) {
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

    // top N populated countries
    public ArrayList<Country> topNPopulatedCountries(int n)
    {
        ArrayList<Country> countryList = new ArrayList<>();

        try
        {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital " +
                            "FROM country " +
                            "ORDER BY Population DESC " +
                            "LIMIT " + n;
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next())
            {
                Country countryPopulation = new Country();
                countryPopulation.setCode(rset.getString("Code"));
                countryPopulation.setName(rset.getString("Name"));
                countryPopulation.setContinent(rset.getString("Continent"));
                countryPopulation.setRegion(rset.getString("Region"));
                countryPopulation.setPopulation(rset.getInt("Population"));
                countryPopulation.setCapital(rset.getInt("Capital"));

                countryList.add(countryPopulation);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top N populated countries");
        }

        return countryList;
    }

    public ArrayList<City> citiesByPopulationDesc()
    {
        //create arraylist
        ArrayList<City> cityList = new ArrayList<>();

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, CountryCode, District, Population "
                            + "FROM city "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return city if valid.
            // Check each one is returned
            while (rset.next())
            {
                City cityPopulationSort = new City();
                cityPopulationSort.setCityName(rset.getString("Name"));
                cityPopulationSort.setCityCountry(rset.getString("CountryCode"));
                cityPopulationSort.setCityDistrict(rset.getString("District"));
                cityPopulationSort.setCityPopulation(rset.getInt("Population"));

                cityList.add(cityPopulationSort);
            }

            return cityList;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city by population");
            return null;
        }
    }

    public void displayCityPopulations(ArrayList<City> cityList)
    {
        if (cityList != null)
        {
            for (City cityPopulationSort : cityList)
            {
                if (cityPopulationSort == null)
                    continue;
                System.out.println(
                        cityPopulationSort.getCityName() + " "
                                + cityPopulationSort.getCityCountry() + " "
                                + cityPopulationSort.getCityDistrict() + " "
                                + cityPopulationSort.getCityPopulation() + "\n");
            }
        }
        else
            System.out.println("No entries in cities by population desc.");
    }
}
