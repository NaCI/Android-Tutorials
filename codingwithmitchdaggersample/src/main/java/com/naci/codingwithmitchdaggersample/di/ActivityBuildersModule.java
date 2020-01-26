package com.naci.codingwithmitchdaggersample.di;

import com.naci.codingwithmitchdaggersample.di.auth.AuthViewModelsModule;
import com.naci.codingwithmitchdaggersample.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector( modules = {AuthViewModelsModule.class})
    abstract AuthActivity contributeAuthActivity();

}
