package com.github.gilbertotcc.intesasanpaolo.api;

import com.github.gilbertotcc.intesasanpaolo.api.dto.AccountBalance;
import com.github.gilbertotcc.intesasanpaolo.api.dto.IbanVerification;
import com.github.gilbertotcc.intesasanpaolo.api.dto.SepaInstantPayment;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IntesaSanpaoloOpenBankingApi {

    @GET("/v1/accounts/*/balance")
    Call<Response<AccountBalance>> retrieveAccountBalance();

    @POST("/v1/payments/sct/instant")
    Call<SepaInstantPayment> makeSepaInstantPayment();

    @GET("/v1/tools/iban/formal-check")
    Call<IbanVerification> verifyIban();
}
