package com.example.naci.retrofitsample.network;

import com.example.naci.retrofitsample.network.model.AnimeModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface AnimeService {

    String ACCEPT = "Accept: application/vnd.api+json";
    String CONTENT_TYPE = "Content-Type: application/vnd.api+json";
    String ACCEPT_CHARSET = "Accept-Charset: utf-8";

    @Headers({ACCEPT, CONTENT_TYPE, ACCEPT_CHARSET})
    @GET("/api/edge/anime")
    Call<AnimeModel> getAnimeListByGenre(@Query("filter[genres]") String genres);
}
