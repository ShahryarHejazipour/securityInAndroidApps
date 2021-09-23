package com.tispunshahryar960103.securityman.ui.databases.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.tispunshahryar960103.securityman.R;

public class SQliteActivity extends AppCompatActivity {

    AppCompatEditText edt_title,edt_description;
    AppCompatButton btn_save;
    ListView lst_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        edt_title=findViewById(R.id.edt_title);
        edt_description=findViewById(R.id.edt_description);
        btn_save=findViewById(R.id.btn_save);
        lst_data=findViewById(R.id.lst_data);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }
}