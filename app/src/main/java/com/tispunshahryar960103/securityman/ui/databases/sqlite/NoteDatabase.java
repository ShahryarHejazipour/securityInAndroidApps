package com.tispunshahryar960103.securityman.ui.databases.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class NoteDatabase extends SQLiteOpenHelper {

    public static final String DB_NAME = "note.db";
    public static final String TABLE_NOTE = "tbl_note";
    public static final String KEY_TITLE = "title";
    public static final String KEY_DESCRIPTION = "description";

    public NoteDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "create table " + TABLE_NOTE + "(id Integer primary key autoIncrement," + KEY_TITLE + " varchar(50), " + KEY_DESCRIPTION + " varchar(100))";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
