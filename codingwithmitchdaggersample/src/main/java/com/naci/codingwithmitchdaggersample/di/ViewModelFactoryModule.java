package com.naci.codingwithmitchdaggersample.di;

import androidx.lifecycle.ViewModelProvider;

import com.naci.codingwithmitchdaggersample.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);
}
