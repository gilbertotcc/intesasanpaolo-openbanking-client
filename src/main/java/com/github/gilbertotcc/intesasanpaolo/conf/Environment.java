package com.github.gilbertotcc.intesasanpaolo.conf;

public enum Environment {

    PLAYGROUND("https://external-api.intesasanpaolo.com/playground/");

    public final String baseUrl;

    Environment(final String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
