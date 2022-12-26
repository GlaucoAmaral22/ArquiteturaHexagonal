package com.Invoicemicrosservice.application.driven.forobtainingtransactions;

import com.Invoicemicrosservice.application.core.domain.Transaction;

import java.util.List;

public interface ForObtainingTransactions {
    List<Transaction> getTransactions(int cardNumber);
}
