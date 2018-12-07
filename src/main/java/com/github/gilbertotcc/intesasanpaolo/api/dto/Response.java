package com.github.gilbertotcc.intesasanpaolo.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {

    @JsonProperty("success")
    private boolean success;

    // FIXME 'errors' on GET /v1/tools/iban/formal-check response
    @JsonProperty("error")
    private Object error; // TODO Documentation doesn't provide details about that field

    @JsonProperty("payload")
    private T payload;

    private Response() {}

    public boolean isSuccess() {
        return success;
    }

    public Object getError() {
        return error;
    }

    public T getPayload() {
        return payload;
    }
}
