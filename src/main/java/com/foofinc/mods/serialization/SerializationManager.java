package com.foofinc.mods.serialization;

/**
 * Manager of ObjectSerializer
 * 'SerializablePlaceHolder' type should be replaced by the Object to be Serialized that implements the Serializable interface
 * FilePath and FileName must be updated
 * All are marked with //TODO
 *
 * Handling multiple ObjectSerializer's are possible
 */


public enum SerializationManager {

    INSTANCE;

    //TODO *//*
    private final ObjectSerializer<SerializablePlaceHolder> objectSerializer;
    private final String pathToFileFolder = "folderPath";
    private final String fileName = "fileName";
    private SerializablePlaceHolder placeHolder;
    //TODO *//*

    SerializationManager() {
        objectSerializer = new ObjectSerializer<>(pathToFileFolder + fileName);

        try {
            placeHolder = objectSerializer.load();
        } catch (Exception e) {
            objectSerializer.save(new SerializablePlaceHolder());
            placeHolder = objectSerializer.load();
        }
    }

    public SerializablePlaceHolder getObject() {
        return placeHolder;
    }

    public void saveObject(SerializablePlaceHolder obj) {
        objectSerializer.save(obj);
    }
}
