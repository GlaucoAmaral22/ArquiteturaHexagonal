package com.Invoicemicrosservice.application.core.domain;

public class Invoice {
    private final float total;
    public Invoice(float total) {
        this.total = total;
    }

    public float getTotal() {
        return total;
    }
}
