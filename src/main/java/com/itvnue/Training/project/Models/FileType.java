package com.itvnue.Training.project.Models;

public enum FileType {



    Image("Image"),
    PDF("PDF"),
    WebForm("WebForm");

    public final String FileTypeLabel;

    private FileType(String FileTypeLabel) {
        this.FileTypeLabel = FileTypeLabel;
    }


    }
