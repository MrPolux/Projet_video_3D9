package com.example.paulm.projet_3d9_video;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import java.net.URI;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  {

    private Button mPrevButton, mPlayButton, mPauseButton, mNextButton;
    private VideoView mVideoView;
    private  ArrayList<android.net.Uri> arrayList;
    private int index ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPrevButton = (Button) findViewById(R.id.PrevButton);
        mPlayButton = (Button) findViewById(R.id.PlayButton);
        mPauseButton = (Button) findViewById(R.id.PauseButton);
        mNextButton = (Button) findViewById(R.id.NextButton);
        mVideoView = (VideoView) findViewById(R.id.videoView);
        arrayList = new ArrayList<>();



        arrayList.add(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.chien ));
        arrayList.add(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.blabla ));
        arrayList.add(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.chatte ));

        setupMedia();
        setupListeners();
    }

    private void setupMedia() {

        index = 0;
        mVideoView.setVideoURI((arrayList.get(index)));
    }

    private void setupListeners() {

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mVideoView.start();
            }
        });

        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mVideoView.pause();
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(index < arrayList.size() - 1 ) {
                    mVideoView.setVideoURI(arrayList.get(++index));
                    mVideoView.start();
                }
                else
                    setupMedia();
            }
        });

        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index > 0)
                {
                    mVideoView.setVideoURI(arrayList.get(--index));
                    mVideoView.start();
                }

                else {
                    index = arrayList.size() - 1;
                    mVideoView.setVideoURI(arrayList.get(index));
                    mVideoView.start();
                }

            }
        });



    }








}

