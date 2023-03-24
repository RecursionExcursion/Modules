package com.foofinc.mods.io.serialization.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;

public class JsonSerializer<T> {

    private final ObjectMapper mapper = new ObjectMapper();
    private final File filePath;

    public JsonSerializer(File filePath) {
        this.filePath = filePath;
    }

    public void mapObjectToJson(Object obj) {
        try {
            mapper.writeValue(filePath, obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public T mapJsonToObject() {
        try {
            return mapper.readValue(filePath, new TypeReference<T>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
