package com.github.gilbertotcc.intesasanpaolo.api.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;

public class AccountBalanceTest {

    @Test
    public void deserializeAccountBalanceResponseShouldSuccess() throws IOException {
        String json = JacksonUtils.loadJsonFromFile("/json/response_account_balance.json");
        Response<AccountBalance> accountBalanceResponse = JacksonUtils.deserializeJson(json, new TypeReference<Response<AccountBalance>>() {});

        assertTrue(accountBalanceResponse.isSuccess());
        assertNull(accountBalanceResponse.getError());
        AccountBalance accountBalance = accountBalanceResponse.getPayload();
        assertEquals("EUR", accountBalance.getCurrency());
        assertEquals(new BigDecimal("250000.00"), accountBalance.getAvailableBalance());
        assertEquals(new BigDecimal("220000.00"), accountBalance.getAccountingBalance());
        assertEquals(new BigDecimal("30000.00"), accountBalance.getCreditLine());
        assertEquals(LocalDate.of(2018, 1, 31), accountBalance.getInquiryDate());
        assertEquals(
                ZonedDateTime.of(
                        LocalDate.of(2018, 5, 4),
                        LocalTime.of(9, 52, 10, 289000000),
                        ZoneOffset.ofHours(2)),
                accountBalance.getExecutionDate());
    }
}
