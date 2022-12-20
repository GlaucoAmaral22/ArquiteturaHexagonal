package com.hexagonalarchitecture.infraestructure.externalcommunication;

import com.hexagonalarchitecture.domain.ports.CurrencyGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpCurrencyGateway implements CurrencyGateway {

    RestTemplate restTemplate;

    @Autowired
    public HttpCurrencyGateway() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public float getUSDQuotation() {
        CurrencyResponseBody reponseBody = this.restTemplate.getForObject(
                "https://economia.awesomeapi.com.br/last/USD-BRL",
                CurrencyResponseBody.class
        );
        return Float.parseFloat(reponseBody.getUsdBrl().getBid());
    }
}
