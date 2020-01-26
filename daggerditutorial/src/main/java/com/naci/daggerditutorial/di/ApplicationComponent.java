package com.naci.daggerditutorial.di;

import com.naci.daggerditutorial.di.module.AppModule;
import com.naci.daggerditutorial.di.module.NetworkModule;
import com.naci.daggerditutorial.di.module.ViewModelModule;
import com.naci.daggerditutorial.ui.main.MainActivity;
import com.naci.daggerditutorial.ui.main.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AppModule.class,
                NetworkModule.class,
                ViewModelModule.class
        }
)
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(MainFragment mainFragment);
}
