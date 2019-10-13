package com.example.naci.retrofitsample.network.model;

import com.google.gson.annotations.SerializedName;

public class AnimeAttributesData {
    @SerializedName("canonicalTitle")
    private String title;
    @SerializedName("synopsis")
    private String description;
    @SerializedName("status")
    private String status;
    @SerializedName("episodeCount")
    private int episodeCount;
    @SerializedName("episodeLength")
    private int episodeLength;
    @SerializedName("posterImage")
    private AnimePosterData posterData;

    public AnimeAttributesData(String title, String description, String status, int episodeCount, int episodeLength, AnimePosterData posterData) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.episodeCount = episodeCount;
        this.episodeLength = episodeLength;
        this.posterData = posterData;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }

    public void setEpisodeCount(int episodeCount) {
        this.episodeCount = episodeCount;
    }

    public int getEpisodeLength() {
        return episodeLength;
    }

    public void setEpisodeLength(int episodeLength) {
        this.episodeLength = episodeLength;
    }

    public AnimePosterData getPosterData() {
        return posterData;
    }

    public void setPosterData(AnimePosterData posterData) {
        this.posterData = posterData;
    }

    @Override
    public String toString() {
        return "AnimeAttributesData{" +
                "title='" + title + '\'' +
                ", episodeCount=" + episodeCount +
                ", episodeLength=" + episodeLength +
                '}';
    }
}
