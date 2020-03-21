package com.example.suitmediamobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Response;
import com.example.suitmediamobile.API.Guest;
import com.example.suitmediamobile.API.GuestApiService;
import com.example.suitmediamobile.API.ListGuest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class GuestActivity extends AppCompatActivity {
    private Context mContext;
    private Activity mActivity;
    private String url = "http://www.mocky.io/v2/596dec7f0f000023032b8017";
    private List<Guest> mDataset;
    private GuestAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        Log.d("Test","Masuk GuestActivity");
        //Get Application Context
        mContext = getApplicationContext();
        mActivity = GuestActivity.this;
        mDataset = new ArrayList<>();
        // Request JSON
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            new Response.Listener<JSONArray>()    {
                @Override
                public void onResponse(JSONArray response){
                       Log.d("Test2","Masuk OnResponse");
                       Log.d("JSONArr",response.toString());
                    try{
                        for(int i = 0; i < response.length();i++){
                            JSONObject jsonobject = response.getJSONObject(i);
                            Guest guest = new Guest(jsonobject.getString("id"),jsonobject.getString("name"),jsonobject.getString("birthdate"));
                            mDataset.add(guest);
                        }
                        generateDataList(mDataset);
                    } catch(JSONException e){
                        e.printStackTrace();
                    }
                }

            }, new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){

                }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void generateDataList(List<Guest> GuestDatalist){
        recyclerView = (RecyclerView) findViewById(R.id.GuestRV);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new GuestAdapter(GuestDatalist,this);
        recyclerView.setAdapter(mAdapter);
    }

}
