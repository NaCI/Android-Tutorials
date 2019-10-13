package com.example.naci.retrofitsample.network.model;

import com.google.gson.annotations.SerializedName;

public class AnimeData {
    @SerializedName("id")
    private String id;
    @SerializedName("type")
    private String type;
    @SerializedName("attributes")
    private AnimeAttributesData detail;

    public AnimeData(String id, String type, AnimeAttributesData detail) {
        this.id = id;
        this.type = type;
        this.detail = detail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AnimeAttributesData getDetail() {
        return detail;
    }

    public void setDetail(AnimeAttributesData detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "AnimeData{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", detail=" + detail +
                '}';
    }
}
