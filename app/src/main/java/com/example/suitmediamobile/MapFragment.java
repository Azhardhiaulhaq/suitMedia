package com.example.suitmediamobile;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suitmediamobile.API.Events;

import java.util.ArrayList;

public class MapFragment extends Fragment {
    private Context mContext;
    private Activity mActivity;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private ArrayList<Events> arrEvents;
    private MapsAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_map_view,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        Bundle bundle = getArguments();
        arrEvents = bundle.getParcelableArrayList("ArrEvents");
        mContext = getContext();
        mActivity = getActivity();

        recyclerView = (RecyclerView) view.findViewById(R.id.verticalRV);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MapsAdapter(arrEvents,mActivity);
        recyclerView.setAdapter(mAdapter);

    }
}
