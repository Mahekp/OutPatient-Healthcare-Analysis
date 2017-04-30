package com.example.shell.outpatienthealthcare.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shell.outpatienthealthcare.R;
import com.example.shell.outpatienthealthcare.model.UserActivity;

import java.util.ArrayList;

/**
 * Created by Shelly Tomar on 4/25/2017.
 */

public class UserActivityAdapter extends RecyclerView.Adapter<UserActivityAdapter.ViewHolder> {

    private ArrayList<UserActivity> userActivity;

    public UserActivityAdapter(ArrayList<UserActivity> userActivity) {
        this.userActivity = userActivity;
    }

    @Override
    public UserActivityAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_activity_card_row, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserActivityAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tvDate.setText(userActivity.get(i).getDate());
        viewHolder.tvSteps.setText(userActivity.get(i).getStepCount());
        viewHolder.tvCalories.setText(userActivity.get(i).getCaloriesBurned());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvDate,tvSteps,tvCalories;

        public ViewHolder(View view) {
            super(view);

            tvDate = (TextView)view.findViewById(R.id.tvDate);
            tvSteps = (TextView)view.findViewById(R.id.tvSteps);
            tvCalories = (TextView)view.findViewById(R.id.tvCalories);

        }
    }
}
