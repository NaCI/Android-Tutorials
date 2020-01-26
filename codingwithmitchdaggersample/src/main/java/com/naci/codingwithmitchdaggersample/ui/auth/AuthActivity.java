package com.naci.codingwithmitchdaggersample.ui.auth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.naci.codingwithmitchdaggersample.R;
import com.naci.codingwithmitchdaggersample.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {

    private static final String TAG = "AuthActivity";

    private AuthViewModel authViewModel;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    @Inject
    String myBaseUrl;

    @Inject
    boolean isAppNull;

    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        Log.d(TAG, "onCreate: myBaseUrl : " + myBaseUrl);
        Log.d(TAG, "onCreate: isAppNull : " + isAppNull);

        authViewModel = new ViewModelProvider(this, viewModelProviderFactory).get(AuthViewModel.class);

        setLogo();
    }

    private void setLogo() {
        requestManager
                .load(logo)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into((ImageView) findViewById(R.id.login_logo));
    }
}
