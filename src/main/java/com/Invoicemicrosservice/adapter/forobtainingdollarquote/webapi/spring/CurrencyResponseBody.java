package com.Invoicemicrosservice.adapter.forobtainingdollarquote.webapi.spring;

public class CurrencyResponseBody {
    public UsdBrl USDBRL;
    public UsdBrl getUsdBrl() {
        return this.USDBRL;
    }

    public boolean isEmpty() {
        return this.USDBRL == null;
    }

    public static class UsdBrl{
        private String bid;
        public String getBid() {
            return this.bid;
        }
    }

}
