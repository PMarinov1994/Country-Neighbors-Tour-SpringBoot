package com.vmware.task.vmware.model.countryTour;


public class TourInput
{
    private String homeCountry = null;
    private float budgetPerCountry = 0;
    private float totalBudget = 0;
    private String inputCurrency = null;


    public String getHomeCountry()
    {
        return homeCountry;
    }



    public void setHomeCountry(String homeCountry)
    {
        this.homeCountry = homeCountry;
    }



    public float getBudgetPerCountry()
    {
        return budgetPerCountry;
    }



    public void setBudgetPerCountry(float budgetPerCountry)
    {
        this.budgetPerCountry = budgetPerCountry;
    }



    public float getTotalBudget()
    {
        return totalBudget;
    }



    public void setTotalBudget(float totalBudget)
    {
        this.totalBudget = totalBudget;
    }



    public String getInputCurrency()
    {
        return inputCurrency;
    }



    public void setInputCurrency(String inputCurrency)
    {
        this.inputCurrency = inputCurrency;
    }



    @Override
    public String toString()
    {
        return String.format("TourInput -> homeCountry: %s, budgetPerCountry: %s, totalBudget: %s, inputCurrency: %s",
                this.homeCountry, this.budgetPerCountry, this.totalBudget, this.inputCurrency);
    }
}
