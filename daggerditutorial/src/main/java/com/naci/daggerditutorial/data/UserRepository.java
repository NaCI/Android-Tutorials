package com.naci.daggerditutorial.data;

import com.naci.daggerditutorial.data.local.UserLocalDataSource;
import com.naci.daggerditutorial.data.remote.UserRemoteDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserRepository {

    private final UserLocalDataSource userLocalDataSource;
    private final UserRemoteDataSource userRemoteDataSource;

    @Inject
    public UserRepository(UserLocalDataSource userLocalDataSource, UserRemoteDataSource userRemoteDataSource) {
        this.userLocalDataSource = userLocalDataSource;
        this.userRemoteDataSource = userRemoteDataSource;
    }

    public UserLocalDataSource getUserLocalDataSource() {
        return userLocalDataSource;
    }

    public UserRemoteDataSource getUserRemoteDataSource() {
        return userRemoteDataSource;
    }
}
