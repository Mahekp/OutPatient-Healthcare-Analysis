package com.example.shell.outpatienthealthcare;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.shell.outpatienthealthcare.model.User;
import com.example.shell.outpatienthealthcare.rest.RestAPIClient;
import com.example.shell.outpatienthealthcare.common.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        //toolbar.setTitle("Admin Dashboard");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.getMenu().findItem(R.id.action_signin).setVisible(false);
        navigationView.setNavigationItemSelectedListener(this);

        /*
        ProgressBar caloriesburntprogress = (ProgressBar) findViewById(R.id.calories_burnt_circle_progress_bar);
        caloriesburntprogress.setProgress(20);
        //getAllUsers();

        */
    }


    public void onClickHeartRate(View view){
        Intent intent = new Intent(DashboardActivity.this, HeartRateActivity.class);
        intent.putExtra(SignUpActivity.USER, user);
        startActivity(intent);
    }

    public void onClickBP(View view){
        Intent intent = new Intent(DashboardActivity.this, BloodPressureActivity.class);
        intent.putExtra(SignUpActivity.USER, user);
        startActivity(intent);
    }

    public void onClickActivity(View view){
        Intent intent = new Intent(DashboardActivity.this, ActivityDataActivity.class);
        intent.putExtra(SignUpActivity.USER, user);
        startActivity(intent);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        /*
        int id = item.getItemId();
        Log.i("id is:", "" + id);
        System.out.print(id);
        System.out.print(R.id.action_steps);
        if (id == R.id.action_logout) {
            Intent i = new Intent(DashboardActivity.this, SignUpActivity.class);
            startActivity(i);
        } else if (id == R.id.action_steps) {
            Intent i = new Intent(DashboardActivity.this,StepCountActivity.class);
            i.putExtra(UserDetailsActivity.USER, user);
            i.putExtra(Constants.DIET, diet);
            startActivity(i);
        }else if (id == R.id.action_addFood) {
            Intent i = new Intent(Dashboard.this,FoodDetailsActivity.class);
            i.putExtra(UserDetailsActivity.USER, user);
            i.putExtra(Constants.DIET, diet);
            startActivity(i);
        }else if (id == R.id.action_articles) {
            Intent i = new Intent(Dashboard.this,ArticlesActivity.class);
            i.putExtra(UserDetailsActivity.USER, user);
            i.putExtra(Constants.DIET, diet);
            startActivity(i);
        }else if (id == R.id.action_reports) {
            Intent i = new Intent(Dashboard.this, ReportActivity.class);
            i.putExtra(UserDetailsActivity.USER, user);
            i.putExtra(Constants.DIET, diet);
            startActivity(i);
        }else if (id == R.id.exit) {
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        */
        return true;
    }




}
