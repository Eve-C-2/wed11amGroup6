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

    public Country getCountry(String countryCode) {
        String sql = SqlLoader.load("sql/get_country.sql");
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, countryCode);
            try (ResultSet rset = ps.executeQuery()) {
                if (rset.next()) {
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
                return null;
            }
        } catch (Exception e) {
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

    public ArrayList<Country> countriesByPopulationDesc() {
        ArrayList<Country> countryList = new ArrayList<>();
        String sql = SqlLoader.load("sql/countries_by_population_desc.sql");

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rset = ps.executeQuery()) {

            while (rset.next()) {
                Country c = new Country();
                c.setCode(rset.getString("Code"));
                c.setName(rset.getString("Name"));
                c.setContinent(rset.getString("Continent"));
                c.setRegion(rset.getString("Region"));
                c.setPopulation(rset.getInt("Population"));
                c.setCapital(rset.getInt("Capital"));
                countryList.add(c);
            }
            return countryList;
        } catch (Exception e) {
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
    public ArrayList<Country> topNPopulatedCountries(int n) {
        ArrayList<Country> countryList = new ArrayList<>();
        String sql = SqlLoader.load("sql/top_n_countries.sql");

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, n); // параметр для LIMIT
            try (ResultSet rset = ps.executeQuery()) {
                while (rset.next()) {
                    Country c = new Country();
                    c.setCode(rset.getString("Code"));
                    c.setName(rset.getString("Name"));
                    c.setContinent(rset.getString("Continent"));
                    c.setRegion(rset.getString("Region"));
                    c.setPopulation(rset.getInt("Population"));
                    c.setCapital(rset.getInt("Capital"));
                    countryList.add(c);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top N populated countries");
        }
        return countryList;
    }


    public ArrayList<City> citiesByPopulationDesc() {
        ArrayList<City> cityList = new ArrayList<>();
        String sql = SqlLoader.load("sql/cities_by_population_desc.sql");

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rset = ps.executeQuery()) {

            while (rset.next()) {
                City city = new City();
                city.setCityName(rset.getString("Name"));
                city.setCityCountry(rset.getString("CountryCode"));
                city.setCityDistrict(rset.getString("District"));
                city.setCityPopulation(rset.getInt("Population"));
                cityList.add(city);
            }
            return cityList;
        } catch (Exception e) {
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
