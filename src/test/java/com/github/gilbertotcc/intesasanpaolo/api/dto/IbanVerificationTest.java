package com.github.gilbertotcc.intesasanpaolo.api.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;

public class IbanVerificationTest {

    @Test
    public void deserializeIbanVerificationResultResponseShouldSuccess() throws IOException {
        String json = JacksonUtils.loadJsonFromFile("/json/response_verify_iban.json");
        Response<IbanVerification> ibanVerificationResultResponse = JacksonUtils.deserializeJson(json, new TypeReference<Response<IbanVerification>>() {});

        assertTrue(ibanVerificationResultResponse.isSuccess());
        assertNull(ibanVerificationResultResponse.getError());
        IbanVerification ibanVerification = ibanVerificationResultResponse.getPayload();
        assertTrue(ibanVerification.isValid());
        assertEquals("IT", ibanVerification.getCountryCode());
        assertEquals("04", ibanVerification.getCheckDigits());
        assertEquals("03069", ibanVerification.getBankCode());
        assertEquals("01000", ibanVerification.getBankAgency());
        assertEquals("XTESTXCASEX1", ibanVerification.getAccount());
        assertEquals("G0306901000XTESTXCASEX1", ibanVerification.getBban());
    }
}
