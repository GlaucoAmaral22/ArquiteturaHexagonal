package com.hexagonalarchitecture.domain;

import java.util.Date;

public class Transaction {

    Integer cardNumber;

    int amount;

    String currency;

    Date date;
    public Transaction(Integer cardNumber, int amount, String currency, Date date) {
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.currency = currency;
        this.date = date;
    }

    public Integer getCardNumber() {
        return this.cardNumber;
    }
    public int getAmount() {
        return this.amount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public Date getDate() {
        return this.date;
    }


}
