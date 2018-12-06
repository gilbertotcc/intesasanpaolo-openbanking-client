package com.github.gilbertotcc.intesasanpaolo.api.dto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String loadJsonFromFile(final String file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(JacksonUtils.class.getResourceAsStream(file), StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new IOException(String.format("Error occured while loading/reading file %s", file), e);
        }
    }

    public static <T> T deserializeJson(final String json, Class<T> clazz) throws IOException {
        return JacksonUtils.OBJECT_MAPPER.readValue(json, clazz);
    }

    public static <T> T deserializeJson(final String json, TypeReference typeReference) throws IOException {
        return JacksonUtils.OBJECT_MAPPER.readValue(json, typeReference);
    }

    public static <T> String serializeObject(final T object) throws JsonProcessingException {
        return JacksonUtils.OBJECT_MAPPER.writeValueAsString(object);
    }

    private JacksonUtils() {}
}
