package com.naci.codingwithmitchdaggersample.di;

import com.naci.codingwithmitchdaggersample.di.auth.AuthModule;
import com.naci.codingwithmitchdaggersample.di.auth.AuthScope;
import com.naci.codingwithmitchdaggersample.di.auth.AuthViewModelsModule;
import com.naci.codingwithmitchdaggersample.di.main.MainFragmentBuildersModule;
import com.naci.codingwithmitchdaggersample.di.main.MainModule;
import com.naci.codingwithmitchdaggersample.di.main.MainScope;
import com.naci.codingwithmitchdaggersample.di.main.MainViewModelsModule;
import com.naci.codingwithmitchdaggersample.ui.auth.AuthActivity;
import com.naci.codingwithmitchdaggersample.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(modules = {AuthViewModelsModule.class, AuthModule.class})
    abstract AuthActivity contributeAuthActivity();

    @MainScope
    @ContributesAndroidInjector(modules = {MainFragmentBuildersModule.class, MainViewModelsModule.class, MainModule.class})
    abstract MainActivity contributeMainActivity();

}
