package com.example.quintal_dev_3.quintal.student.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.quintal_dev_3.quintal.R;
import com.example.quintal_dev_3.quintal.student.fragment.AttendanceFragment;
import com.example.quintal_dev_3.quintal.student.fragment.CalendarFragment;
import com.example.quintal_dev_3.quintal.student.fragment.GradebookFragment;
import com.example.quintal_dev_3.quintal.student.fragment.HomeFragment;
import com.example.quintal_dev_3.quintal.student.fragment.TimetableFragment;
import com.google.android.gms.common.api.GoogleApiClient;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Get activity name for TAG
    private static final String TAG = HomeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Quintal");

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_home, new HomeFragment(), "HomeFragment");
        fragmentTransaction.commit();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //Set title for fragment

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(getSupportFragmentManager().findFragmentByTag("HomeFragment") != null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.content_home, new HomeFragment());
            fragmentTransaction.commit();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        //Create Fragment
        Fragment fragment = null;

        //Set new title for specified fragment
        String title = "";

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_gradebook) {
            fragment = new GradebookFragment();
            title = "Gradebook";
        } else if (id == R.id.nav_attendance) {
            fragment = new AttendanceFragment();
            title = "Attendance";
        } else if (id == R.id.nav_timetable) {
            fragment = new TimetableFragment();
            title = "Timetable";
        } else if (id == R.id.nav_calendar) {
            fragment = new CalendarFragment();
            title = "Calendar";
        } else if (id == R.id.nav_subject1) {

        } else if (id == R.id.nav_subject2) {

        } else {
            fragment = new HomeFragment();
            title = "Quintal";
        }

        if(fragment != null) {
            getSupportActionBar().setTitle(title);

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_home, fragment);//.addToBackStack(null);
            ft.commit();
        }

        Log.d(TAG, "fragment oke");


        //Highlight the selected menu
        item.setChecked(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }
}
