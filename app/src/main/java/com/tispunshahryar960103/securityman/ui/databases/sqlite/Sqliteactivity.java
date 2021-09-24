package com.tispunshahryar960103.securityman.ui.databases.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.tispunshahryar960103.securityman.R;

import java.util.List;

public class Sqliteactivity extends AppCompatActivity {

    AppCompatEditText edt_title,edt_description;
    AppCompatButton btn_save;
    ListView lst_data;
    NoteDatabase noteDatabase;
    NoteDBAdapter noteDBAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        edt_title=findViewById(R.id.edt_title);
        edt_description=findViewById(R.id.edt_description);
        btn_save=findViewById(R.id.btn_save);
        lst_data=findViewById(R.id.lst_data);

        noteDatabase=new NoteDatabase(getApplicationContext());
        noteDBAdapter=new NoteDBAdapter(getApplicationContext());

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Note note=new Note();
                note.setTitle(edt_title.getText().toString());
                note.setDescription(edt_description.getText().toString());
               long result = noteDBAdapter.insertt(note);

               if (result>0){

                   Toast.makeText(getApplicationContext(), R.string.DONE, Toast.LENGTH_SHORT).show();
                   showAllNotes();

               }else {

                   Toast.makeText(getApplicationContext(), R.string.failed, Toast.LENGTH_SHORT).show();

               }



            }
        });

        showAllNotes();
    }

    private void showAllNotes(){

        List<String> noteList = noteDBAdapter.getTitles();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1
        ,noteList);

        lst_data.setAdapter(adapter);

    }
}