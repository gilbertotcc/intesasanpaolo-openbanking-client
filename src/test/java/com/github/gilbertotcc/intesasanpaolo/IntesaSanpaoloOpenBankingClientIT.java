package com.github.gilbertotcc.intesasanpaolo;

import static com.github.gilbertotcc.intesasanpaolo.conf.Environment.PLAYGROUND;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import com.github.gilbertotcc.intesasanpaolo.api.dto.AccountBalance;
import com.github.gilbertotcc.intesasanpaolo.api.dto.IbanVerification;
import org.junit.Test;

public class IntesaSanpaoloOpenBankingClientIT {

    @Test
    public void getAccountBalanceShouldSuccess() {
        IntesaSanpaoloOpenBankingClient client = IntesaSanpaoloOpenBankingClient.newClient(PLAYGROUND);
        AccountBalance accountBalance = client.getAccountBalance();

        assertNotNull(accountBalance);
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

    @Test(expected = RuntimeException.class) // 'error', not 'errors' in Playground response
    public void makeSepaInstantPaymentShouldFail() {
        IntesaSanpaoloOpenBankingClient client = IntesaSanpaoloOpenBankingClient.newClient(PLAYGROUND);
        /* SepaInstantPayment sepaInstantPayment = */ client.makeSepaInstantPayment();
    }

    @Test
    public void verifyIbanShouldSuccess() {
        IntesaSanpaoloOpenBankingClient client = IntesaSanpaoloOpenBankingClient.newClient(PLAYGROUND);
        IbanVerification ibanVerification = client.verifyIban();

        assertNotNull(ibanVerification);
        assertTrue(ibanVerification.isValid());
        assertEquals("IT", ibanVerification.getCountryCode());
        assertEquals("04", ibanVerification.getCheckDigits());
        assertEquals("03069", ibanVerification.getBankCode());
        assertEquals("01000", ibanVerification.getBankAgency());
        assertEquals("XTESTXCASEX1", ibanVerification.getAccount());
        assertEquals("G0306901000XTESTXCASEX1", ibanVerification.getBban());
    }
}
