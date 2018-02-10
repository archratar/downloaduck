package com.uploaduck.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    void saveOne(MultipartFile file);
    void saveAll(MultipartFile... files);
}