package com.example.naci.retrofitsample.listeners;

import com.example.naci.retrofitsample.network.model.AnimeData;

public interface OnAnimeItemClickListener extends BaseItemClickListener {
    void onAnimeDetailClicked(AnimeData anime);
}
