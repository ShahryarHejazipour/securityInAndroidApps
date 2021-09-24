package com.tispunshahryar960103.securityman.ui.databases.sqlCipher;

public class Data {

    private int id;
    private String title;

    public Data() {

    }

    public Data(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
