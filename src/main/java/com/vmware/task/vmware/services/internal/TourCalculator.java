package com.vmware.task.vmware.services.internal;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmware.task.vmware.controllers.ICurrencyExchanger;
import com.vmware.task.vmware.controllers.IGeoNamesAPI;
import com.vmware.task.vmware.model.countryTour.Currency;
import com.vmware.task.vmware.model.countryTour.TourInfo;
import com.vmware.task.vmware.model.countryTour.TourInput;
import com.vmware.task.vmware.model.geonames.CountryInfo;
import com.vmware.task.vmware.model.geonames.CountryNeighbour;
import com.vmware.task.vmware.model.geonames.CountryNeighboursResponce;
import com.vmware.task.vmware.services.ITourCalculator;


@Service
public class TourCalculator implements ITourCalculator
{
    @Autowired
    private ICurrencyExchanger currencyExchanger;

    @Autowired
    private IGeoNamesAPI geoNamesAPI;


    @Override
    public TourInfo calculate(TourInput input)
    {
        CountryNeighboursResponce neighbourCountries = geoNamesAPI.getNeighbourCountries(input.getHomeCountry());
        if (neighbourCountries.getTotalResultsCount() == 0)
            return new TourInfo("INVALID_COUNTRY_CODE");

        Map<String, Currency> codeToMoneyMap = new HashMap<>();
        float totalCostPerRoundTrip = 0;

        for (CountryNeighbour country : neighbourCountries.getCountries())
        {
            CountryInfo countryInfo = geoNamesAPI.getCountryInfo(country.getCountryCode());
            Currency currency = currencyExchanger.excange(
                    input.getInputCurrency(), countryInfo.getCurrencyCode(), input.getBudgetPerCountry());

            // Exchange rate was unsuccessful. Use the input currency.
            if (currency == null)
                currency = new Currency(input.getInputCurrency(), input.getBudgetPerCountry());

            totalCostPerRoundTrip += input.getBudgetPerCountry();
            codeToMoneyMap.put(countryInfo.getCountryName(), currency);
        }

        // Cast to int will round it down to the nearest integer.
        int roundTrips = (int) (input.getTotalBudget() / totalCostPerRoundTrip);

        TourInfo result = new TourInfo();
        result.setRoundTrips(roundTrips);

        if (roundTrips != 0)
        {
            for (String key : codeToMoneyMap.keySet())
            {
                Currency currency = codeToMoneyMap.get(key);
                currency.setAmount(currency.getAmount() * roundTrips);

                codeToMoneyMap.put(key, currency);
            }

            result.setCodeToMoneyMap(codeToMoneyMap);

            float leftOverMoney = input.getTotalBudget() - (totalCostPerRoundTrip * roundTrips);
            result.setLeftOverMoney(new Currency(
                    input.getInputCurrency(),
                    leftOverMoney));
        }
        else
            result.setError("NOT_ENOUGH_MONEY");

        return result;
    }
}
