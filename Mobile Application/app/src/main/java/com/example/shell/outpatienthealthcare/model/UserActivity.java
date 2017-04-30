package com.example.shell.outpatienthealthcare.model;

import java.io.Serializable;

/**
 * Created by Shelly Tomar on 4/25/2017.
 */

public class UserActivity implements Serializable {

    private int userId;
    private int stepCount;
    private int caloriesBurned;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }


}
