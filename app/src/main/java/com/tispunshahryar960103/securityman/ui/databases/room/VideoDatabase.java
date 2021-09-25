package com.tispunshahryar960103.securityman.ui.databases.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SupportFactory;

@Database(entities = Video.class, exportSchema = false, version = 1)
public abstract class VideoDatabase extends RoomDatabase {


    public abstract IDAO idao();

    private static VideoDatabase instance = null;

    public static synchronized VideoDatabase getInstance(Context context) {

        if (instance == null) {

            /*
            below code lines is for encrypting room database with SQLCipher
             */
            char[] data=new char[]{'r','c','t','4'};
            final byte[] passPhrase= SQLiteDatabase.getBytes(data);
            SupportFactory supportFactory=new SupportFactory(passPhrase);


            instance = Room
                    .databaseBuilder(context, VideoDatabase.class, "video.db")
                    .openHelperFactory(supportFactory) // this code line has added for encrypting room database with SQLCipher
                    .allowMainThreadQueries()
                    .build();


        }

        return instance;

    }


}
