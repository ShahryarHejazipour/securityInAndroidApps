package com.tispunshahryar960103.securityman.ui.sharedPref;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class MyEncryptedSharedPreferences {


    SharedPreferences sharedPreferences;
    String masterKeyAlias;
    SharedPreferences.Editor editor;


    public MyEncryptedSharedPreferences(Context context) {

        try {
            masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            sharedPreferences = EncryptedSharedPreferences.create("secure_shared_prefs",masterKeyAlias
            ,context,EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);

            editor=sharedPreferences.edit();

        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void save(String username,String password){

        editor.putString("UserName",username);
        editor.putString("Password",password);
        editor.commit();
    }

    public String getUsername(){
        return sharedPreferences.getString("UserName","");
    }

    public String getPassword(){
        return sharedPreferences.getString("Password","");
    }


    public void saveSettings(int font,String color,boolean ask,String style ){

        editor.putString("Color",color);
        editor.putBoolean("Ask",ask);
        editor.putInt("Font",font);
        editor.putString("Style",style);
        editor.commit();

    }

    public int getFont(){

        return sharedPreferences.getInt("Font",12);

    }

    public String getColor(){

        return sharedPreferences.getString("Color","BLUE");

    }

    public Boolean getAsk(){
        return sharedPreferences.getBoolean("Ask",true);

    }

    public String getStyle(){
        return sharedPreferences.getString("Style","");
    }



    public void saveLevels(String level){

        editor.putString("Level",level);
        editor.commit();
    }

    public String getLevel(){
        return sharedPreferences.getString("Level","");
    }

}
