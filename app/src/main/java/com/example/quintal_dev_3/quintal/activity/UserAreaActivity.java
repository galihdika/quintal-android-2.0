package com.example.quintal_dev_3.quintal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.quintal_dev_3.quintal.R;

public class UserAreaActivity extends AppCompatActivity {

    //private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        //button
        final Button bStudent = (Button) findViewById(R.id.bStudent);
        final Button bTeacher = (Button) findViewById(R.id.bTeacher);

        // Find the toolbar view inside the activity layout
        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Sets the Toolbar to act as the Action Bar for this Activity Window
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayShowHomeEnabled(false);
        //getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
    }

    //Menu icon are inflated just as they were with actionbar
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    public void onButtonStudentClicked(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void onButtonTeacherClicked(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
