package com.Invoicemicrosservice.application.core.service;

import com.Invoicemicrosservice.application.core.domain.Invoice;
import com.Invoicemicrosservice.application.core.domain.Transaction;
import com.Invoicemicrosservice.application.driven.forobtainingtransactions.ForObtainingTransactions;
import com.Invoicemicrosservice.application.driven.forobtainingdolarquote.ForObtainingDollarQuote;
import com.Invoicemicrosservice.application.driver.forcalculateinvoice.ForCalculateInvoice;

import java.util.List;
public class CalculateInvoiceService implements ForCalculateInvoice {

    ForObtainingTransactions transactionDAO;
    ForObtainingDollarQuote currencyGateway;

    public CalculateInvoiceService(ForObtainingTransactions transactionDAO, ForObtainingDollarQuote currencyGateway) {
        this.transactionDAO = transactionDAO;
        this.currencyGateway = currencyGateway;
    }

    @Override
    public Invoice getInvoice(int cardNumber) {
        float USDQuotation = currencyGateway.getCurrentDollarQuote();
        List<Transaction> transactions = this.transactionDAO.getTransactions(cardNumber);
        float total = 0;
        for (Transaction transaction : transactions) {
            if (transaction.isUSD()) {
                total += USDQuotation * transaction.getAmount();
                continue;
            }
            total += transaction.getAmount();
        }
        return new Invoice(total);
    }
}
