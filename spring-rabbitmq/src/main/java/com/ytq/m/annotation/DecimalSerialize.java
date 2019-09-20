package com.ytq.m.annotation;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;

/**
 * @author yuantongqin
 * 2019/9/19
 */
public class DecimalSerialize extends JsonSerializer<BigDecimal> implements ContextualSerializer {

    private String param;

    public DecimalSerialize() {
        this("");
    }

    public DecimalSerialize(String param) {
        this.param = param;
    }

    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        String format = null;
        //是否为空
        if (value != null) {
            //格式化是否为空
            if (!"".equals(param)) {
                DecimalFormat decimalFormat = new DecimalFormat(param);
                format = decimalFormat.format(value);
            } else {
                format = value.toString();
            }
        }
        gen.writeString(format);
    }

    @Override
    public void serializeWithType(BigDecimal value, JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
        serialize(value,gen,serializers);
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        // 为空直接跳过
        if (property != null) {
            //非BigDecimal类型跳过
            if (Objects.equals(property.getType().getRawClass(), BigDecimal.class)) {
                BigDecimalFormat format = property.getAnnotation(BigDecimalFormat.class);
                if (format == null) {
                    format = property.getContextAnnotation(BigDecimalFormat.class);
                }
                if (format != null) {
                    // 如果能得到注解，就将注解的 value 传入 ImageURLSerialize
                    return new DecimalSerialize(format.value());
                }
            }
            return prov.findValueSerializer(property.getType(), property);
        }
        return prov.findNullValueSerializer(null);
    }
}