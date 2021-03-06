package com.example.quintal_dev_3.quintal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.quintal_dev_3.quintal.R;
import com.example.quintal_dev_3.quintal.student.activity.HomeActivity;

public class UserAreaActivity extends AppCompatActivity {

    //private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        //button
        final Button bStudent = (Button) findViewById(R.id.bStudent);
        final Button bTeacher = (Button) findViewById(R.id.bTeacher);

    }

    public void onButtonStudentClicked(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void onButtonTeacherClicked(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }
}
