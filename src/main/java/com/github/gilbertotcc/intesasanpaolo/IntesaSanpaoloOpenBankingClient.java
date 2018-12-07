package com.github.gilbertotcc.intesasanpaolo;

import com.github.gilbertotcc.intesasanpaolo.api.dto.AccountBalance;
import com.github.gilbertotcc.intesasanpaolo.api.dto.IbanVerification;
import com.github.gilbertotcc.intesasanpaolo.api.dto.SepaInstantPayment;
import com.github.gilbertotcc.intesasanpaolo.conf.Environment;
import com.github.gilbertotcc.intesasanpaolo.impl.IntesaSanpaoloOpenBankingClientImpl;

public interface IntesaSanpaoloOpenBankingClient {

    static IntesaSanpaoloOpenBankingClient newClient(final Environment environment) {
        return IntesaSanpaoloOpenBankingClientImpl.newClient(environment);
    }

    AccountBalance getAccountBalance();

    SepaInstantPayment makeSepaInstantPayment();

    IbanVerification verifyIban();
}
