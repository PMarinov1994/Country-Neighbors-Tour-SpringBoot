package com.vmware.task.vmware.model.geonames;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CountryNeighboursResponce
{
    private int totalResultsCount = 0;

    @JsonProperty("geonames")
    private List<CountryNeighbour> countries = null;


    public int getTotalResultsCount()
    {
        return totalResultsCount;
    }



    public void setTotalResultsCount(int totalResultsCount)
    {
        this.totalResultsCount = totalResultsCount;
    }



    public List<CountryNeighbour> getCountries()
    {
        return countries;
    }



    public void setCountries(List<CountryNeighbour> geonames)
    {
        this.countries = geonames;
    }
}
