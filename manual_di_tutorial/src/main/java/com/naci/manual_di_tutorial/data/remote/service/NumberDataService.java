package com.naci.manual_di_tutorial.data.remote.service;

import com.naci.manual_di_tutorial.data.remote.model.NumberData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NumberDataService {

    @GET("/random/trivia?json")
    Call<NumberData> getRandonNumberData();
}
