package com.hexagonalarchitecture.application;

import com.hexagonalarchitecture.domain.CalculateInvoice;
import com.hexagonalarchitecture.domain.ports.CurrencyGateway;
import com.hexagonalarchitecture.domain.ports.TransactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    TransactionDAO transactionDAO;
    CurrencyGateway externalClient;

    @Autowired
    public InvoiceController(TransactionDAO transactionDAO, CurrencyGateway externalClient){
        this.transactionDAO = transactionDAO;
        this.externalClient = externalClient;
    }

    @GetMapping("/card/{number}")
    public InvoiceResponse calculateInvoice(@PathVariable("number") int cardNumber) {
        CalculateInvoice invoice = new CalculateInvoice(transactionDAO, externalClient);
        float total = invoice.execute(cardNumber);
        return new InvoiceResponse(total);
    }
    //criacao da specification pra pegar somente do mes atual
    //criacao testes domain
    //tratativa de erros da consulta
}
