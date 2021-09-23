package com.tispunshahryar960103.securityman.ui.input;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;

import com.tispunshahryar960103.securityman.R;

public class InputValueActivity extends AppCompatActivity {

    AppCompatEditText edit_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_value);

        edit_cart=findViewById(R.id.edit_cart);
    }
}