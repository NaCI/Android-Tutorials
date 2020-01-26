package com.naci.codingwithmitchdaggersample.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {

    private static String TAG = AuthViewModel.class.getSimpleName();

    @Inject
    public AuthViewModel() {
        Log.d(TAG, "AuthViewModel: is working..");
    }
}
