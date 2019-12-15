package com.naci.daggerditutorial.data.remote;

import com.naci.daggerditutorial.data.remote.model.NumberData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LoginRetrofitService {

    @GET("/random/trivia?json")
    Call<NumberData> getRandonNumberData();

}
