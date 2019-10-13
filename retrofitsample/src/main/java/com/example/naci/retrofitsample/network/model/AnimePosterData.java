package com.example.naci.retrofitsample.network.model;

import com.google.gson.annotations.SerializedName;

public class AnimePosterData {
    @SerializedName("tiny")
    private String tinyImage;
    @SerializedName("small")
    private String smallImage;
    @SerializedName("original")
    private String originalImage;
    @SerializedName("medium")
    private String mediumImage;

    public AnimePosterData(String tinyImage, String smallImage, String originalImage, String mediumImage) {
        this.tinyImage = tinyImage;
        this.smallImage = smallImage;
        this.originalImage = originalImage;
        this.mediumImage = mediumImage;
    }

    public String getTinyImage() {
        return tinyImage;
    }

    public void setTinyImage(String tinyImage) {
        this.tinyImage = tinyImage;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public String getOriginalImage() {
        return originalImage;
    }

    public void setOriginalImage(String originalImage) {
        this.originalImage = originalImage;
    }

    public String getMediumImage() {
        return mediumImage;
    }

    public void setMediumImage(String mediumImage) {
        this.mediumImage = mediumImage;
    }
}
