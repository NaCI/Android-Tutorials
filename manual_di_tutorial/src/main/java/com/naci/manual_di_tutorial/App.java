package com.naci.manual_di_tutorial;

import android.app.Application;
import android.content.Context;

import com.naci.manual_di_tutorial.di.AppContainer;
import com.naci.manual_di_tutorial.ui.main.MainViewModel;

public class App extends Application {

    private static Context mContext;
    private MainViewModel mainViewModel;
    public AppContainer appContainer;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        appContainer = new AppContainer();
    }

    public static Context getContext() {
        return mContext;
    }

    // Instance of AppContainer that will be used by all the Activities of the app

}
