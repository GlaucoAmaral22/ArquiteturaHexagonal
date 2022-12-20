package com.hexagonalarchitecture.domain;

import com.hexagonalarchitecture.domain.ports.CurrencyGateway;
import com.hexagonalarchitecture.domain.ports.TransactionDAO;

import java.time.LocalDate;
import java.util.List;

public class CalculateInvoice {

    TransactionDAO transactionDAO;
    CurrencyGateway currencyGateway;

    public CalculateInvoice(TransactionDAO transactionDAO, CurrencyGateway currencyGateway) {
        this.transactionDAO = transactionDAO;
        this.currencyGateway = currencyGateway;
    }

    public float execute(int cardNumber) {
        float USDQuotation = currencyGateway.getUSDQuotation();
        List<Transaction> transactions = this.transactionDAO.findCurrentTransactions(cardNumber, LocalDate.now());
        float total = 0;
        for (Transaction transaction : transactions) {
            if (transaction.isUSD()) {
                total += USDQuotation * transaction.getAmount();
                continue;
            }
            total += transaction.getAmount();
        }
        return total;
    }
}
