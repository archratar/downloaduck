package com.uploaduck.services.implementation;

import com.uploaduck.services.FileServiceI;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public final class FileService implements FileServiceI {

    /*
            String dirPath = "";
        File file = new File("abc");
        File[] files = file.listFiles();

        System.out.println(file.mkdir());
        File file1 = new File(file.getAbsolutePath(), "abc.txt");
        file1.createNewFile();
        System.out.println(file.getAbsolutePath());
     */
    private File rootDirectory = null;

    public FileService() {
        this.rootDirectory = new File("uploaded");
        this.rootDirectory.mkdir();
    }

    @Override
    public void saveOne(File file) {
        file.mkdir();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveAll(File... files) {

    }

    public String getRootPath() {
        return this.rootDirectory.getPath();
    }

    public String getOriginalFileName(MultipartFile file, boolean withoutExtension) {
        if (withoutExtension) {
            String[] s = file.getOriginalFilename().split("\\.");
            return s[0];
        } else {
            return file.getOriginalFilename();
        }
    }
}