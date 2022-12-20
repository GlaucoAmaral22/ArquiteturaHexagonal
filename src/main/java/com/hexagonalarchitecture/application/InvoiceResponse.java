package com.hexagonalarchitecture.application;

public class InvoiceResponse {

    private final float total;

    public InvoiceResponse(float total) {
        this.total = total;
    }

    public float getTotal() {
        return this.total;
    }
}
