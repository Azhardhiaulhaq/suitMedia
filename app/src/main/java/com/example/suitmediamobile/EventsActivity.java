package com.example.suitmediamobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.example.suitmediamobile.API.Events;
import com.example.suitmediamobile.API.Guest;

import java.util.ArrayList;
import java.util.List;

public class EventsActivity extends AppCompatActivity {

    private Context mContext;
    private Activity mActivity;
    private List<Events> mDataset;
    private EventsAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        //Get Application Context
        mContext = getApplicationContext();
        mActivity = EventsActivity.this;
        mDataset = new ArrayList<>();
        //Add Events Data
        mDataset.add(new Events("Hangout Around Town","2020-03-23","https://image.flaticon.com/icons/png/512/1458/1458512.png"));
        mDataset.add(new Events("Meeting 1","2020-04-01","https://image.flaticon.com/icons/png/512/115/115902.png"));
        mDataset.add(new Events("Football MatchDay","2020-05-02","https://img.favpng.com/10/3/10/football-player-sport-computer-icons-png-favpng-7ypZt7RGHDMnDrmP3v6L3WX2H.jpg"));
        mDataset.add(new Events("Badminton MatchDay","2020-05-04","https://image.flaticon.com/icons/png/512/121/121489.png"));

        //Generate DataList
        generateDataList(mDataset);

    }

    public void generateDataList(List<Events> EventsDataList){
        recyclerView = (RecyclerView) findViewById(R.id.EventRV);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new EventsAdapter(EventsDataList,this);
        recyclerView.setAdapter(mAdapter);
    }
}
