package com.example.naci.retrofitsample.ui.main;

import android.arch.lifecycle.ViewModel;

import com.example.naci.retrofitsample.App;
import com.example.naci.retrofitsample.network.NumberDataService;
import com.example.naci.retrofitsample.network.model.NumberData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel


    void getNumberDataRequest() {
        NumberDataService service = App.getRetrofitInstance().create(NumberDataService.class);
        Call<NumberData> call = service.getRandonNumberData();
        call.enqueue(new Callback<NumberData>() {
            @Override
            public void onResponse(Call<NumberData> call, Response<NumberData> response) {

            }

            @Override
            public void onFailure(Call<NumberData> call, Throwable t) {

            }
        });
    }
}
