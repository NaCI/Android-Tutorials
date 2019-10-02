package com.example.naci.retrofitsample.ui.main;

import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.naci.retrofitsample.App;
import com.example.naci.retrofitsample.R;
import com.example.naci.retrofitsample.network.NumberDataService;
import com.example.naci.retrofitsample.network.model.NumberData;
import com.example.naci.retrofitsample.ui.adapters.AdapterNumberData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {

    @BindView(R.id.mainFragment_rvNumberData)
    RecyclerView rvNumberData;

    private MainViewModel mViewModel;
    private ProgressDialog progressDialog;
    private AdapterNumberData adapterNumberData;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepareRecyclerView();
    }

    @OnClick(R.id.mainFragment_btnFetchNumberData)
    public void onFetchClicked() {
        getRandomNumberDataRequest();
    }

    public void prepareRecyclerView() {
        rvNumberData.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvNumberData.addItemDecoration(new DividerItemDecoration(rvNumberData.getContext(), DividerItemDecoration.VERTICAL));
        rvNumberData.setItemAnimator(new DefaultItemAnimator());
        adapterNumberData = new AdapterNumberData(new ArrayList<>());
        rvNumberData.setAdapter(adapterNumberData);
    }

    public void getRandomNumberDataRequest() {

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        NumberDataService service = App.getRetrofitInstance().create(NumberDataService.class);
        Call<NumberData> call = service.getRandonNumberData();
        call.enqueue(new Callback<NumberData>() {
            @Override
            public void onResponse(Call<NumberData> call, Response<NumberData> response) {
                progressDialog.dismiss();
                if (response.body() != null) {
                    setAdapter(response.body());
                }
            }

            @Override
            public void onFailure(Call<NumberData> call, Throwable t) {
                progressDialog.dismiss();
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
