package com.Invoicemicrosservice.adapter.forcalculateinvoice.controller.spring;

import com.Invoicemicrosservice.application.driven.forobtainingtransactions.ForObtainingTransactions;
import com.Invoicemicrosservice.application.core.service.CalculateInvoiceService;
import com.Invoicemicrosservice.application.driven.forobtainingdolarquote.ForObtainingDollarQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    ForObtainingTransactions transactionDAO;
    ForObtainingDollarQuote externalClient;

    @Autowired
    public InvoiceController(ForObtainingTransactions transactionDAO, ForObtainingDollarQuote externalClient){
        this.transactionDAO = transactionDAO;
        this.externalClient = externalClient;
    }

    @GetMapping("/card/{number}")
    public InvoiceResponse calculateInvoice(@PathVariable("number") int cardNumber) {
        CalculateInvoiceService invoice = new CalculateInvoiceService(transactionDAO, externalClient);
        float total = (invoice.getInvoice(cardNumber)).getTotal();
        return new InvoiceResponse(total);
    }
}
