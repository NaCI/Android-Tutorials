package com.naci.codingwithmitchdaggersample.di.auth;

import com.naci.codingwithmitchdaggersample.models.User;
import com.naci.codingwithmitchdaggersample.network.auth.AuthApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {

    @AuthScope
    @Provides
    static AuthApi provideAuthApi(Retrofit retrofit) {
        return retrofit.create(AuthApi.class);
    }

    @AuthScope
    @Provides
    User provideUser() {
        return new User();
    }

}
