package com.vmware.task.vmware.controllers.internal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vmware.task.vmware.model.countryTour.TourInfo;
import com.vmware.task.vmware.model.countryTour.TourInput;
import com.vmware.task.vmware.services.ITourCalculator;


@RestController
public class CountryNeighborsTour
{
    private static final Logger log = LoggerFactory.getLogger(CountryNeighborsTour.class);

    @Autowired
    private ITourCalculator calculator;


    @PostMapping("/calculateTour")
    public TourInfo calculateTour(@RequestBody TourInput input)
    {
        log.info("Got POST request '/calculateTour' -> data: {}", input);

        if (input == null)
            return new TourInfo("REQUEST_IS_EMPTY");

        if (input.getHomeCountry() == null || input.getHomeCountry().isEmpty())
            return new TourInfo("REQUEST_HOME_COUNTRY_CODE_EMPTY");

        if (input.getInputCurrency() == null || input.getInputCurrency().isEmpty())
            return new TourInfo("REQUEST_CURRENCY_CODE_EMPTY");

        TourInfo result = calculator.calculate(input);
        log.info("Resutlt {}", result);

        return result;
    }
}
