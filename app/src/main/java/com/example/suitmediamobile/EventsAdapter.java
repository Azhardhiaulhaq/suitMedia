package com.example.suitmediamobile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suitmediamobile.API.Events;
import com.example.suitmediamobile.API.Guest;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {
    private List<Events> mDataset;
    private Activity mActivity;

    public EventsAdapter(List<Events> eventDataList, Activity activity){
        mActivity = activity;
        mDataset = eventDataList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tvEventName;
        public TextView tvEventDate;
        public ConstraintLayout eventConstraintLayout;
        public ImageView ivEvent;
        public Activity activity;

        public MyViewHolder(View v){
            super(v);
            tvEventName = (TextView) v.findViewById(R.id.eventsNameTV);
            tvEventDate = (TextView) v.findViewById(R.id.eventsDateTV);
            ivEvent = (ImageView) v.findViewById(R.id.eventsIV);
            eventConstraintLayout = (ConstraintLayout) v.findViewById(R.id.eventsCL);
        }
    }

    @Override
    public EventsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_events_item, parent, false);
        EventsAdapter.MyViewHolder vh = new EventsAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final EventsAdapter.MyViewHolder holder, final int position){
        holder.tvEventName.setText(mDataset.get(position).getEventName());
        holder.tvEventDate.setText(mDataset.get(position).getEventDate());
        Picasso.get().load(mDataset.get(position).getEventURL()).into(holder.ivEvent);

        holder.eventConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEventIntent(holder.eventConstraintLayout.getContext(),mDataset.get(position).getEventName()
                        ,mDataset.get(position).getEventDate());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void sendEventIntent(Context context, String Name, String Date){
        Intent eventIntent = new Intent(context,SelectEventAndGuestActivity.class);
        eventIntent.putExtra("eventName",Name);
        eventIntent.putExtra("eventDate",Date);
        mActivity.setResult(Activity.RESULT_OK,eventIntent);
        mActivity.finish();
    }

}
