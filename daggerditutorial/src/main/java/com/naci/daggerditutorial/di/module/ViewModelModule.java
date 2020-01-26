package com.naci.daggerditutorial.di.module;

import androidx.lifecycle.ViewModel;

import com.naci.daggerditutorial.di.ViewModelKey;
import com.naci.daggerditutorial.ui.main.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);
}
