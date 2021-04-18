package com.example.newnotesapp.Database;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Insert
    void insert(Note note);

    @Delete
    void delete(Note note);

    @Update
    void update(Note note);

    @Query("SELECT * FROM notetable ORDER BY id DESC")
    List<Note> getallnotes();

    @Query("SELECT * FROM notetable WHERE id LIKE :id")
    Note findid(int id);



}
