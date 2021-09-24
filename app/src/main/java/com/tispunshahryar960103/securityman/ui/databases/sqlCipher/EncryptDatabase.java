package com.tispunshahryar960103.securityman.ui.databases.sqlCipher;

import android.content.ContentValues;
import android.content.Context;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EncryptDatabase {

    SQLiteDatabase sqLiteDatabase;
    private static final String TABLE_DATA = "tbl_data";

    public EncryptDatabase(Context context) {

        SQLiteDatabase.loadLibs(context);
        File databasePath = context.getDatabasePath("demo.db");
        databasePath.mkdir();
        databasePath.delete();

        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(databasePath, "test123", null);


        sqLiteDatabase.execSQL("create table " + TABLE_DATA + "(id Integer Primary Key autoIncrement," +
                "title Text)");
        sqLiteDatabase.execSQL("insert into tbl_data(title) values('android')");
        sqLiteDatabase.execSQL("insert into tbl_data(title) values('Google')");
        sqLiteDatabase.execSQL("insert into tbl_data(title) values('Hello World!')");

    }

    public long addNewRecord(Data data) {

        ContentValues contentValues = new ContentValues();
        // contentValues.put("id",data.getId());
        contentValues.put("title", data.getTitle());

        return sqLiteDatabase.insert(TABLE_DATA, null, contentValues);
    }

    public List<Data> getAllData(){

        List<Data> dataList=new ArrayList<>();

        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+TABLE_DATA,null);

        while (cursor.moveToNext()){

            Data data=new Data();
            data.setId(cursor.getInt(0));
            data.setTitle(cursor.getString(1));
            dataList.add(data);
        }


        return dataList;

    }
}
