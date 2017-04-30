package com.example.shell.outpatienthealthcare.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shell.outpatienthealthcare.R;
import com.example.shell.outpatienthealthcare.model.BloodPressure;

import java.util.ArrayList;

/**
 * Created by Shelly Tomar on 4/25/2017.
 */

public class BPAdapter extends RecyclerView.Adapter<BPAdapter.ViewHolder> {

    private ArrayList<BloodPressure> bp;

    public BPAdapter(ArrayList<BloodPressure> bp) {
        this.bp = bp;
    }

    @Override
    public BPAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bp_card_row,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BPAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tvDate.setText(String.valueOf(bp.get(i).getDateTime()));
        viewHolder.tvSystolicValue.setText(Integer.toString(bp.get(i).getSystolicBP()));
        viewHolder.tvDiastolicValue.setText(Integer.toString(bp.get(i).getDiastolicBP()));
    }

    @Override
    public int getItemCount() {
        return (bp == null) ? 0 :bp.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvDate,tvSystolicValue,tvDiastolicValue;

        public ViewHolder(View view) {
            super(view);

            tvDate = (TextView)view.findViewById(R.id.tvDate);
            tvSystolicValue = (TextView)view.findViewById(R.id.tvSystolicValue);
            tvDiastolicValue = (TextView)view.findViewById(R.id.tvDiastolicValue);

        }
    }
}