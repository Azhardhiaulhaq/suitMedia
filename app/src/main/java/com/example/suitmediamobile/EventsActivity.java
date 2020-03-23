package com.example.suitmediamobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
    private ImageView addIV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        //Get Application Context
        mContext = getApplicationContext();
        mActivity = EventsActivity.this;
        mDataset = new ArrayList<>();

        //Initialization
        addIV = (ImageView) findViewById(R.id.addIV);
        //Add Events Data
        mDataset.add(new Events("Hangout Around Town","March 23, 2020","https://image.flaticon.com/icons/png/512/1458/1458512.png","This is version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquer. Aenean gravida nibh vel velt auctor aliquet...",-6.881179,107.616017));
        mDataset.add(new Events("Meeting 1","May 01, 2020","https://image.flaticon.com/icons/png/512/115/115902.png","This is version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquer. Aenean gravida nibh vel velt auctor aliquet...",-6.878623,107.610467));
        mDataset.add(new Events("Football MatchDay","June 02, 2020","https://img.favpng.com/10/3/10/football-player-sport-computer-icons-png-favpng-7ypZt7RGHDMnDrmP3v6L3WX2H.jpg","This is version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquer. Aenean gravida nibh vel velt auctor aliquet...",-6.874735,107.611878));
        mDataset.add(new Events("Badminton MatchDay","June 04, 2020","https://image.flaticon.com/icons/png/512/121/121489.png","This is version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquer. Aenean gravida nibh vel velt auctor aliquet...",-6.875542, 107.613262));

//        // AddIV
//        ArrayList<Events> arrEvents = new ArrayList<>(mDataset.size());
//        arrEvents.addAll(mDataset);
//        Bundle bundle = new Bundle();
//        bundle.putParcelableArrayList("ArrEvents",arrEvents);
//        MapFragment mapFragment = new MapFragment();
//        mapFragment.setArguments(bundle);
//        getSupportFragmentManager().beginTransaction().replace(R.id.eventsCL,mapFragment).commit();


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

    public void back(View view) {
        onBackPressed();
    }
}
