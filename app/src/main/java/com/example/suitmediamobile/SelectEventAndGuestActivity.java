package com.example.suitmediamobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SelectEventAndGuestActivity extends AppCompatActivity {
    private TextView InputNamaTV;
    private Button EventBtn;
    private Button GuestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_event_and_guest);
        //Inisialisasi Layout
        InputNamaTV = (TextView) findViewById(R.id.InputNamaTV);
        EventBtn = (Button) findViewById(R.id.eventBtn);
        GuestBtn = (Button) findViewById(R.id.guestBtn);
    }
}
