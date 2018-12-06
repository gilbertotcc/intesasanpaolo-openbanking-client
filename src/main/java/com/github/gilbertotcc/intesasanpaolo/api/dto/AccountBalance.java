package com.github.gilbertotcc.intesasanpaolo.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.gilbertotcc.intesasanpaolo.api.dto.deserializer.AmountDeserializer;
import com.github.gilbertotcc.intesasanpaolo.api.dto.deserializer.BasicIsoLocalDateDeserializer;
import com.github.gilbertotcc.intesasanpaolo.api.dto.deserializer.IsoOffsetDateTimeDeserializer;

public class AccountBalance {

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("availableBalance")
    @JsonDeserialize(using = AmountDeserializer.class)
    private BigDecimal availableBalance;

    @JsonProperty("accountingBalance")
    @JsonDeserialize(using = AmountDeserializer.class)
    private BigDecimal accountingBalance;

    @JsonProperty("creditLine")
    @JsonDeserialize(using = AmountDeserializer.class)
    private BigDecimal creditLine;

    @JsonProperty("inquiryDate")
    @JsonDeserialize(using = BasicIsoLocalDateDeserializer.class)
    private LocalDate inquiryDate;

    @JsonProperty("executionDate")
    @JsonDeserialize(using = IsoOffsetDateTimeDeserializer.class)
    private ZonedDateTime executionDate;

    private AccountBalance() {}

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public BigDecimal getAccountingBalance() {
        return accountingBalance;
    }

    public BigDecimal getCreditLine() {
        return creditLine;
    }

    public LocalDate getInquiryDate() {
        return inquiryDate;
    }

    public ZonedDateTime getExecutionDate() {
        return executionDate;
    }
}
