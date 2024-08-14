package com.example.xogame;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {
    ProgressBar loading;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        loading=(ProgressBar) findViewById(R.id.loading);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=1; i<=100; i++) {

                    loading.setProgress(i);
                    try {
                        Thread.sleep(35);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                Intent i=new Intent(SplashScreen.this, MainActivity.class);

                startActivity(i);
                finish();
             }
        });
        thread.start();


    }

    @Override
    public void onBackPressed() {
        int i=9;
        if(i==0)
            super.onBackPressed();
    }


}