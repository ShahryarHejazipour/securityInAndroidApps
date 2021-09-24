package com.tispunshahryar960103.securityman.ui.databases.injection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tispunshahryar960103.securityman.R;

public class SqlInjectionActivity extends AppCompatActivity {

    AppCompatEditText edt_username,edt_password;
    AppCompatButton btn_login,btn_register;
    UserDatabase userDatabase;
    UserDbAdapter userDbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_injection);

        userDatabase=new UserDatabase(getApplicationContext());
        userDbAdapter=new UserDbAdapter(getApplicationContext());
        edt_username=findViewById(R.id.edt_username);
        edt_password=findViewById(R.id.edt_password);
        btn_login=findViewById(R.id.btn_login);
        btn_register=findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();
                user.setUsername(edt_username.getText().toString());
                user.setPassword(edt_password.getText().toString());

               long result= userDbAdapter.addNewUser(user);
               if (result>0){
                   Toast.makeText(getApplicationContext(), R.string.DONE, Toast.LENGTH_SHORT).show();

               }else {
                   Toast.makeText(getApplicationContext(), R.string.failed, Toast.LENGTH_SHORT).show();


               }

            }
        });


        /*

        if a hacker user uses this pattern as username=' OR '1'='1 and password=' Or '1'='1, he/she will be able to
        login successfully even there is not such registered user.

        note : ' OR '1'='1  is a example query. there are many probably queries for access to our database

        above process called  " SQL Injection "

         */
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();
                user.setUsername(edt_username.getText().toString());
                user.setPassword(edt_password.getText().toString());

                boolean result= userDbAdapter.loginUserInj(user);
                if (result){
                    Toast.makeText(getApplicationContext(), R.string.DONE, Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getApplicationContext(), R.string.failed, Toast.LENGTH_SHORT).show();

                }

            }
        });


    }
}