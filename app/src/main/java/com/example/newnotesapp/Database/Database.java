package com.example.newnotesapp.Database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Note.class},version = 1)
public abstract class Database extends RoomDatabase {

    public abstract Dao noteDao();

    private static volatile Database instance;

    public static Database getInstance(Context context)
    {
        if(instance == null)
        {
            synchronized (Database.class)
            {
                if(instance == null)
                {
                    instance = Room.databaseBuilder(context.getApplicationContext(),Database.class,"NoteDatabase").build();
                }
            }
        }
        return instance;
    }


}
