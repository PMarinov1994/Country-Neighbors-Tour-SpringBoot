package com.vmware.task.vmware.controllers.internal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.vmware.task.vmware.controllers.IGeoNamesAPI;
import com.vmware.task.vmware.model.geonames.CountryInfo;
import com.vmware.task.vmware.model.geonames.CountryInfoResponce;
import com.vmware.task.vmware.model.geonames.CountryNeighboursResponce;


@Controller
public class GeoNamesAPI implements IGeoNamesAPI
{
    private static final String GEONAMES_COUNTRY_NEIGHBOURS_API = "http://api.geonames.org/neighboursJSON?formatted=true&countryCode=%s&username=%s";

    private static final String GEONAMES_COUNTRY_INFO_API = "http://api.geonames.org/countryInfo?formatted=true&country=%s&username=%s";

    private static final Logger log = LoggerFactory.getLogger(GeoNamesAPI.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${rest.api.geonames.username}")
    private String GEONAMES_USER;


    public CountryNeighboursResponce getNeighbourCountries(String countryCode)
    {
        String url = String.format(GEONAMES_COUNTRY_NEIGHBOURS_API, countryCode, GEONAMES_USER);
        CountryNeighboursResponce responce = null;

        try
        {
            responce = restTemplate.getForObject(url, CountryNeighboursResponce.class);
        }
        catch (RestClientException ex)
        {
            log.error("Failed to get neighbour countries", ex);
        }

        return responce;
    }



    public CountryInfo getCountryInfo(String countryCode)
    {

        RestTemplate restTemplate = new RestTemplate();

        String url = String.format(GEONAMES_COUNTRY_INFO_API, countryCode, GEONAMES_USER);
        CountryInfoResponce responce = null;

        try
        {
            responce = restTemplate.getForObject(url, CountryInfoResponce.class);
        }
        catch (RestClientException ex)
        {
            log.error("Failed to get country info", ex);
        }

        return responce.getCountry();
    }
}
