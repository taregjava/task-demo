package com.finehome.TestFineHome.service;

import org.springframework.stereotype.Service;

@Service
public class SettingsService implements ISettingsService {

    @Override
    public String getUploadsDirectory() {
        return System.getProperty("user.dir") + "/uploads";
    }
}