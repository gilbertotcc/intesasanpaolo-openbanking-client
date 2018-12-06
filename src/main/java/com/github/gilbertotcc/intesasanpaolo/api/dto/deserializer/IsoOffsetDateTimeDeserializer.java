package com.github.gilbertotcc.intesasanpaolo.api.dto.deserializer;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class IsoOffsetDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {

    private final DateTimeFormatter ISO_OFFSET_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Override
    public ZonedDateTime deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException {
        try {
            return ZonedDateTime.parse(jsonParser.getValueAsString(), ISO_OFFSET_DATE_TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new JsonParseException(jsonParser, "Cannot parse ISO offset date/time", e);
        }
    }
}
