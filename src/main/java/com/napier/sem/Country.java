package com.napier.sem;

/**
 * Represents an employee
 */
public class Country {
    /**
     * Code number
     */
    private String code;

    /**
     * Country name
     */
    private String name;

    /**
     * Continent
     */
    private String continent;

    /**
     * Region
     */
    private String region;

    /**
     * Surface area
     */
    private Float surfaceArea;

    /**
     * Year of independence
     */
    private Integer indepYear;

    /**
     * Population
     */
    private Integer population;

    /**
     * Life expectancy
     */
    private Float lifeExpectancy;

    /**
     * GNP
     */
    private Float gnp;

    /**
     * GNP old
     */
    private Float gnpold;

    /**
     * Local name
     */
    private String localName;

    /**
     * Government form
     */
    private String governmentForm;

    /**
     * Head of state
     */
    private String headOfState;

    /**
     * Capital
     */
    private Integer capital;

    /**
     * Code 2
     */
    private String code2;

    //CONSTRUCTOR 1
    public Country(){}

    //CONSTRUCTOR 2
    public Country(String code, String name, String continent, String region, Float surfaceArea, Integer indepYear, Integer population, Float lifeExpectancy, Float gnp, Float gnpOld, String localName, String governmentForm, String headOfState, Integer capital, String code2) {
        // 'this.field' is necessary here to distinguish the class field from the method parameter
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.indepYear = indepYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.gnp = gnp;
        this.gnpold = gnpold;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.capital = capital;
        this.code2 = code2;
    }

    //GETTERS
    public String getCode()
    {
        return code;
    }

    public String getName()
    {
        return name;
    }

    public String getContinent()
    {
        return continent;
    }

    public String getRegion()
    {
        return region;
    }

    public Float getSurfaceArea()
    {
        return surfaceArea;
    }

    public Integer getIndepYear()
    {
        return indepYear;
    }

    public Integer getPopulation()
    {
        return population;
    }

    public Float getLifeExpectancy()
    {
        return lifeExpectancy;
    }

    public Float getGnp()
    {
        return gnp;
    }

    public Float getOldGnp()
    {
        return gnpold;
    }

    public String getLocalName()
    {
        return localName;
    }

    public String getGovForm()
    {
        return governmentForm;
    }

    public String getHeadOfState()
    {
        return headOfState;
    }

    public Integer getCapital()
    {
        return capital;
    }

    public String getCode2()
    {
        return code2;
    }


    //SETTERS
    public void setCode(String code)
    {
        this.code = code;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setContinent(String continent)
    {
        this.continent = continent;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public void setSurfaceArea(Float surfaceArea)
    {
        this.surfaceArea = surfaceArea;
    }

    public void setIndepYear(Integer indepYear)
    {
        this.indepYear = indepYear;
    }

    public void setPopulation(Integer population)
    {
        this.population = population;
    }

    public void setLifeExpectancy(Float lifeExpectancy)
    {
        this.lifeExpectancy = lifeExpectancy;
    }

    public void setGnp(Float gnp)
    {
        this.gnp = gnp;
    }

    public void setOldGnp(Float gnpold)
    {
        this.gnpold = gnpold;
    }

    public void setLocalName(String localName)
    {
        this.localName = localName;
    }

    public void setGovForm(String governmentForm)
    {
        this.governmentForm = governmentForm;
    }

    public void setHeadOfState(String headOfState)
    {
        this.headOfState = headOfState;
    }

    public void setCapital(Integer capital)
    {
        this.capital = capital;
    }

    public void setCode2(String code2)
    {
        this.code2 = code2;
    }

}