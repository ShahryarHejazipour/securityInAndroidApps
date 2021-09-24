package com.tispunshahryar960103.securityman.ui.databases.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


/*
this class will be a table in realm database
 */
public class Student extends RealmObject {

     /*
    IMPORTANT NOTE : Realm must be initialized in Application Class -> See To AppConfig.class
     */




  //  @PrimaryKey
    private int id;
    private String name;
    private String family;
    private String std;

    public Student(){

    }

    public Student(int id, String name, String family, String std) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.std = std;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }
}
