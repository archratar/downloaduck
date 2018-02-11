package com.uploaduck.vaadin;

import com.vaadin.ui.Upload;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class UploadReceiver implements Upload.Receiver {

    private static String parentDirectory = "uploaded";

    @Override
    public OutputStream receiveUpload(String filename, String mimeType) {

        File childDir = new File(pathToChildDir(filename));
        childDir.mkdir();
        File file = new File(pathToFile(filename));

        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stream;
    }

    private String pathToChildDir(String filename) {
        return parentDirectory + File.separator +  getFileNameWithoutExtension(filename);
    }

    private String pathToFile(String filename) {
        return pathToChildDir(filename) + File.separator + filename;
    }

    private String getFileNameWithoutExtension(String file) {
            String[] s = file.split("\\.");
            return s[0];
    }
}