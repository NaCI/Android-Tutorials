package com.example.naci.retrofitsample.network;

import com.example.naci.retrofitsample.network.model.NumberData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NumberDataService {

    @GET("/random/trivia?json")
    Call<NumberData> getRandonNumberData();
}
