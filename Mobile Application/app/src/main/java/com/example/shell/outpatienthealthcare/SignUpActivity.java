package com.example.shell.outpatienthealthcare;

import com.example.shell.outpatienthealthcare.model.User;
import com.example.shell.outpatienthealthcare.rest.RestAPIClient;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    TextView txtDate;
    private int mYear, mMonth, mDay;
    private User user;
    public final static String USER = "user";
    private RadioGroup gender;
    final static String MALE = "male";
    final static String FEMALE = "female";
    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Sign Up");
        if(savedInstanceState!=null) {
            user = (User)savedInstanceState.getSerializable(SignUpActivity.USER);
        } else {
            user = new User();
        }

    }

    private void setUserDetails(){
        EditText email = (EditText)findViewById(R.id.email);
        EditText name = (EditText)findViewById(R.id.userName);
        EditText password = (EditText)findViewById(R.id.password);
        EditText phoneNumber = (EditText)findViewById(R.id.phoneNumber);
        EditText height = (EditText)findViewById(R.id.height);
        EditText weight = (EditText)findViewById(R.id.weight);

        user.setEmail(email.getText().toString());
        user.setName(name.getText().toString());
        user.setPassword(password.getText().toString());
        user.setPhoneNumber(phoneNumber.getText().toString());
        if(height.getText().length()>0)
            user.setHeight(Float.parseFloat(height.getText().toString()));
        if(weight.getText().length()>0)
            user.setWeight(Float.parseFloat(weight.getText().toString()));
        createUser();
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(SignUpActivity.USER, user);
    }

    public void onClickDOB(View v){

        txtDate = (TextView) findViewById(R.id.txtViewDateofBirth);
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // Launch Date Picker Dialog
        DatePickerDialog dpd = new DatePickerDialog(SignUpActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // Display Selected date in text box
                        txtDate.setText(dayOfMonth + " - " + (monthOfYear + 1) + " - " + year);
                        int age = mYear - year;
                        user.setAge(age);
                        Log.i("age is ",""+age);

                    }
                }, mYear, mMonth, mDay);
        dpd.show();
    }

    public void onClickContinue(View v){
        if (v.getId() == R.id.btn_continue) {
            setUserDetails();
            Intent i = new Intent(v.getContext(), SignUpConfirmationActivity.class);
            i.putExtra(SignUpActivity.USER,user);
            startActivity(i);
        }
    }

    public void createUser(){
        Call<User> call = RestAPIClient.get().registerUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.i("Register User", "Successfully Registered user");
                user = response.body();
                Log.i("user id is ", "" + user.getUserId());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.i("Error ", "Cannot register user");
            }
        });
    }

    public void onRadioButtonClicked(View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.male:
                if (checked)
                    user.setGender(SignUpActivity.MALE);
                break;
            case R.id.female:
                if (checked)
                    user.setGender(SignUpActivity.FEMALE);
                break;
        }
    }


}
