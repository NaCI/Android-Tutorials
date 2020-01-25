package com.naci.daggerditutorial;

import android.app.Application;

import androidx.annotation.StringRes;

import com.naci.daggerditutorial.di.ApplicationComponent;
import com.naci.daggerditutorial.di.DaggerApplicationComponent;
import com.naci.daggerditutorial.di.module.AppModule;
import com.naci.daggerditutorial.di.module.NetworkModule;

public class MyApplication extends Application {

    //public ApplicationComponent applicationComponent = DaggerApplicationComponent.create();
    private static MyApplication instance;
    private ApplicationComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (instance == null) {
            instance = this;
        }

        // Dagger%COMPONENT_NAME%
        mAppComponent = DaggerApplicationComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .networkModule(new NetworkModule(BuildConfig.BASE_URL))
                .build();

        // If a Dagger 2 component does not have any constructor arguments for any of its modules,
        // then we can use .create() as a shortcut instead:
        //  mAppComponent = com.codepath.dagger.components.DaggerAppComponent.create();
    }

    public static String getStringById(@StringRes int id, Object... objects) {
        if (instance == null) {
            return null;
        }
        return instance.getApplicationContext().getString(id, objects);
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public ApplicationComponent getAppComponent() {
        return mAppComponent;
    }
}
