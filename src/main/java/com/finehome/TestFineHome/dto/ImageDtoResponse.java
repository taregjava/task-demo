package com.finehome.TestFineHome.dto;

import com.finehome.TestFineHome.entity.EmployeeFile;
import com.finehome.TestFineHome.entity.FileUpload;

import java.util.List;
import java.util.stream.Collectors;

public class ImageDtoResponse {

    private final String path;

    public ImageDtoResponse(String filePath) {
        this.path = filePath;
    }

    public static ImageDtoResponse build(EmployeeFile image) {
        return new ImageDtoResponse(image.getUrlPath());
    }

    public static List<String> buildStrings(List<FileUpload> images) {
        return images.stream().map(i -> i.getFileName()).collect(Collectors.toList());
    }

    public String getPath() {
        return path;
    }
}