package com.naci.codingwithmitchdaggersample;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.naci.codingwithmitchdaggersample.models.User;
import com.naci.codingwithmitchdaggersample.ui.auth.AuthResource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SessionManager {
    private static final String TAG = SessionManager.class.getSimpleName();

    private MediatorLiveData<AuthResource<User>> cachedUser = new MediatorLiveData<>();

    @Inject
    public SessionManager() {
    }

    public void authenticateWithId(final LiveData<AuthResource<User>> source) {
        if(cachedUser == null) {
            return;
        }

        cachedUser.setValue(AuthResource.loading());
        cachedUser.addSource(source, userAuthResource -> {
            cachedUser.setValue(userAuthResource);
            cachedUser.removeSource(source);
        });
    }

    public void logOut() {
        Log.d(TAG, "logOut: logging out..");
        cachedUser.setValue(AuthResource.logout());
    }

    public MediatorLiveData<AuthResource<User>> getAuthUser() {
        return cachedUser;
    }
}
