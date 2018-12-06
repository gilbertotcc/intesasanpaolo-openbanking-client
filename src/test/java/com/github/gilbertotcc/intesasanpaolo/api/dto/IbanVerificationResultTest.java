package com.github.gilbertotcc.intesasanpaolo.api.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;

public class IbanVerificationResultTest {

    @Test
    public void deserializeIbanVerificationResultResponseShouldSuccess() throws IOException {
        String json = JacksonUtils.loadJsonFromFile("/json/response_verify_iban.json");
        Response<IbanVerificationResult> ibanVerificationResultResponse = JacksonUtils.deserializeJson(json, new TypeReference<Response<IbanVerificationResult>>() {});

        assertTrue(ibanVerificationResultResponse.isSuccess());
        assertNull(ibanVerificationResultResponse.getError());
        IbanVerificationResult ibanVerificationResult = ibanVerificationResultResponse.getPayload();
        assertTrue(ibanVerificationResult.isValid());
        assertEquals("IT", ibanVerificationResult.getCountryCode());
        assertEquals("04", ibanVerificationResult.getCheckDigits());
        assertEquals("03069", ibanVerificationResult.getBankCode());
        assertEquals("01000", ibanVerificationResult.getBankAgency());
        assertEquals("XTESTXCASEX1", ibanVerificationResult.getAccount());
        assertEquals("G0306901000XTESTXCASEX1", ibanVerificationResult.getBban());
    }
}
