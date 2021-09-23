package com.tispunshahryar960103.securityman.ui.databases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tispunshahryar960103.securityman.R;
import com.tispunshahryar960103.securityman.ui.databases.sqlite.SQliteActivity;

public class DatabaseActivity extends AppCompatActivity {

    AppCompatButton btn_sqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        btn_sqlite=findViewById(R.id.btn_sqlite);
        btn_sqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(), SQliteActivity.class);
                startActivity(intent);
            }
        });
    }
}