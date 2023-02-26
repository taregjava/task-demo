package com.finehome.TestFineHome.service;

import com.finehome.TestFineHome.entity.Employee;
import com.finehome.TestFineHome.entity.EmployeeFile;
import com.finehome.TestFineHome.entity.FileUpload;
import com.finehome.TestFineHome.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class FileUploadService {

    @Autowired
    FileUploadRepository fileUploadRepository;

    public List<EmployeeFile> saveImages(Employee employee, List<File> filesInput) {
        List<EmployeeFile> files = new ArrayList<>();
        for (int i = 0; i < filesInput.size(); i++) {
            File fi = filesInput.get(i);
            EmployeeFile pi = new EmployeeFile();
            pi.setEmployee(employee);
            setBasicInfo(pi, fi);

            if (i == 0)
                pi.setFeaturedImage(true);

            files.add(pi);
        }

        // fileUploadRepository.saveAll(files);
        return files;
    }
    public FileUpload setBasicInfo(FileUpload fileUpload, File file) {
        fileUpload.setFileName(file.getName());
        fileUpload.setOriginalFileName(file.getName());
        fileUpload.setFileSize(file.length());
        fileUpload.setFilePath(file.getAbsolutePath().replace(new File("uploads").getAbsolutePath(), "").replace("\\", "/"));
        return fileUpload;
    }

    public void save(FileUpload fu) {
        fileUploadRepository.save(fu);
    }

   /* public List<ProductImage> getProductImagesFrom(List<Long> productIds) {
        return fileUploadRepository.findAllWhereProductIdIn(productIds);
    }*/
}
