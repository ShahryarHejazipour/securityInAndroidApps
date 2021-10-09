package com.tispunshahryar960103.securityman.ui.ipc.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.tispunshahryar960103.securityman.R;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);


        //1
        Intent intent=new Intent();

        //2-مشخص کردن مقصد
        //این متد دو پارامتر ورودی دارد 1- نام پکیج مقصد و 2- نام کلاس مورد نظر در آن پکیج
        //اپلیکیشن appstore را هم به عنوان دریافت کننده ی این پیام با همین پکیج نیم com.apstore و یک کلاس با نام  myBroadcastReceiver در آن ساخته ایم.
        intent.setClassName("com.appstore","com.appstore.MyBroadcastReceiver");

        //3-مشخص کردن message ی که باید به اپلیکیشن دوم بفرستیم
        intent.putExtra("KeyName","Hello");

        //4
        sendBroadcast(intent);





    }
}