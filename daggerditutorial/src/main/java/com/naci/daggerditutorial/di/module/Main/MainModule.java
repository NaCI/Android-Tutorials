package com.naci.daggerditutorial.di.module.Main;

import com.naci.daggerditutorial.di.scope.MainScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    @MainScope
    @Named("MainModule")
    String providesString() {
        return "MainModule String";
    }
}
