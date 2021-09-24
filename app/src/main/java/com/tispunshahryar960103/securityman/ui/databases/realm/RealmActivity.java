package com.tispunshahryar960103.securityman.ui.databases.realm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.tispunshahryar960103.securityman.R;

import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmResults;

public class RealmActivity extends AppCompatActivity {


    /*
    IMPORTANT NOTE : Realm must be initialized in Application Class -> See To AppConfig.class
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);

        /*
        Inserting data in realm database
         */

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Student student = realm.createObject(Student.class);
        student.setName("Shahryar");
        student.setFamily("Hejazipour");
        student.setId((int)getRandom(1,10000));

        realm.commitTransaction();

        /*
        getting data from realm database
         */

        RealmResults<Student> studentsList=realm.where(Student.class).findAll();
        Log.e("TAG", "onCreate: ");




    }
    /*
    create random number for setId
     */
    public double getRandom(double min, double max) {

        return (Math.random()) * ((max - min) + 1) + min;


    }
}