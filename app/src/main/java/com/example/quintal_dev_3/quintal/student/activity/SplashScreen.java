package com.example.quintal_dev_3.quintal.student.activity;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.example.quintal_dev_3.quintal.R;

public class SplashScreen extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                finish();
            }

        }, SPLASH_TIME_OUT);
    }

}