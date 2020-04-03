package com.naci.codingwithmitchdaggersample.di;

import androidx.lifecycle.ViewModelProvider;

import com.naci.codingwithmitchdaggersample.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    // TODO EXPLANATION: BINDS AND PROVIDES ALMOST IDENTICAL.
    //  BUT BIND ANNOTATION USED FOR ONLY ABSTRACT METHODS (WITHOUT METHOD BODY)
    //  AND BIND ANNOTATION IS MORE EFFICIENT THAN PROVIDES ANNOTATION

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);
}
