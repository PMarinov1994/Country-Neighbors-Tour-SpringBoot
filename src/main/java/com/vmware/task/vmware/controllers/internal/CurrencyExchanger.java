package com.vmware.task.vmware.controllers.internal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.vmware.task.vmware.controllers.ICurrencyExchanger;
import com.vmware.task.vmware.model.countryTour.Currency;
import com.vmware.task.vmware.model.currencyExchange.CurrencyExchangerResponce;


@Controller
public class CurrencyExchanger implements ICurrencyExchanger
{
    private static final String EXCHANGE_RATES_API = "http://api.exchangeratesapi.io/v1/latest?access_key=%s";

    private static final Logger log = LoggerFactory.getLogger(CurrencyExchanger.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${rest.api.currencyExchange.key}")
    private String ACCESS_KEY;


    @Override
    public Currency excange(String from, String to, float amount)
    {
        // No conversion is needed.
        if (from.equals(to))
            return new Currency(from, amount);

        String uri = String.format(EXCHANGE_RATES_API, ACCESS_KEY);
        CurrencyExchangerResponce responce = null;

        try
        {
            responce = this.restTemplate.getForObject(uri, CurrencyExchangerResponce.class);
        }
        catch (RestClientException ex)
        {
            log.error("Failed to get currency excange rates", ex);
            return null;
        }

        if (!responce.getBase().equals(from))
            return null;

        // No exchange rate found for the requested currency.
        if (!responce.getRates().containsKey(to))
            return null;


        Currency result = new Currency();
        result.setCode(to);
        result.setAmount(responce.getRates().get(to) * amount);

        return result;
    }
}
