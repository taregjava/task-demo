package com.finehome.TestFineHome.repository;

import com.finehome.TestFineHome.entity.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends JpaRepository<FileUpload, Integer> {
}
