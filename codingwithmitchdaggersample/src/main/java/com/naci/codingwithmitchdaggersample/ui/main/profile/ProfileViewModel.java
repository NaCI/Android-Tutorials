package com.naci.codingwithmitchdaggersample.ui.main.profile;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.naci.codingwithmitchdaggersample.SessionManager;
import com.naci.codingwithmitchdaggersample.models.User;
import com.naci.codingwithmitchdaggersample.ui.auth.AuthResource;

import javax.inject.Inject;

public class ProfileViewModel extends ViewModel {

    private static final String TAG = "ProfileViewModel";

    private final SessionManager sessionManager;

    @Inject
    public ProfileViewModel(SessionManager sessionManager) {
        Log.d(TAG, "ProfileViewModel: viewmodel is ready...");
        this.sessionManager = sessionManager;
    }

    public LiveData<AuthResource<User>> getAuthUser() {
        return sessionManager.getAuthUser();
    }
}
