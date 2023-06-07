package com.foofinc.mods.file_zipping;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class FileZipperAPI {


    public static void unZipFilesToDestination(InputStream stream, File destDir) {

        try {
            if (!Files.exists(destDir.toPath())) {
                throw new FileNotFoundException("Cannot find destination directory");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
            UnZipper.upZip(stream, destDir);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void zipSingleFileToDestination(File fileToZip, File destDir) {
        try {
            Zipper.zipSingleFile(fileToZip, destDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void zipMultipleFilesToDestination(File[] filesToZip, File destDir) {
        try {
            Zipper.zipMultipleFiles(filesToZip, destDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void zipDirectory(File dirToZip, File destDir){
        try {
            Zipper.zipDirectory(dirToZip,destDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
