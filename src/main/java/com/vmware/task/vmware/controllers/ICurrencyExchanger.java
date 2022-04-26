package com.vmware.task.vmware.controllers;

import com.vmware.task.vmware.model.countryTour.Currency;


public interface ICurrencyExchanger
{
    public Currency excange(String from, String to, float amount);
}
