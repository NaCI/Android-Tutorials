package com.naci.manual_di_tutorial.data.remote;

import retrofit2.Retrofit;

public class UserRemoteDataSource {

    private final Retrofit retrofit;

    public UserRemoteDataSource(Retrofit retrofit) {
        this.retrofit = retrofit;
    }
}
