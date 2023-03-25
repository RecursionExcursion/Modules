package com.rloup.wog.util;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonSerializer<T> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final File filePath;

    public JsonSerializer(File filePath) {
        this.filePath = filePath;
    }

    public void mapObjectToJson(Object obj) {
        try {
            MAPPER.writeValue(filePath, obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public T mapJsonToObject(Class<T> tClass) {
        try {
            return MAPPER.readValue(filePath, tClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
