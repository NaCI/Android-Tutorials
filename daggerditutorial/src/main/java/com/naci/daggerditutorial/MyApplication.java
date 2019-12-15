package com.naci.daggerditutorial;

import android.app.Application;

import androidx.annotation.StringRes;

import com.naci.daggerditutorial.di.ApplicationComponent;
import com.naci.daggerditutorial.di.DaggerApplicationComponent;

public class MyApplication extends Application {

    public ApplicationComponent applicationComponent = DaggerApplicationComponent.create();
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        if (instance == null) {
            instance = this;
        }
    }

    public static String getStringById(@StringRes int id, Object... objects) {
        if (instance == null) {
            return null;
        }
        return instance.getApplicationContext().getString(id, objects);
    }
}
