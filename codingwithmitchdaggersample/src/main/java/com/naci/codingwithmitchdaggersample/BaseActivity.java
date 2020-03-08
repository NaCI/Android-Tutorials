package com.naci.codingwithmitchdaggersample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.naci.codingwithmitchdaggersample.ui.auth.AuthActivity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Inject
    SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscribeObservers();
    }

    private void subscribeObservers() {
        sessionManager.getAuthUser().observe(this, userAuthResource -> {
            if (userAuthResource == null) {
                return;
            }
            switch (userAuthResource.status) {
                case LOADING: {
                    break;
                }
                case AUTHENTICATED: {
                    Log.d(TAG, "AUTHENTICATED : " + userAuthResource.data.getEmail());
                    break;
                }
                case ERROR: {
                    Log.e(TAG, "onCreate: error" + userAuthResource.message);
                    break;
                }
                case NOT_AUTHENTICATED: {
                    navigateToLogin();
                    break;
                }

            }
        });
    }

    public void navigateToLogin() {
        Intent intent = new Intent(this, AuthActivity.class);
        startActivity(intent);
        finish();
    }
}
