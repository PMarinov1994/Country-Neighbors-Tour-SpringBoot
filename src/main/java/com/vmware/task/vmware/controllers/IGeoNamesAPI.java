package com.vmware.task.vmware.controllers;

import com.vmware.task.vmware.model.geonames.CountryInfo;
import com.vmware.task.vmware.model.geonames.CountryNeighboursResponce;


public interface IGeoNamesAPI
{
    public CountryNeighboursResponce getNeighbourCountries(String countryCode);



    public CountryInfo getCountryInfo(String countryCode);
}
