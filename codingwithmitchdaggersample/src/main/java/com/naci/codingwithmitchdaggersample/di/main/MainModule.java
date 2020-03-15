package com.naci.codingwithmitchdaggersample.di.main;

import com.naci.codingwithmitchdaggersample.network.main.MainApi;
import com.naci.codingwithmitchdaggersample.ui.main.posts.PostsRecyclerAdapter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    @Provides
    static PostsRecyclerAdapter providePostsRecyclerAdapter(){
        return new PostsRecyclerAdapter();
    }

    @Provides
    static MainApi provideMainApi(Retrofit retrofit) {
        return retrofit.create(MainApi.class);
    }
}
