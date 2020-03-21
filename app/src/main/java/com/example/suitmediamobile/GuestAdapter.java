package com.example.suitmediamobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.suitmediamobile.API.Guest;

import java.util.List;

public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.MyViewHolder> {
    private List<Guest> mDataset;

    public GuestAdapter(List<Guest> guestDataList){
        mDataset = guestDataList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tvGuestName;

        public MyViewHolder(View v){
            super(v);
            tvGuestName = (TextView) v.findViewById(R.id.guestNameTV);
        }
    }

    @Override
    public GuestAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_guest_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position){
        holder.tvGuestName.setText(mDataset.get(position).getGuestName());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
