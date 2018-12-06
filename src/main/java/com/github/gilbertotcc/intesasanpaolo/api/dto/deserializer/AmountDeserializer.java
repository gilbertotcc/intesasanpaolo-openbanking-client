package com.github.gilbertotcc.intesasanpaolo.api.dto.deserializer;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class AmountDeserializer extends JsonDeserializer<BigDecimal> {

    @Override
    public BigDecimal deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException {
        try {
            return new BigDecimal(jsonParser.getValueAsString());
        } catch (NumberFormatException e) {
            throw new JsonParseException(jsonParser, "Cannot parse amount", e);
        }
    }
}
