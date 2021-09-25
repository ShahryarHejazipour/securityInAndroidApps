package com.tispunshahryar960103.securityman.ui.databases.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tispunshahryar960103.securityman.R;

import java.util.List;

public class RoomActivity extends AppCompatActivity {

    VideoDatabase videoDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        videoDatabase = VideoDatabase.getInstance(this);

        Video video = new Video();
        video.setTitle("shiraz");
        video.setIcon("new.png");

        Video video1 = new Video();
        video.setTitle("bushehr");
        video.setIcon("new.png");

        videoDatabase.idao().insert(video1);
        videoDatabase.idao().insert(video);

        List<Video> videoList = videoDatabase.idao().videoList();
    }
}