package com.finehome.TestFineHome.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "upload_type", discriminatorType = DiscriminatorType.INTEGER)
@Table(name = "file_uploads")
public class FileUpload extends TimestampedEntity {

    protected String filePath;
    protected String fileName;
    protected String originalFileName;
    protected long fileSize;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    Employee employee;

    protected boolean isFeaturedImage;


    public boolean isFeaturedImage() {
        return isFeaturedImage;
    }

    public void setFeaturedImage(boolean featuredImage) {
        isFeaturedImage = featuredImage;
    }
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getUrlPath() {
        if (getFilePath().startsWith("http"))
            return getFilePath();
        else
            return "/api" + getFilePath();
    }
}

