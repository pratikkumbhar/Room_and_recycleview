package com.example.newnotesapp.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newnotesapp.Database.Note;
import com.example.newnotesapp.R;

import java.util.ArrayList;
import java.util.List;

public class NoteAdaptor extends RecyclerView.Adapter<NoteAdaptor.NoteHolder>{

    List<Note> notelist = new ArrayList<>();

    public NoteAdaptor(List<Note> notelist) {
        this.notelist = notelist;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.container,parent,false);
        return new NoteHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        holder.title.setText(notelist.get(position).getTitle());
        holder.note.setText(notelist.get(position).getNote());
    }

    @Override
    public int getItemCount() {
        return notelist.size();
    }
    public void setnote (List<Note> notes)
    {
        this.notelist = notes;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder{
        private TextView title,note;
        public NoteHolder(@NonNull View itemView) {

            super(itemView);
            title = itemView.findViewById(R.id.container_title);
            note = itemView.findViewById(R.id.container_note);
        }
    }

}
