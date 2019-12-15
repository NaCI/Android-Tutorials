package com.naci.daggerditutorial.data.remote;

import javax.inject.Inject;

public class UserRemoteDataSource {
    private final LoginRetrofitService loginRetrofitService;

    @Inject
    public UserRemoteDataSource(LoginRetrofitService loginRetrofitService) {
        this.loginRetrofitService = loginRetrofitService;
    }

    public LoginRetrofitService getLoginRetrofitService() {
        return loginRetrofitService;
    }
}
