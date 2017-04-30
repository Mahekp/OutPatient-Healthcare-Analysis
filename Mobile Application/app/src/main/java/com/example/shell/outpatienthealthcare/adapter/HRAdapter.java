package com.example.shell.outpatienthealthcare.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.shell.outpatienthealthcare.R;
import com.example.shell.outpatienthealthcare.model.HeartBeat;

/**
 * Created by Shelly Tomar on 4/25/2017.
 */

public class HRAdapter extends RecyclerView.Adapter<HRAdapter.ViewHolder> {

    private ArrayList<HeartBeat> heartBeat;

    public HRAdapter(ArrayList<HeartBeat> hr) {
        this.heartBeat = hr;
    }

    @Override
    public HRAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hr_time_card_row, viewGroup,false);
         return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HRAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tvDate.setText(String.valueOf(heartBeat.get(i).getDate()));
        viewHolder.tvMaxValue.setText(Integer.toString(heartBeat.get(i).getMaxHeartBeat()));
        viewHolder.tvMaxTime.setText(String.valueOf(heartBeat.get(i).getMaxTime()));
        viewHolder.tvMinValue.setText(String.valueOf(heartBeat.get(i).getMinHeartBeat()));
        viewHolder.tvMinTime.setText(String.valueOf(heartBeat.get(i).getMinTime()));
    }

    @Override
    public int getItemCount() {
        return (heartBeat == null) ? 0 : heartBeat.size();
        //return heartBeat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvDate,tvMaxValue,tvMinValue,tvMaxTime,tvMinTime;

        public ViewHolder(View view) {
            super(view);

            tvDate = (TextView)view.findViewById(R.id.tvDate);
            tvMaxValue = (TextView)view.findViewById(R.id.tvMaxValue);
            tvMaxTime = (TextView)view.findViewById(R.id.tvMaxTime);
            tvMinValue = (TextView)view.findViewById(R.id.tvMinValue);
            tvMinTime = (TextView)view.findViewById(R.id.tvMinTime);

        }

    }
}
