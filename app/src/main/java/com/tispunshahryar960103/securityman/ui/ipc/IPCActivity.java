package com.tispunshahryar960103.securityman.ui.ipc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tispunshahryar960103.securityman.R;
import com.tispunshahryar960103.securityman.ui.ipc.binders.BindersActivity;
import com.tispunshahryar960103.securityman.ui.ipc.intents.IntentActivity;

public class IPCActivity extends AppCompatActivity {

    AppCompatButton btn_intents,btn_binders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipcactivity);

        btn_binders=findViewById(R.id.btn_binders);
        btn_intents=findViewById(R.id.btn_intents);


        btn_intents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), IntentActivity.class));
            }
        });

        btn_binders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BindersActivity.class));

            }
        });


    }
}