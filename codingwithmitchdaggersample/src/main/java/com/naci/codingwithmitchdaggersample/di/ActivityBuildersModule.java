package com.naci.codingwithmitchdaggersample.di;

import com.naci.codingwithmitchdaggersample.di.auth.AuthModule;
import com.naci.codingwithmitchdaggersample.di.auth.AuthViewModelsModule;
import com.naci.codingwithmitchdaggersample.di.main.MainFragmentBuildersModule;
import com.naci.codingwithmitchdaggersample.di.main.MainModule;
import com.naci.codingwithmitchdaggersample.di.main.MainViewModelsModule;
import com.naci.codingwithmitchdaggersample.ui.auth.AuthActivity;
import com.naci.codingwithmitchdaggersample.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = {AuthViewModelsModule.class, AuthModule.class})
    abstract AuthActivity contributeAuthActivity();

    @ContributesAndroidInjector(modules = {MainFragmentBuildersModule.class, MainViewModelsModule.class, MainModule.class})
    abstract MainActivity contributeMainActivity();

}
