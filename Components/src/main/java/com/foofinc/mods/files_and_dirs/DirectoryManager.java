package com.foofinc.mods.files_and_dirs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class DirectoryManager {

    private static final String USER_HOME = System.getProperty("user.home");

    private static final String COMPANY = "foofinc";
    private static final String FOLDER = "ST_AppData";

    private static final String FOLDER_PATH = String.format("Documents/%s/%s", COMPANY, FOLDER);

    private static final Path applicationDir = Paths.get(USER_HOME, FOLDER_PATH);


    public static Path getDir() {
        if(!Files.exists(applicationDir)){
            createDir();
        }
        return applicationDir;
    }

    private static void createDir() {
        try {
                Files.createDirectories(applicationDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
