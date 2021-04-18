package com.example.newnotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Entity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newnotesapp.Database.Database;
import com.example.newnotesapp.Database.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CreateNote extends AppCompatActivity {
EditText title_edit_text,note_edite_text;
FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
        title_edit_text = (EditText)findViewById(R.id.titleedittext);
        note_edite_text = (EditText)findViewById(R.id.noteedittext);
        floatingActionButton = (FloatingActionButton)findViewById(R.id.createnote_floatingactionbutton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }

    public void insertData()
    {
       Note note = new Note(title_edit_text.getText().toString(),note_edite_text.getText().toString());
       InsertAsyncTask insertAsyncTask = new InsertAsyncTask();
       insertAsyncTask.execute(note);
        Toast.makeText(this,"Done",Toast.LENGTH_SHORT).show();
    }

    class InsertAsyncTask extends AsyncTask<Note,Void,Void>
    {

        @Override
        protected Void doInBackground(Note... notes) {
            Database.getInstance(getApplicationContext()).noteDao().insert(notes[0]);
            return null;
        }
    }

}