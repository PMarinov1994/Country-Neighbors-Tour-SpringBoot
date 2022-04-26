package com.vmware.task.vmware.model.countryTour;

public class Currency
{
    private String code;
    private float amount;


    public Currency()
    {
        this.code = null;
        this.amount = 0;
    }



    public Currency(String code, float amount)
    {
        this.code = code;
        this.amount = amount;
    }



    public String getCode()
    {
        return code;
    }



    public void setCode(String code)
    {
        this.code = code;
    }



    public float getAmount()
    {
        return amount;
    }



    public void setAmount(float amount)
    {
        this.amount = amount;
    }



    @Override
    public String toString()
    {
        return String.format("%s: %s", this.code, this.amount);
    }
}
