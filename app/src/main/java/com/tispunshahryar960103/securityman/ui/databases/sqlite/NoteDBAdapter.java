package com.tispunshahryar960103.securityman.ui.databases.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class NoteDBAdapter extends NoteDatabase {


    public NoteDBAdapter(@Nullable Context context) {
        super(context);
    }


    public long insertt(Note note) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_TITLE, note.getTitle());
        contentValues.put(KEY_DESCRIPTION, note.getDescription());

        return sqLiteDatabase.insert(TABLE_NOTE, null, contentValues);

    }

    public List<String> getTitles(){

        List<String> stringList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from " +TABLE_NOTE +" order by id desc ",null);

        while (cursor.moveToNext()){

            Integer id = cursor.getInt(0);
            String title = cursor.getString(1);
            String description = cursor.getString(2);
            stringList.add(title);
            stringList.add(description);
            stringList.add(id.toString());

        }

        return stringList;
    }
}
