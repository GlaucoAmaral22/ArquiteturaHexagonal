package com.hexagonalarchitecture.domain.ports;

import com.hexagonalarchitecture.domain.Transaction;

import java.util.List;

public interface TransactionDAO {
    List<Transaction> findCurrentTransactions(int cardNumber, int year, int month);
}
