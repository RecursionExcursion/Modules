package com.foofinc.mods.serialization;

/**
 * Manager of ObjectSerializer
 * 'SerializablePlaceHolder' type should be replaced by the Object to be Serialized that implements the Serializable interface
 * FilePath and FileName must be updates
 * All are marked with //TODO
 * */


public class PersistenceManager {

    private static PersistenceManager INSTANCE = new PersistenceManager();

    //TODO
    private final ObjectSerializer<SerializablePlaceHolder> objectSerializer;

    //TODO
    private final String pathToFileFolder = "folderPath";
    //TODO
    private final String fileName = "fileName";


    private PersistenceManager() {
        objectSerializer = new ObjectSerializer<>(pathToFileFolder + fileName);
    }

    public static PersistenceManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PersistenceManager();
        }
        return INSTANCE;
    }

    //TODO
    public SerializablePlaceHolder getObject() {
        try {
            return objectSerializer.load();
        } catch (Exception e) {
            //TODO
            objectSerializer.save(new SerializablePlaceHolder());
        }
        return getObject();
    }

    //TODO
    public void saveObject(SerializablePlaceHolder obj) {
        objectSerializer.save(obj);
    }
}
