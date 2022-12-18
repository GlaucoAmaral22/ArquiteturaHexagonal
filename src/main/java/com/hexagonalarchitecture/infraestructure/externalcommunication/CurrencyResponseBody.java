package com.hexagonalarchitecture.infraestructure.externalcommunication;

public class CurrencyResponseBody {
    public UsdBrl USDBRL;
    public UsdBrl getUsdBrl() {
        return this.USDBRL;
    }

    public static class UsdBrl{
        private String bid;
        public String getBid() {
            return this.bid;
        }
    }
}
