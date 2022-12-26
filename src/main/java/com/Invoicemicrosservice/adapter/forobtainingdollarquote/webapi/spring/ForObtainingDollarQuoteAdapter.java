package com.Invoicemicrosservice.adapter.forobtainingdollarquote.webapi.spring;

import com.Invoicemicrosservice.application.driven.forobtainingdolarquote.ForObtainingDollarQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ForObtainingDollarQuoteAdapter implements ForObtainingDollarQuote {

    private static final float DEFAULT_DOLLAR_QUOTE = 5.0f;

    RestTemplate restTemplate;

    @Autowired
    public ForObtainingDollarQuoteAdapter() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public float getCurrentDollarQuote() {
        CurrencyResponseBody responseBody = this.restTemplate.getForObject(
                "https://economia.awesomeapi.com.br/last/USD-BRL",
                CurrencyResponseBody.class
        );

        if (responseBody == null || responseBody.isEmpty()){
            return DEFAULT_DOLLAR_QUOTE;
        }

        return Float.parseFloat(responseBody.getUsdBrl().getBid());
    }
}
