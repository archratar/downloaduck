package com.uploaduck.services.implementation;

import com.uploaduck.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public final class FileServiceImpl implements FileService {

    private File rootDirectory = null;

    public FileServiceImpl() {
        this.rootDirectory = new File("uploaded");
        this.rootDirectory.mkdir();
    }

    @Override
    public void saveOne(MultipartFile file) {

        if (!this.rootDirectory.exists())
            createRootDirectory();

        String dirName = this.getOriginalFileName(file, true);
        String fileName = this.getOriginalFileName(file, false);

        try {
            byte [] bytes = file.getBytes();
            File dir = new File(this.getRootPath() + File.separator + dirName);
            dir.mkdir();
            File createdFile = new File(dir.getAbsolutePath() + File.separator + fileName);

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(createdFile));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveAll(MultipartFile... files) {
        for (MultipartFile file : files)
            saveOne(file);
    }

    private void createRootDirectory() {
        if (!this.rootDirectory.exists()) {
            this.rootDirectory = new File("uploaded");
            this.rootDirectory.mkdir();
        }
    }

    private String getRootPath() {
        return this.rootDirectory.getPath();
    }

    private String getOriginalFileName(MultipartFile file, boolean withoutExtension) {
        if (withoutExtension) {
            String[] s = file.getOriginalFilename().split("\\.");
            return s[0];
        } else {
            return file.getOriginalFilename();
        }
    }
}