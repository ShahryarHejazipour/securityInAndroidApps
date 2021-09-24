package com.tispunshahryar960103.securityman.ui.databases.sqlCipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.tispunshahryar960103.securityman.R;

import net.sqlcipher.database.SQLiteDatabase;

import java.io.File;
import java.util.List;

public class SqlCipherActivity extends AppCompatActivity {

    EncryptDatabase encryptDatabase;
    private static final String TABLE_DATA = "tbl_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_cipher);

        encryptDatabase = new EncryptDatabase(this);

/*

        SQLiteDatabase.loadLibs(this);
        File databasePath = getDatabasePath("demo.db");
        databasePath.mkdir();
        databasePath.delete();

        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(databasePath, "test123", null);


        sqLiteDatabase.execSQL("create table " + TABLE_DATA + "(id Integer Primary Key autoIncrement," +
                "title Text)");
        sqLiteDatabase.execSQL("insert into tbl_data(title) values('android')");
        sqLiteDatabase.execSQL("insert into tbl_data(title) values('Google')");
        sqLiteDatabase.execSQL("insert into tbl_data(title) values('Hello World!')");

*/


        Data data = new Data("Nice");

        encryptDatabase.addNewRecord(data);


        List<Data> dataList = encryptDatabase.getAllData();


    }
}