package com.example.shell.outpatienthealthcare.rest;


import com.example.shell.outpatienthealthcare.model.BloodPressure;
import com.example.shell.outpatienthealthcare.model.HeartBeat;
import com.example.shell.outpatienthealthcare.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


    public interface RestAPIInterface {
        // Request method and URL specified in the annotation
        // Callback for the parsed response is the parameter

        @POST("users")
        Call<User> registerUser(@Body User user);

        @GET("users/{email}/{password}")
        Call<User> login(@Path("email") String email,@Path("password") String password );

        @GET ("heartbeat")
        Call<ArrayList<HeartBeat>> getAllHeartBeat();

        @GET ("bloodpressure")
        Call<ArrayList<BloodPressure>> getAllBp();
    }

