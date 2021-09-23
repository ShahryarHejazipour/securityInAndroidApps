package com.tispunshahryar960103.securityman.ui.sharedPref;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tispunshahryar960103.securityman.R;

public class SharedPreferencesActivity extends AppCompatActivity {

    NormalDataPref normalDataPref;
    MySecurePreferences mySecurePreferences;
    MyEncryptedSharedPreferences myEncryptedSharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefrences);


        normalDataPref = new NormalDataPref(getApplicationContext());

        normalDataPref.save("NEDA", "HODAYI");
        normalDataPref.saveLevels("Hard");
        normalDataPref.saveSettings(15, "GREEN", false, "BOLD");



        mySecurePreferences=new MySecurePreferences(getApplicationContext());

        mySecurePreferences.save("Sara","Salehi");

        String username = mySecurePreferences.getUsername();

        myEncryptedSharedPreferences=new MyEncryptedSharedPreferences(getApplicationContext());

        myEncryptedSharedPreferences.save("Nasim","Seifi");
        myEncryptedSharedPreferences.saveSettings(15,"BLUE",false,"ITALIC");






    }
}