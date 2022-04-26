package com.vmware.task.vmware.model.geonames;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "geonames")
public class CountryInfoResponce
{
    private CountryInfo country = null;


    public CountryInfo getCountry()
    {
        return country;
    }



    public void setCountry(CountryInfo country)
    {
        this.country = country;
    }
}
