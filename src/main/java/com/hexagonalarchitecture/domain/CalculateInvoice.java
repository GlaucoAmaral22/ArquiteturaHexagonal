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
        float USDCotation = currencyGateway.getCurrency();
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        List<Transaction> transactions = this.transactionDAO.findCurrentTransactions(cardNumber, year, month);
        float total = 0;
        for (Transaction transaction : transactions) {
            if(transaction.getCurrency().equals("USD")){
                total+= USDCotation * transaction.getAmount();
            }
            if(transaction.getCurrency().equals("USD")){
                total+= transaction.getAmount();
            }
        }
        return total;
    }
}
