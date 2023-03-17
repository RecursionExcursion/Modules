package com.foofinc.mods.serialization;

/**
 * Manager of ObjectSerializer
 * 'SerializablePlaceHolder' type should be replaced by the Object to be Serialized that implements the Serializable interface
 * FilePath and FileName must be updated
 * All are marked with //TODO
 * <p>
 * Handling multiple ObjectSerializer's are possible
 */


public enum SerializationManager {

    INSTANCE;

    //TODO *//*
    private final String pathToFileFolder = "folderPath";
    private final String fileName = "fileName";
    private final ObjectSerializer<SerializablePlaceHolder> objectSerializer =
            new ObjectSerializer<>(pathToFileFolder + fileName);
    //TODO *//*

    public SerializablePlaceHolder loadObject() {
        try {
            return objectSerializer.load();
        } catch (Exception e) {
            objectSerializer.save(new SerializablePlaceHolder());
            return objectSerializer.load();
        }
    }

    public void saveObject(SerializablePlaceHolder obj) {
        objectSerializer.save(obj);
    }
}
