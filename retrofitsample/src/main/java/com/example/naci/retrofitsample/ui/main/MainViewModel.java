package com.example.naci.retrofitsample.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.naci.retrofitsample.App;
import com.example.naci.retrofitsample.network.NumberDataService;
import com.example.naci.retrofitsample.network.model.NumberData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    public final MutableLiveData<Object> numberDataResponse = new MutableLiveData<>();
    public final MutableLiveData<Boolean> showProgress = new MutableLiveData<>();


    void getNumberDataRequest() {
        showProgress.setValue(true);
        NumberDataService service = App.getRetrofitInstance().create(NumberDataService.class);
        Call<NumberData> call = service.getRandonNumberData();
        call.enqueue(new Callback<NumberData>() {
            @Override
            public void onResponse(Call<NumberData> call, Response<NumberData> response) {
                if (response.body() != null) {
                    numberDataResponse.setValue(response.body());
                }
                showProgress.setValue(false);
            }

            @Override
            public void onFailure(Call<NumberData> call, Throwable t) {
                numberDataResponse.setValue(t);
                showProgress.setValue(false);
            }
        });
    }
}
