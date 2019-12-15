package com.naci.daggerditutorial.di;

import com.naci.daggerditutorial.di.module.NetworkModule;
import com.naci.daggerditutorial.ui.main.MainActivity;
import com.naci.daggerditutorial.ui.main.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = NetworkModule.class)
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(MainFragment mainFragment);
}
