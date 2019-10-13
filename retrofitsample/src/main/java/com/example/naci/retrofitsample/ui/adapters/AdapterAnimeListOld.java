package com.example.naci.retrofitsample.ui.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;
import com.example.naci.retrofitsample.R;
import com.example.naci.retrofitsample.network.model.AnimeData;

import java.util.List;

public class AdapterAnimeListOld extends RecyclerView.Adapter<AdapterAnimeListOld.MyViewHolder> {

    private List<AnimeData> animeList;

    public AdapterAnimeListOld(List<AnimeData> animeList) {
        this.animeList = animeList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_anime, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        final AnimeData animeData = animeList.get(position);
        viewHolder.bind(animeData);
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private final ViewDataBinding binding;

        public MyViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object obj) {
            binding.setVariable(BR.item, obj);
            binding.executePendingBindings();
        }
    }
}
