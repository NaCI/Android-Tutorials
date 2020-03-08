package com.naci.codingwithmitchdaggersample.ui.auth;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.naci.codingwithmitchdaggersample.R;
import com.naci.codingwithmitchdaggersample.ui.main.MainActivity;
import com.naci.codingwithmitchdaggersample.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity implements View.OnClickListener {

    private static final String TAG = "AuthActivity";

    private AuthViewModel authViewModel;

    private ProgressBar progressBar;
    private EditText etUserId;

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
        etUserId = findViewById(R.id.user_id_input);
        progressBar = findViewById(R.id.progress_bar);

        findViewById(R.id.login_button).setOnClickListener(this);

        Log.d(TAG, "onCreate: myBaseUrl : " + myBaseUrl);
        Log.d(TAG, "onCreate: isAppNull : " + isAppNull);

        authViewModel = new ViewModelProvider(this, viewModelProviderFactory).get(AuthViewModel.class);

        setLogo();

        subscribeObservers();
    }

    private void subscribeObservers() {
        authViewModel.observeAuthUserState().observe(this, userAuthResource -> {
            if (userAuthResource == null) {
                return;
            }
            switch (userAuthResource.status) {
                case LOADING: {
                    showProgressBar(true);
                    break;
                }
                case AUTHENTICATED: {
                    showProgressBar(false);
                    Log.d(TAG, "AUTHENTICATED : " + userAuthResource.data.getEmail());
                    navigateToMain();
                    break;
                }
                case ERROR: {
                    showProgressBar(false);
                    Toast.makeText(AuthActivity.this, userAuthResource.message + "\nEnter number between 1-10", Toast.LENGTH_SHORT).show();
                    break;
                }
                case NOT_AUTHENTICATED: {
                    showProgressBar(false);
                    break;
                }

            }
        });
        /*authViewModel.observeUser().observe(this, user -> {
            if(user != null) {
                Log.d(TAG, "onChanged : " + user.getEmail());
            }
        });*/
    }

    private void navigateToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void showProgressBar(boolean isVisible) {
        if (isVisible) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    private void setLogo() {
        requestManager
                .load(logo)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into((ImageView) findViewById(R.id.login_logo));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button: {
                attempLogin();
                break;
            }
        }
    }

    private void attempLogin() {
        if (TextUtils.isEmpty(etUserId.getText().toString())) {
            return;
        }
        authViewModel.authenticateWithId(Integer.parseInt(etUserId.getText().toString()));
    }
}
