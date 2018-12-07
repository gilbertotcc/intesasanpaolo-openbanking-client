package com.github.gilbertotcc.intesasanpaolo.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IbanVerification {

    @JsonProperty("isValid")
    private boolean valid;

    @JsonProperty("countryCode")
    private String countryCode;

    @JsonProperty("checkDigits")
    private String checkDigits;

    @JsonProperty("bankCode")
    private String bankCode;

    @JsonProperty("bankAgency")
    private String bankAgency;

    @JsonProperty("account")
    private String account;

    @JsonProperty("bban")
    private String bban;

    private IbanVerification() {}

    public boolean isValid() {
        return valid;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCheckDigits() {
        return checkDigits;
    }

    public String getBankCode() {
        return bankCode;
    }

    public String getBankAgency() {
        return bankAgency;
    }

    public String getAccount() {
        return account;
    }

    public String getBban() {
        return bban;
    }
}
