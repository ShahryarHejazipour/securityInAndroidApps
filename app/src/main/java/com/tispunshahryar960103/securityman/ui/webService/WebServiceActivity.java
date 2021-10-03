package com.tispunshahryar960103.securityman.ui.webService;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tispunshahryar960103.securityman.R;
import com.tispunshahryar960103.securityman.api.ApiClient;
import com.tispunshahryar960103.securityman.ui.webService.notSecure.NotSecureActivity;
import com.tispunshahryar960103.securityman.ui.webService.secure.SecureActivity;

import retrofit2.Retrofit;

public class WebServiceActivity extends AppCompatActivity {

    AppCompatButton btn_normal,btn_encrypt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);

        btn_normal=findViewById(R.id.btn_normal);
        btn_encrypt=findViewById(R.id.btn_encrypt);



        btn_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(), NotSecureActivity.class);

                startActivity(intent);


            }
        });

        btn_encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(), SecureActivity.class);

                startActivity(intent);

            }
        });



    }
}