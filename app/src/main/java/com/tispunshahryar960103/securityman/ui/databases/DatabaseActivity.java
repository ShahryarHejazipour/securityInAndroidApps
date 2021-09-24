package com.tispunshahryar960103.securityman.ui.databases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tispunshahryar960103.securityman.R;
import com.tispunshahryar960103.securityman.ui.databases.injection.SqlInjectionActivity;
import com.tispunshahryar960103.securityman.ui.databases.sqlCipher.SqlCipherActivity;
import com.tispunshahryar960103.securityman.ui.databases.sqlite.Sqliteactivity;

public class DatabaseActivity extends AppCompatActivity {

    AppCompatButton btn_sqlite,btn_injection,btn_sql_cipher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        btn_sqlite=findViewById(R.id.btn_sqlite);
        btn_injection=findViewById(R.id.btn_injection);
        btn_sql_cipher=findViewById(R.id.btn_sql_cipher);


        btn_sqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(), Sqliteactivity.class);
                startActivity(intent);
            }
        });
        btn_injection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(), SqlInjectionActivity.class);
                startActivity(intent);

            }
        });

        btn_sql_cipher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), SqlCipherActivity.class);
                startActivity(intent);

            }
        });
    }
}