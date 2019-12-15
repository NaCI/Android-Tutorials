package com.example.naci.retrofitsample.ui.main;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.naci.retrofitsample.R;
import com.example.naci.retrofitsample.databinding.MainFragmentBinding;
import com.example.naci.retrofitsample.network.model.NumberData;
import com.example.naci.retrofitsample.ui.adapters.AdapterNumberData;
import com.example.naci.retrofitsample.ui.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class MainFragment extends BaseFragment<MainFragmentBinding> {

    @BindView(R.id.mainFragment_rvNumberData)
    RecyclerView rvNumberData;

    private MainViewModel mViewModel;
    private AdapterNumberData adapterNumberData;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.main_fragment;
    }

    @Override
    protected boolean shouldUseButterKnife() {
        return true;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
        /*View view = inflater.inflate(R.layout.main_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;*/
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        setLiveDataObserver();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepareRecyclerView();
    }

    @OnClick(R.id.mainFragment_btnFetchNumberData)
    public void onFetchClicked() {
        mViewModel.getNumberDataRequest();
    }

    public void prepareRecyclerView() {
        rvNumberData.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvNumberData.addItemDecoration(new DividerItemDecoration(rvNumberData.getContext(), DividerItemDecoration.VERTICAL));
        rvNumberData.setItemAnimator(new DefaultItemAnimator());
        adapterNumberData = new AdapterNumberData(new ArrayList<>());
        rvNumberData.setAdapter(adapterNumberData);
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

        mViewModel.numberDataResponse.observe(this, object -> {
            if (object instanceof NumberData) {
                setAdapter((NumberData) object);
            } else if (object instanceof Throwable) {
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAdapter(NumberData body) {
        //for(NumberData numberData : body) {
        adapterNumberData.addNewNumber(body);
        //}
    }

}
