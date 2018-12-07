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

public class SepaInstantPaymentTest {

    @Test
    public void deserializeSepaInstantPaymentResponseShouldSuccess() throws IOException {
        String json = JacksonUtils.loadJsonFromFile("/json/response_sepa_instant_payment.json");
        Response<SepaInstantPayment> sepaInstantPaymentResponse = JacksonUtils.deserializeJson(json, new TypeReference<Response<SepaInstantPayment>>() {});

        assertTrue(sepaInstantPaymentResponse.isSuccess());
        assertNull(sepaInstantPaymentResponse.getError());
        SepaInstantPayment sepaInstantPayment = sepaInstantPaymentResponse.getPayload();
        assertEquals("0306921762315103480100101001IT", sepaInstantPayment.getOrderId());
        assertEquals("0304161762528507440100001000IT", sepaInstantPayment.getPaymentId());
        assertEquals("NOT PROVIDED", sepaInstantPayment.getEndToEndId());
        assertEquals("1803153714600096", sepaInstantPayment.getCustomerCro());
        assertEquals("ACSC-Prtry:", sepaInstantPayment.getTransactionStatusDescription());
        assertEquals("ACSC", sepaInstantPayment.getPaymentStatus());
        assertEquals(new BigDecimal("450.00"), sepaInstantPayment.getAmount());
        assertEquals("EUR", sepaInstantPayment.getCurrency());
        assertEquals(
                ZonedDateTime.of(
                        LocalDate.of(2017, 12, 31),
                        LocalTime.of(23, 59, 59),
                        ZoneOffset.ofHours(0)),
                sepaInstantPayment.getDate());
        assertEquals("CASH", sepaInstantPayment.getCategoryPurpose());
        assertEquals("SCT instant payment", sepaInstantPayment.getPaymentInformation());
        assertEquals("Mr. Sender", sepaInstantPayment.getDebtorName());
        assertEquals("IT04G0306901000XTESTXCASEX1", sepaInstantPayment.getDebtorIban());
        assertEquals("BCITITMMXXX", sepaInstantPayment.getDebtorBic());
        assertNull(sepaInstantPayment.getUltimateDebtorName());
        assertEquals("Mr. Receiver", sepaInstantPayment.getCreditorName());
        assertEquals("IT94H0306901000XTESTXCASEX2", sepaInstantPayment.getCreditorIban());
        assertEquals("BCITITMMXXX", sepaInstantPayment.getCreditorBic());
        assertNull(sepaInstantPayment.getUltimateCreditorName());
    }
}
