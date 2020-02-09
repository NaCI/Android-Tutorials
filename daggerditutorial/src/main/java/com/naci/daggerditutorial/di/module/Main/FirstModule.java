package com.naci.daggerditutorial.di.module.Main;

import com.naci.daggerditutorial.di.scope.MainScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class FirstModule {
    @Provides
    @MainScope
    @Named("FirstModule")
    String providesString() {
        return "FirstModule String";
    }
}
