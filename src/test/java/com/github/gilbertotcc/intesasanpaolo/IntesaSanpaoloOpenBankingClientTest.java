package com.github.gilbertotcc.intesasanpaolo;

import static com.github.gilbertotcc.intesasanpaolo.conf.Environment.PLAYGROUND;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class IntesaSanpaoloOpenBankingClientTest {

    @Test
    public void createNewClientShouldSuccess() {
        IntesaSanpaoloOpenBankingClient client = IntesaSanpaoloOpenBankingClient.newClient(PLAYGROUND);
        assertNotNull(client);
    }

    // TODO

}
