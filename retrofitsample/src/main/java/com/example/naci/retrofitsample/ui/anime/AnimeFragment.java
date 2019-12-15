package com.example.naci.retrofitsample.ui.anime;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.naci.retrofitsample.R;
import com.example.naci.retrofitsample.databinding.AnimeFragmentBinding;
import com.example.naci.retrofitsample.listeners.OnAnimeItemClickListener;
import com.example.naci.retrofitsample.network.model.AnimeData;
import com.example.naci.retrofitsample.network.model.AnimeModel;
import com.example.naci.retrofitsample.ui.adapters.AdapterAnimeList;
import com.example.naci.retrofitsample.ui.base.BaseFragment;

public class AnimeFragment extends BaseFragment<AnimeFragmentBinding> implements OnAnimeItemClickListener {

    private AnimeViewModel mViewModel;
    private AdapterAnimeList adapterAnimeList;

    public static AnimeFragment newInstance() {
        return new AnimeFragment();
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.anime_fragment;
    }

    @Override
    protected boolean shouldUseButterKnife() {
        return false;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AnimeViewModel.class);
        setLiveDataObserver();
        viewDataBinding.setViewModel(mViewModel);
        viewDataBinding.setPageData(new AnimeFragmentPageData());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepareRecyclerView();
    }

    public void prepareRecyclerView() {
        viewDataBinding.animeFragmentRvAnimeList.setHasFixedSize(true);
        viewDataBinding.animeFragmentRvAnimeList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        viewDataBinding.animeFragmentRvAnimeList.addItemDecoration(new DividerItemDecoration(viewDataBinding.animeFragmentRvAnimeList.getContext(), DividerItemDecoration.VERTICAL));
        viewDataBinding.animeFragmentRvAnimeList.setItemAnimator(new DefaultItemAnimator());
    }

    private void setLiveDataObserver() {
        mViewModel.showProgress.observe(this, isSHow -> {
            if (isSHow == null) {
                return;
            }

            if (isSHow) {
                showProgressDialog();
            } else {
                hideProgressDialog();
            }
        });

        mViewModel.animeListResponse.observe(this, object -> {
            if (object instanceof AnimeModel) {
                setAdapter((AnimeModel) object);
            } else if (object instanceof Throwable) {
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAdapter(AnimeModel body) {
        adapterAnimeList = new AdapterAnimeList(body.getAnimeList(), this);
        viewDataBinding.animeFragmentRvAnimeList.setAdapter(adapterAnimeList);
    }

/*
    @Override
    public void onItemClicked(View view, Object item, int pos) {
        Toast.makeText(getActivity(), "Data position : " + pos + "\n" + ((AnimeData) item).toString(), Toast.LENGTH_LONG).show();
    }
*/

    @Override
    public void onAnimeDetailClicked(AnimeData anime) {
        Toast.makeText(getActivity(), ((AnimeData) anime).toString(), Toast.LENGTH_LONG).show();
    }
}
