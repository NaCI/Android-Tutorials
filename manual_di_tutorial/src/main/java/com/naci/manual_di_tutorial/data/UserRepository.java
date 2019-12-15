package com.naci.manual_di_tutorial.data;

import com.naci.manual_di_tutorial.data.local.UserLocalDataSource;
import com.naci.manual_di_tutorial.data.remote.UserRemoteDataSource;

public class UserRepository {

    private final UserLocalDataSource userLocalDataSource;
    private final UserRemoteDataSource userRemoteDataSource;

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
