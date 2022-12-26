package com.Invoicemicrosservice.application.driver.forcalculateinvoice;

import com.Invoicemicrosservice.application.core.domain.Invoice;

public interface ForCalculateInvoice {
    public Invoice getInvoice(int cardNumber);
}
