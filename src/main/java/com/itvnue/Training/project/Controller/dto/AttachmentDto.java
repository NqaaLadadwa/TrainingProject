package com.itvnue.Training.project.Controller.dto;

public class AttachmentDto {

    private int id;

    private Double fileSize;

    private String fileName;

    private int attachmentNo ;

    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getFileSize() {
        return fileSize;
    }

    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getAttachmentNo() {
        return attachmentNo;
    }

    public void setAttachmentNo(int attachmentNo) {
        this.attachmentNo = attachmentNo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
