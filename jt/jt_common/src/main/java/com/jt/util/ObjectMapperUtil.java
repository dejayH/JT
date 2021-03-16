package com.jt.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //1.将对象转换成JSON
    public static String toJSON(Object obj){
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            //将检查异常,转化为运行是的异常
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    //2.JSON转化为对象
    public static <T> T toObject(String json,Class<T> target){
        try {
            return MAPPER.readValue(json, target);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
