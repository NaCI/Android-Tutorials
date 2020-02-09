package com.naci.daggerditutorial.di.module.Main;

import com.naci.daggerditutorial.di.scope.MainScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class SecondModule {
    @Provides
    @MainScope
    @Named("SecondModule")
    String providesString() {
        return "SecondModule String";
    }
}
