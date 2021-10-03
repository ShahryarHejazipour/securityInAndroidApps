package com.tispunshahryar960103.securityman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tispunshahryar960103.securityman.ui.webService.WebServiceActivity;
import com.tispunshahryar960103.securityman.ui.databases.DatabaseActivity;
import com.tispunshahryar960103.securityman.ui.input.InputValueActivity;
import com.tispunshahryar960103.securityman.ui.permissions.PermisionActivity;
import com.tispunshahryar960103.securityman.ui.sharedPref.SharedPreferencesActivity;

public class MainActivity extends AppCompatActivity {


    AppCompatButton btn_input,btn_permission,btn_shared_perf,btn_database,btn_web_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_input=findViewById(R.id.btn_input);
        btn_permission=findViewById(R.id.btn_permission);
        btn_shared_perf=findViewById(R.id.btn_shared_perf);
        btn_database=findViewById(R.id.btn_database);
        btn_web_service=findViewById(R.id.btn_web_service);

        btn_permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), PermisionActivity.class);
                startActivity(intent);
            }
        });

        btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(), InputValueActivity.class);
                startActivity(intent);

            }
        });

        btn_shared_perf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), SharedPreferencesActivity.class);
                startActivity(intent);
            }
        });

        btn_database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(), DatabaseActivity.class);
                startActivity(intent);

            }
        });

        btn_web_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), WebServiceActivity.class);
                startActivity(intent);
            }
        });


    }
}