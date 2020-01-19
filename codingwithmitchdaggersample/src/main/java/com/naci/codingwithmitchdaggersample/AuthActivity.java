package com.naci.codingwithmitchdaggersample;

import android.os.Bundle;

import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
    }
}
