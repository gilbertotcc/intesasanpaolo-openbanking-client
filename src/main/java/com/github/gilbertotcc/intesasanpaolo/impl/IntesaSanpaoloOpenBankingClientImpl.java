package com.github.gilbertotcc.intesasanpaolo.impl;

import java.io.IOException;
import java.util.Optional;

import com.github.gilbertotcc.intesasanpaolo.IntesaSanpaoloOpenBankingClient;
import com.github.gilbertotcc.intesasanpaolo.api.IntesaSanpaoloOpenBankingApi;
import com.github.gilbertotcc.intesasanpaolo.api.dto.AccountBalance;
import com.github.gilbertotcc.intesasanpaolo.api.dto.IbanVerification;
import com.github.gilbertotcc.intesasanpaolo.api.dto.SepaInstantPayment;
import com.github.gilbertotcc.intesasanpaolo.conf.Environment;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class IntesaSanpaoloOpenBankingClientImpl implements IntesaSanpaoloOpenBankingClient {

    private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient();

    private final IntesaSanpaoloOpenBankingApi intesaSanpaoloOpenBankingApi;

    IntesaSanpaoloOpenBankingClientImpl(final IntesaSanpaoloOpenBankingApi intesaSanpaoloOpenBankingApi) {
        this.intesaSanpaoloOpenBankingApi = intesaSanpaoloOpenBankingApi;
    }

    public static IntesaSanpaoloOpenBankingClient newClient(final Environment environment) {
        IntesaSanpaoloOpenBankingApi intesaSanpaoloOpenBankingApi = new Retrofit.Builder()
                .baseUrl(environment.baseUrl)
                .client(OK_HTTP_CLIENT.newBuilder().build())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(IntesaSanpaoloOpenBankingApi.class);
        return new IntesaSanpaoloOpenBankingClientImpl(intesaSanpaoloOpenBankingApi);
    }

    @Override
    public AccountBalance getAccountBalance() {
        return execute(intesaSanpaoloOpenBankingApi.retrieveAccountBalance());
    }

    @Override
    public SepaInstantPayment makeSepaInstantPayment() {
        return execute(intesaSanpaoloOpenBankingApi.makeSepaInstantPayment());
    }

    @Override
    public IbanVerification verifyIban() {
        return execute(intesaSanpaoloOpenBankingApi.verifyIban());
    }

    private static <T> T execute(final Call<com.github.gilbertotcc.intesasanpaolo.api.dto.Response<T>> call) {
        try {
            Response<com.github.gilbertotcc.intesasanpaolo.api.dto.Response<T>> response = call.execute();
            return Optional.of(response)
                    .filter(Response::isSuccessful)
                    .map(Response::body)
                    .filter(com.github.gilbertotcc.intesasanpaolo.api.dto.Response::isSuccess)
                    .map(com.github.gilbertotcc.intesasanpaolo.api.dto.Response::getPayload)
                    .orElseThrow(() -> new RuntimeException("Request failed"));
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while calling remote service", e);
        }
    }
}
