package com.example.naci.retrofitsample.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AnimeModel {
    @SerializedName("data")
    private List<AnimeData> animeList;

    public AnimeModel(List<AnimeData> animeList) {
        this.animeList = animeList;
    }

    public List<AnimeData> getAnimeList() {
        return animeList;
    }

    public void setAnimeList(List<AnimeData> animeList) {
        this.animeList = animeList;
    }
}
