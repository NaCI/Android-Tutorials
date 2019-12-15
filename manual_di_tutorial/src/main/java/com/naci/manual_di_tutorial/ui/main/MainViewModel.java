package com.naci.manual_di_tutorial.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.naci.manual_di_tutorial.data.UserRepository;
import com.naci.manual_di_tutorial.data.local.entities.Note;

import java.util.List;
import java.util.Locale;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private final UserRepository userRepository;

    public MainViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LiveData<List<Note>> getSomeData() {
        return userRepository.getUserLocalDataSource().getNoteRepository().getTasks();
    }

    public boolean addSomeData() {
        int randomNumber = (int)Math.random() * 1000;
        String noteTitle = String.format(Locale.getDefault(), "Random Note %d",randomNumber);
        userRepository.getUserLocalDataSource().getNoteRepository().insertTask(noteTitle,"Random Description");
        return true;
    }
}
