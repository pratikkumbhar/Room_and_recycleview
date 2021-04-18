
package com.example.newnotesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.room.Room;

import android.content.Entity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.newnotesapp.Adaptor.NoteAdaptor;

import com.example.newnotesapp.Database.Database;
import com.example.newnotesapp.Database.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
FloatingActionButton floatingActionButton;
RecyclerView recyclerView;
List<Note> noteArrayList;
NoteAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingbutton);
        recyclerView = (RecyclerView)findViewById(R.id.recyceleview);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setHasFixedSize(true);
        noteArrayList = new ArrayList<>();
        getAllnotes();
        adaptor = new NoteAdaptor(noteArrayList);
        recyclerView.setAdapter(adaptor);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CreateNote.class));
            }
        });



    }
    public void getAllnotes()
    {

        new Thread(new Runnable() {
            @Override
            public void run() {
                noteArrayList = Database.getInstance(getApplicationContext()).noteDao().getallnotes();
            }
        }).start();
    }





}