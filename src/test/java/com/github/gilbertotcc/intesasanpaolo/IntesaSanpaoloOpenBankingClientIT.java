package com.github.gilbertotcc.intesasanpaolo;

import static com.github.gilbertotcc.intesasanpaolo.conf.Environment.PLAYGROUND;
import static org.junit.Assert.assertNotNull;

import com.github.gilbertotcc.intesasanpaolo.api.dto.AccountBalance;
import com.github.gilbertotcc.intesasanpaolo.api.dto.IbanVerification;
import com.github.gilbertotcc.intesasanpaolo.api.dto.SepaInstantPayment;
import org.junit.Test;

public class IntesaSanpaoloOpenBankingClientIT {

    @Test
    public void getAccountBalanceShouldSuccess() {
        IntesaSanpaoloOpenBankingClient client = IntesaSanpaoloOpenBankingClient.newClient(PLAYGROUND);
        AccountBalance accountBalance = client.getAccountBalance();

        assertNotNull(accountBalance);
        // TODO Enjoy adding more asserts
    }

    @Test(expected = RuntimeException.class) // 'error', not 'errors' in Playground response
    public void makeSepaInstantPaymentShouldFail() {
        IntesaSanpaoloOpenBankingClient client = IntesaSanpaoloOpenBankingClient.newClient(PLAYGROUND);
        SepaInstantPayment sepaInstantPayment = client.makeSepaInstantPayment();

        assertNotNull(sepaInstantPayment);
        // TODO Enjoy adding more asserts
    }

    @Test
    public void verifyIbanShouldSuccess() {
        IntesaSanpaoloOpenBankingClient client = IntesaSanpaoloOpenBankingClient.newClient(PLAYGROUND);
        IbanVerification ibanVerification = client.verifyIban();

        assertNotNull(ibanVerification);
        // TODO Enjoy adding more asserts
    }
}
