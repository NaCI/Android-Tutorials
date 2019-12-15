package com.naci.manual_di_tutorial.data.local;

import com.naci.manual_di_tutorial.data.local.repository.NoteRepository;

public class UserLocalDataSource {

    private final NoteRepository noteRepository;

    public UserLocalDataSource(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public NoteRepository getNoteRepository() {
        return noteRepository;
    }
}
