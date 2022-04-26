package com.vmware.task.vmware.model.geonames;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "country")
public class CountryInfo
{
    private String countryCode = null;
    private String countryName = null;
    private String currencyCode = null;


    public String getCountryCode()
    {
        return countryCode;
    }



    public void setCountryCode(String countryCode)
    {
        this.countryCode = countryCode;
    }



    public String getCountryName()
    {
        return countryName;
    }



    public void setCountryName(String countryName)
    {
        this.countryName = countryName;
    }



    public String getCurrencyCode()
    {
        return currencyCode;
    }



    public void setCurrencyCode(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }
}
