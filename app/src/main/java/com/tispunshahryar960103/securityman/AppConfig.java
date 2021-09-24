package com.tispunshahryar960103.securityman;

import android.app.Application;

import java.security.SecureRandom;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AppConfig extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

        /*
        For Encrypting realm database
         */

       byte[] key1 = "TRFGHHMM5452154jhjg5453khjg55454LTRFGHHMM5452154jhjg5453khjg5545".getBytes();
                       //above string has 64 character and must be like this//


      RealmConfiguration realmConfiguration=  new RealmConfiguration.Builder()
              .encryptionKey(key1) // this methode is for encrypting realm database
              .allowQueriesOnUiThread(true).schemaVersion(0)
              .name(Realm.DEFAULT_REALM_NAME).deleteRealmIfMigrationNeeded().build();

      Realm.setDefaultConfiguration(realmConfiguration);


    }
}
