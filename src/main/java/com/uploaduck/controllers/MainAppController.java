package com.uploaduck.controllers;

import com.uploaduck.services.implementation.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/")
public class MainAppController {

    @Autowired
    FileServiceImpl fileService;

    @RequestMapping(path = "/")
    public String mainPage() {
        return "";
    }

    @RequestMapping(path = "upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile... files) {
        fileService.saveAll(files);
        return null;
    }

    @RequestMapping(value = "/**")
    public String defaultPath() {
        return mainPage();
    }
}