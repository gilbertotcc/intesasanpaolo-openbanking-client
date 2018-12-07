package com.github.gilbertotcc.intesasanpaolo.api.dto.deserializer;

import static java.util.Arrays.asList;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class IsoOffsetDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {

    private static final List<DateTimeFormatter> ISO_OFFSET_DATE_TIME_FORMATTERS = asList(
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX")
    );

    @Override
    public ZonedDateTime deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException {
        final String zonedDateTimeString = jsonParser.getValueAsString();
        return ISO_OFFSET_DATE_TIME_FORMATTERS.stream()
                .map(zonedDateTimeOf(zonedDateTimeString))
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> new JsonParseException(jsonParser, "Cannot parse ISO offset date/time"));
    }

    private static Function<DateTimeFormatter, ZonedDateTime> zonedDateTimeOf(final String s) {
        return dateTimeFormatter -> {
            try {
                return ZonedDateTime.parse(s, dateTimeFormatter);
            } catch (DateTimeParseException e) {
                return null;
            }
        };
    }
}
