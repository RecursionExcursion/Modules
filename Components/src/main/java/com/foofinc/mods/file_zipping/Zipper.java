package com.foofinc.mods.file_zipping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zipper {

    static void zipSingleFile(File fileToZip, File destFile) throws IOException {

        //TODO change filename
        FileOutputStream fos = new FileOutputStream(destFile + "/compressed.zip");

        ZipOutputStream zipOut = new ZipOutputStream(fos);

        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);

        //TODO buffer extract logic
                byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }

        zipOut.close();
        fis.close();
        fos.close();
    }

    static void zipMultipleFiles(File[] filesToZip, File destFile) throws IOException {

        //TODO change filename
        final FileOutputStream fos = new FileOutputStream(destFile + "/compressed.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        for (File fileToZip : filesToZip) {
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);


            //TODO buffer extract logic
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }

        zipOut.close();
        fos.close();
    }

    static void zipDirectory(File dirToZip, File destFile) throws IOException {

        //TODO change filename
        FileOutputStream fos = new FileOutputStream(destFile + "/dirCompressed.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        zipFile(dirToZip, dirToZip.getName(), zipOut);
        zipOut.close();
        fos.close();
    }

    private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                zipOut.putNextEntry(new ZipEntry(fileName));
                zipOut.closeEntry();
            } else {
                zipOut.putNextEntry(new ZipEntry(fileName + "/"));
                zipOut.closeEntry();
            }
            File[] children = fileToZip.listFiles();
            assert children != null;
            for (File childFile : children) {
                zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
            }
            return;
        }
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOut.putNextEntry(zipEntry);

        //TODO buffer extract logic
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        fis.close();
    }
}
