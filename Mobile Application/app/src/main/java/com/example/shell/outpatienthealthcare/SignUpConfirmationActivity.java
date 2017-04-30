package com.example.shell.outpatienthealthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.shell.outpatienthealthcare.model.User;

public class SignUpConfirmationActivity extends AppCompatActivity {
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_confirmation);

        if (savedInstanceState != null) {
            user = (User) savedInstanceState.getSerializable(SignUpActivity.USER);
        } else {
            user = (User) getIntent().getSerializableExtra(SignUpActivity.USER);
        }
        Log.i("user id in registration", "" + user.getUserId());
    }

    public void onCLickContinue(View view){
        if (view.getId() == R.id.congrats_continue) {
            Intent i = new Intent(SignUpConfirmationActivity.this, DashboardActivity.class);
            i.putExtra(SignUpActivity.USER, user);
            startActivity(i);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(SignUpActivity.USER, user);
    }
}
