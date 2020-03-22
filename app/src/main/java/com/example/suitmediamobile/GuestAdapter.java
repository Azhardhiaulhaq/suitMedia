package com.example.suitmediamobile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suitmediamobile.API.Guest;

import java.util.List;

public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.MyViewHolder> {
    private List<Guest> mDataset;
    private Activity mActivity;

    public GuestAdapter(List<Guest> guestDataList, Activity activity){
        mActivity = activity;
        mDataset = guestDataList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tvGuestName;
        public ConstraintLayout guestConstraintLayout;
        public Activity activity;
        public TextView tvMonth;

        public MyViewHolder(View v){
            super(v);
            tvGuestName = (TextView) v.findViewById(R.id.guestNameTV);
            tvMonth = (TextView) v.findViewById(R.id.monthTV);
            guestConstraintLayout = (ConstraintLayout) v.findViewById(R.id.guestDetailCL);
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
        String birthDate = mDataset.get(position).getGuestBirthDate();
        String[] birth = birthDate.split("-",3);
        String month = birth[1];
        if(isPrime(Integer.parseInt(month))){
            holder.tvMonth.setText("The Month is Prime");
        } else {
            holder.tvMonth.setText("The Month is not Prime");
        }
        holder.guestConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendGuestIntent(holder.guestConstraintLayout.getContext(),mDataset.get(position).getGuestID()
                        ,mDataset.get(position).getGuestName(),mDataset.get(position).getGuestBirthDate());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void sendGuestIntent(Context context,String ID, String Name, String BirthDate){
        Intent guestIntent = new Intent(context,SelectEventAndGuestActivity.class);
        guestIntent.putExtra("guestID",ID);
        guestIntent.putExtra("guestName",Name);
        guestIntent.putExtra("guestBirthDate",BirthDate);
        mActivity.setResult(Activity.RESULT_OK,guestIntent);
        mActivity.finish();
    }

    public Boolean isPrime (int number){
        Boolean isprime = true;
        if (number < 2){
            isprime = false;
        } else if (number == 2 ){
            isprime = true;
        } else {
            int count = 0;
            for (int i = 2 ; i <= number; i++){
                if (number % i == 0){
                    count++;
                }
            }
            if (count == 2){
                isprime = true;
            } else {
                isprime = false;
            }
        }
        return isprime;
    }

}
