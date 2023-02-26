package com.finehome.TestFineHome.service;

import com.finehome.TestFineHome.dto.ImageDtoRequest;
import com.finehome.TestFineHome.exception.PermissionDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class StorageService {

    @Autowired
    private SettingsService settingsService;

    private static List<String> imageExtension = Arrays.asList("jpeg", "png", "svg");

    final char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890".toCharArray();

    public List<File> upload(MultipartFile[] inputFiles) throws IOException {
        return upload(inputFiles, null);
    }

    public List<File> upload(MultipartFile[] inputFiles, String folder) throws IOException {
        List<File> uploadedFiles = new ArrayList<>();

        for (MultipartFile inputFile : inputFiles) {
            uploadedFiles.add(upload(inputFile, folder));
        }

        return uploadedFiles;
    }

    public File upload(MultipartFile fileInput, String folder) throws IOException {

        String outputDir = settingsService.getUploadsDirectory();
        if (folder != null)
            outputDir += folder;

        File f = new File(outputDir);
        File fileOutput = new File(outputDir + File.separator + generateRandomString(8) + getExtension(fileInput));
        if (!f.exists())
            f.mkdirs();
        upload(fileInput, fileOutput);
        return fileOutput;
    }



    public void upload(MultipartFile fileIn, File fileOut) throws IOException {
        fileIn.transferTo(fileOut);
    }

    private String getExtension(MultipartFile fileInput) {
        String fileName = fileInput.getOriginalFilename();
        String contentType = fileInput.getContentType();

        String[] parts = fileName.split("\\.");
        String extension = parts[parts.length - 1];
        if (extension.equalsIgnoreCase("png") ||
                extension.equalsIgnoreCase(".jpeg") || extension.equalsIgnoreCase("jpg"))
            return "." + extension;
        else
            throw new PermissionDeniedException("For security reasons you can not upload this, sorry");
    }


    public String generateRandomString(int length) {
        String randomString = "";

        final SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            randomString = randomString + chars[random.nextInt(chars.length)];
        }

        return randomString;
    }
}
