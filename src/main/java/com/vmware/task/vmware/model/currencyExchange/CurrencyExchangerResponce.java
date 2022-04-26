package com.vmware.task.vmware.model.currencyExchange;

import java.util.Map;


public class CurrencyExchangerResponce
{
    private String base = null;
    private Map<String, Float> rates = null;


    public String getBase()
    {
        return base;
    }



    public void setBase(String base)
    {
        this.base = base;
    }



    public Map<String, Float> getRates()
    {
        return rates;
    }



    public void setRates(Map<String, Float> rates)
    {
        this.rates = rates;
    }
}
