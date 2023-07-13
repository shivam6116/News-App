package com.example.splashscreen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.splashscreen.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        // create splash activity as a launcher activity step 1

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent iHome= new Intent(SplashScreen.this, MainActivity.class);
                startActivity(iHome);
            }
        },4000);



        //asynchronous
    }
}