package com.ytq.m.annotation;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import org.apache.commons.lang3.StringUtils;

/**
 * @author yuantongqin
 * 2019/9/19
 */
public class DecimalDeserialize extends JsonDeserializer<BigDecimal> {

    @Override
    public BigDecimal deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        if(jsonParser != null && StringUtils.isNotEmpty(jsonParser.getText())){
            return new BigDecimal(jsonParser.getText());
        }else{
            return null;
        }
    }

    @Override
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return deserialize(jsonParser,ctxt);
    }
}
