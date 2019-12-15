package com.naci.manual_di_tutorial.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.naci.manual_di_tutorial.data.local.dao.NoteDao;
import com.naci.manual_di_tutorial.data.local.entities.Note;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {

    public abstract NoteDao noteDao();
}
