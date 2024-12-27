package com.app.xettuyenhocba.controller;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
@RestController
@RequestMapping("/api/ftp")
@CrossOrigin
public class FTPController {
    @Autowired
    private FTPClient ftpClient;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam(
            "file") MultipartFile file) {
        String remoteFilePath = "/" + file.getOriginalFilename();
        try (InputStream inputStream = file.getInputStream()) {
            boolean done = ftpClient.storeFile(remoteFilePath, inputStream);
            if (done) {
                    return "File uploaded successfully: " + remoteFilePath;
            } else {
                return "Failed to upload file";
            }
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }

}
