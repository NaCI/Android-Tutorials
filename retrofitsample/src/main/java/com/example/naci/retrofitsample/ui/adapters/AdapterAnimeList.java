package com.example.naci.retrofitsample.ui.adapters;

import android.view.ViewGroup;

import com.example.naci.retrofitsample.R;
import com.example.naci.retrofitsample.listeners.OnAnimeItemClickListener;
import com.example.naci.retrofitsample.network.model.AnimeData;
import com.example.naci.retrofitsample.ui.base.BaseAdapter;

import java.util.List;

public class AdapterAnimeList extends BaseAdapter {

    private List<AnimeData> animeList;
    private final OnAnimeItemClickListener onAnimeItemClickListener;

    public AdapterAnimeList(List<AnimeData> animeList, OnAnimeItemClickListener onAnimeItemClickListener) {
        this.animeList = animeList;
        this.onAnimeItemClickListener = onAnimeItemClickListener;
    }

    @Override
    public Object getDataAtPosition(int position) {
        return animeList.get(position);
    }

    @Override
    public int getLayoutIdForType(int viewType) {
        return R.layout.item_anime;
    }

    /*@Override
    public BaseItemClickListener getOnItemClickListener() {
        return onAnimeItemClickListener;
    }*/

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = super.onCreateViewHolder(parent, viewType);
        myViewHolder.bindListener(onAnimeItemClickListener);
        return myViewHolder;
    }
}
