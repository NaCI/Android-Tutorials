package com.naci.manual_di_tutorial.di;

import com.naci.manual_di_tutorial.App;
import com.naci.manual_di_tutorial.data.UserRepository;
import com.naci.manual_di_tutorial.data.local.UserLocalDataSource;
import com.naci.manual_di_tutorial.data.local.repository.NoteRepository;
import com.naci.manual_di_tutorial.data.remote.UserRemoteDataSource;
import com.naci.manual_di_tutorial.ui.factory.MainViewModelFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppContainer {

    // Since you want to expose userRepository out of the container, you need to satisfy
    // its dependencies as you did before
    private Retrofit retrofit = new retrofit2.Retrofit.Builder()
            .baseUrl("https://example.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private NoteRepository noteRepository = new NoteRepository(App.getContext());

    private UserRemoteDataSource remoteDataSource = new UserRemoteDataSource(retrofit);
    private UserLocalDataSource localDataSource = new UserLocalDataSource(noteRepository);

    // userRepository is not private; it'll be exposed
    public UserRepository userRepository = new UserRepository(localDataSource, remoteDataSource);

    public MainViewModelFactory mainViewModelFactory = new MainViewModelFactory(userRepository);

}
