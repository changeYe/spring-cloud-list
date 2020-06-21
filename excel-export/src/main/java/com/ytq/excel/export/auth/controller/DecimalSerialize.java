//package com.ytq.excel.export.auth.controller;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.BeanProperty;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.SerializerProvider;
//import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
//import com.fasterxml.jackson.databind.ser.ContextualSerializer;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.text.DecimalFormat;
//import java.time.LocalDateTime;
//import java.util.Objects;
//
///**
// * @author yuantongqin
// * desc:
// * 2020-06-04
// */
//public class DecimalSerialize extends JsonSerializer<LocalDateTime> implements ContextualSerializer {
//
//    private String param;
//
//    public DecimalSerialize() {
//        this("");
//    }
//
//    @Override
//    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//        String format = null;
//        //是否为空
//        if (localDateTime != null) {
//            //格式化是否为空
//            if (!"".equals(param)) {
//                DecimalFormat decimalFormat = new DecimalFormat(param);
//                format = decimalFormat.format(value);
//            } else {
//                format = value.toString();
//            }
//        }
//        jsonGenerator.writeString(format);
//    }
//
//    public DecimalSerialize(String param) {
//
//        this.param = param;
//    }
//
//    @Override
//    public void serializeWithType(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
////        super.serializeWithType(value, gen, serializers, typeSer);
//        serialize(value,gen,serializers);
//    }
//
//
//    @Override
//    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
//        // 为空直接跳过
//        if (property != null) {
//            //非BigDecimal类型跳过
//            if (Objects.equals(property.getType().getRawClass(), LocalDateTime.class)) {
//                JsonFormat format = property.getAnnotation(JsonFormat.class);
//                if (format == null) {
//                    format = property.getContextAnnotation(JsonFormat.class);
//                }
//                if (format != null) {
//                    // 如果能得到注解，就将注解的 value 传入 ImageURLSerialize
//                    return new DecimalSerialize(format.pattern());
//                }
//            }
//            return prov.findValueSerializer(property.getType(), property);
//        }
//        return prov.findNullValueSerializer(null);
//    }
//}
