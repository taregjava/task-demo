package com.finehome.TestFineHome.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageDtoRequest {
    String name;
    @JsonProperty("data")
    String base64Image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
}


