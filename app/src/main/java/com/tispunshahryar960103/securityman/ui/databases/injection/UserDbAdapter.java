package com.tispunshahryar960103.securityman.ui.databases.injection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class UserDbAdapter extends UserDatabase {


    public UserDbAdapter(@Nullable Context context) {
        super(context);
    }

    public long addNewUser(User user) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_USERNAME, user.getUsername());
        contentValues.put(KEY_PASSWORD, user.getPassword());

        long result = sqLiteDatabase.insert(TABLE_USER, null, contentValues);

        return result;


    }


    /*
    SQL Injection یا تزریق اس کیو ال ( sql یا زبان ساخت یافته پرس و جو) یکی از راه هایی است که هکر ها
    از آن برای نفوذ به سیستم ها و سایت ها برای سرقت اطلاعات مهم و یا بدست آوردن رمزهای ورود به سیستم
    از آن استفاده می کنند.
    این روش به این گونه است که هکر با استفاده فیلدهای ورودی نرم افزار تحت وب (به عنوان مثال ورود
    اطلاعات کاربری برای لاگین در سایت و ...) یا دسکتاپ، با دانشی که از این زبان (SQL) دارد با وارد کردن
    کوئری مورد نظر و با حدس نام جداول و ستون های دیتابیس که معمولا از اسامی مشخصی استفاده می کنند،
    اطلاعات مورد نظر خود را بدست می آورد.
     */

    /*
      if a hacker user uses this pattern as username=' OR '1'='1 and password=' Or '1'='1, he/she will be able to
        login successfully even there is not such registered user.

        above process called  " SQL Injection "
     */

    //this method is for doing " SQL Injection "
    // a login method

    public boolean loginUser(User user){

        boolean isLogged=false;
        
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+TABLE_USER + " where username ='"
                + user.getUsername() +"'and "
                + " password= '" + user.getPassword()+ "'",null);
        
        if (cursor.moveToNext()){

            isLogged=true;
        }

        return isLogged;



    }

    //this method is for Preventing " SQL Injection "
    // a login method

    public boolean loginUserInj(User user){

        boolean isLogged=false;

        SQLiteDatabase sqLiteDatabase=getReadableDatabase();

        String[] params={user.getUsername(), user.getPassword()};

        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+TABLE_USER + " where username =? and "
                + " password= ?",params);

        if (cursor.moveToNext()){

            isLogged=true;
        }

        return isLogged;



    }

    public void delete(User user){

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();

        String[] params = {String.valueOf(user.getId())};

        sqLiteDatabase.delete(TABLE_USER,"id=?",params);

    }



}
