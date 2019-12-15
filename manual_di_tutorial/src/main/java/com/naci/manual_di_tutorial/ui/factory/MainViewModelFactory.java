package com.naci.manual_di_tutorial.ui.factory;

import com.naci.manual_di_tutorial.data.UserRepository;
import com.naci.manual_di_tutorial.ui.main.MainViewModel;

public class MainViewModelFactory implements Factory<MainViewModel> {

    private final UserRepository userRepository;

    public MainViewModelFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public MainViewModel create() {
        return new MainViewModel(userRepository);
    }
}
