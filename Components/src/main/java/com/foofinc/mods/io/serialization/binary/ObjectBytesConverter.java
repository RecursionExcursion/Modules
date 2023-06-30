package com.foofinc.mods.io.serialization.binary;

import java.io.*;

public class ObjectBytesConverter<T extends Serializable> {

    private final Class<T> tClass;

    public ObjectBytesConverter(Class<T> tClass) {
        this.tClass = tClass;
    }

    public byte[] objectToBytes(T t) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(t);
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public T bytesToObject(byte[] bytes) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            return castObject(ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private T castObject(Object obj) {
        return tClass.cast(obj);
    }
}
