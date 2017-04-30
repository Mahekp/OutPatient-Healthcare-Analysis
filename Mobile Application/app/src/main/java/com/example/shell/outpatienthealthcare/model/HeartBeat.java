package com.example.shell.outpatienthealthcare.model;

import java.io.Serializable;

/**
 * Created by Shelly Tomar on 4/25/2017.
 */

public class HeartBeat implements Serializable {

    private int id;
    private String date;
    private String maxTime;
    private String minTime;
    private int minHeartBeat;
    private int maxHeartBeat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(String maxTime) {
        this.maxTime = maxTime;
    }

    public String getMinTime() {
        return minTime;
    }

    public void setMinTime(String minTime) {
        this.minTime = minTime;
    }

    public int getMinHeartBeat() {
        return minHeartBeat;
    }

    public void setMinHeartRate(int minHeartRate) {
        this.minHeartBeat = minHeartBeat;
    }

    public int getMaxHeartBeat() {
        return maxHeartBeat;
    }

    public void setMaxHeartBeat(int maxHeartBeat) {
        this.maxHeartBeat = maxHeartBeat;
    }
}
