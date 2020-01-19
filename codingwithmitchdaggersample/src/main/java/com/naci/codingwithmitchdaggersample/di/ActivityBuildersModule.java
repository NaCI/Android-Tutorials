package com.naci.codingwithmitchdaggersample.di;

import com.naci.codingwithmitchdaggersample.AuthActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();

    @Provides
    static String baseUrl() {
        return "https://google.com";
    }
}
