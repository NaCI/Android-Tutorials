package com.naci.daggerditutorial.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.naci.daggerditutorial.MyApplication;
import com.naci.daggerditutorial.R;
import com.naci.daggerditutorial.data.UserRepository;
import com.naci.daggerditutorial.data.remote.model.NumberData;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private final UserRepository userRepository;
    public MutableLiveData<Object> numberDataResponse = new MutableLiveData<>();
    public MutableLiveData<Boolean> showProgress = new MutableLiveData<>();

    @Inject
    public MainViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getAppName() {
        return MyApplication.getStringById(R.string.app_name);
    }

    void fetchNumberData() {
        showProgress.setValue(true);
        Call<NumberData> call = userRepository.getUserRemoteDataSource().getLoginRetrofitService().getRandonNumberData();
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
