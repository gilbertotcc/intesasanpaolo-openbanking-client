package com.github.gilbertotcc.intesasanpaolo.api.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.gilbertotcc.intesasanpaolo.api.dto.deserializer.AmountDeserializer;
import com.github.gilbertotcc.intesasanpaolo.api.dto.deserializer.IsoOffsetDateTimeDeserializer;

public class SepaInstantPayment {

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("paymentId")
    private String paymentId;

    @JsonProperty( "endToEndId")
    private String endToEndId;

    @JsonProperty("customerCro")
    private String customerCro;

    @JsonProperty("transactionStatusDescription")
    private String transactionStatusDescription;

    @JsonProperty("paymentStatus")
    private String paymentStatus;

    @JsonProperty("amount")
    @JsonDeserialize(using = AmountDeserializer.class)
    private BigDecimal amount;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("date")
    @JsonDeserialize(using = IsoOffsetDateTimeDeserializer.class)
    private ZonedDateTime date;

    @JsonProperty("categoryPurpose")
    private String categoryPurpose;

    @JsonProperty("paymentInformation")
    private String paymentInformation;

    @JsonProperty("debtorName")
    private String debtorName;

    @JsonProperty("debtorIBAN")
    private String debtorIban;

    @JsonProperty("debtorBic")
    private String debtorBic;

    @JsonProperty("ultimateDebtorName")
    private String ultimateDebtorName;

    @JsonProperty("creditorName")
    private String creditorName;

    @JsonProperty("creditorIBAN")
    private String creditorIban;

    @JsonProperty("creditorBic")
    private String creditorBic;

    @JsonProperty("ultimateCreditorName")
    private String ultimateCreditorName;

    private SepaInstantPayment() {}

    public String getOrderId() {
        return orderId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getEndToEndId() {
        return endToEndId;
    }

    public String getCustomerCro() {
        return customerCro;
    }

    public String getTransactionStatusDescription() {
        return transactionStatusDescription;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public String getCategoryPurpose() {
        return categoryPurpose;
    }

    public String getPaymentInformation() {
        return paymentInformation;
    }

    public String getDebtorName() {
        return debtorName;
    }

    public String getDebtorIban() {
        return debtorIban;
    }

    public String getDebtorBic() {
        return debtorBic;
    }

    public String getUltimateDebtorName() {
        return ultimateDebtorName;
    }

    public String getCreditorName() {
        return creditorName;
    }

    public String getCreditorIban() {
        return creditorIban;
    }

    public String getCreditorBic() {
        return creditorBic;
    }

    public String getUltimateCreditorName() {
        return ultimateCreditorName;
    }
}
