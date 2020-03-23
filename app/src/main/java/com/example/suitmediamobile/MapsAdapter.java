package com.example.suitmediamobile;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suitmediamobile.API.Events;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MapsAdapter extends RecyclerView.Adapter<MapsAdapter.MyViewHolder>{
    private ArrayList<Events> mDataset;
    private Activity mActivity;
    public MapsAdapter(ArrayList<Events> arrEvents, Activity activity){
        mActivity = activity;
        mDataset = arrEvents;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivEvent;
        public Activity activity;

        public MyViewHolder(View v){
            super(v);
            ivEvent = (ImageView) v.findViewById(R.id.verticalIV);

        }
    }

    @Override
    public MapsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vertical_rv_item, parent, false);
        MapsAdapter.MyViewHolder vh = new MapsAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MapsAdapter.MyViewHolder holder, final int position){
        Picasso.get().load(mDataset.get(position).getEventURL()).into(holder.ivEvent);
        holder.ivEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Latitude",Double.toString(mDataset.get(position).getLatitude()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
