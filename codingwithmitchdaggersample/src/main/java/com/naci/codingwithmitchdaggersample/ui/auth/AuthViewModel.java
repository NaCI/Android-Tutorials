package com.naci.codingwithmitchdaggersample.ui.auth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.naci.codingwithmitchdaggersample.SessionManager;
import com.naci.codingwithmitchdaggersample.models.User;
import com.naci.codingwithmitchdaggersample.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    private static String TAG = AuthViewModel.class.getSimpleName();

    private static MediatorLiveData<AuthResource<User>> authUser = new MediatorLiveData<>();

    private final AuthApi authApi;

    private SessionManager sessionManager;

    @Inject
    public AuthViewModel(AuthApi authApi, SessionManager sessionManager) {
        Log.d(TAG, "AuthViewModel: is working..");
        this.authApi = authApi;
        this.sessionManager = sessionManager;
    }

    public void authenticateWithId(int userId) {
        authUser.setValue(AuthResource.loading());

        sessionManager.authenticateWithId(getSource(userId));
    }

    private LiveData<AuthResource<User>> getSource(int userId) {
        return LiveDataReactiveStreams.fromPublisher(
                authApi.getUser(userId)
                        .onErrorReturn(throwable -> {
                            User errorUser = new User();
                            errorUser.setId(-1);
                            return errorUser;
                        })
                        .map((Function<User, AuthResource<User>>) user -> {
                            if (user.getId() == -1) {
                                return AuthResource.error("Could not authenticate", null);
                            }
                            return AuthResource.authenticated(user);
                        })
                        .subscribeOn(Schedulers.io())
        );
    }

    public LiveData<AuthResource<User>> observeAuthUserState() {
        return sessionManager.getAuthUser();
    }
}
