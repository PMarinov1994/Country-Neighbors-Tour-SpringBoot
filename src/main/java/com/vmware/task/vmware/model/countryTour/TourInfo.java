package com.vmware.task.vmware.model.countryTour;

import java.util.Map;


public class TourInfo
{
    private String error;
    private int roundTrips;
    private Currency leftOverMoney;
    private Map<String, Currency> codeToMoneyMap;


    public TourInfo()
    {
        this.error = "NO_ERROR";
        this.roundTrips = 0;
        this.leftOverMoney = null;
        this.codeToMoneyMap = null;
    }



    public TourInfo(String error)
    {
        this();
        this.error = error;
    }



    public int getRoundTrips()
    {
        return roundTrips;
    }



    public void setRoundTrips(int roundTrips)
    {
        this.roundTrips = roundTrips;
    }



    public Currency getLeftOverMoney()
    {
        return leftOverMoney;
    }



    public void setLeftOverMoney(Currency leftOverMoney)
    {
        this.leftOverMoney = leftOverMoney;
    }



    public Map<String, Currency> getCodeToMoneyMap()
    {
        return codeToMoneyMap;
    }



    public void setCodeToMoneyMap(Map<String, Currency> codeToMoneyMap)
    {
        this.codeToMoneyMap = codeToMoneyMap;
    }



    public String getError()
    {
        return error;
    }



    public void setError(String error)
    {
        this.error = error;
    }



    @Override
    public String toString()
    {
        return String.format("ErrorCode: %s, RoundTrips: %s, LeftOverMoney: %s, MoneyMap: %s",
                this.error,
                this.roundTrips,
                this.leftOverMoney,
                this.codeToMoneyMap);
    }
}
