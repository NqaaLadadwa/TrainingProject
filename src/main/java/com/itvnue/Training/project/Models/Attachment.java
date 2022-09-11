package com.itvnue.Training.project.Models;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "attachment")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "file_size")
    private Double fileSize;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "attachment_no")
    private int attachmentNo;

    @NotNull
    @Column(name = "url")
    private String url;

    //Relationships
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private Invoice parentInvoice;

    public Invoice getParentInvoice() {
        return parentInvoice;
    }

    public void setParentInvoice(Invoice parentInvoice) {
        this.parentInvoice = parentInvoice;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    @Column(name = "file_type")
    @Enumerated(EnumType.STRING)
    // Define the column as enum
    private FileType fileType;

    public Attachment() {

    }

    public Attachment(int id,
                      Double fileSize,
                      String fileName,
                      int attachmentNo,
                      String url,
                      Invoice parentInvoice,
                      FileType fileType) {
        this.id = id;
        this.fileSize = fileSize;
        this.fileName = fileName;
        this.attachmentNo = attachmentNo;
        this.url = url;
        this.parentInvoice = parentInvoice;
        this.fileType = fileType;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = FileType.valueOf(fileType);
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


    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", fileSize=" + fileSize +
                ", fileName='" + fileName + '\'' +
                ", attachmentNo=" + attachmentNo +
                ", url='" + url + '\'' +
                ", parentInvoice=" + parentInvoice +
                ", fileType=" + fileType +
                '}';
    }
}
