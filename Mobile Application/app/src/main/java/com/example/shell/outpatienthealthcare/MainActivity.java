package com.example.shell.outpatienthealthcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSignUp(View view) {
        if (view.getId() == R.id.signUp) {
            Intent i = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(i);
        }
    }

    public void onSignIn(View view) {
        if (view.getId() == R.id.signIn) {
            Intent i = new Intent(MainActivity.this, SignInActivity.class);
            startActivity(i);
        }
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
