package com.example.suitmediamobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
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

        Intent intent = getIntent();
        if (intent.hasExtra("username")){
            InputNamaTV.setText(intent.getExtras().getString("username"));
        }
//        if(intent.hasExtra("eventname")){
//
//        } else {
//            EventBtn.setText("Belum Ada Event");
//        }
    }

    public void getGuest(View view) {
        Intent getGuest = new Intent(this,GuestActivity.class);
        startActivity(getGuest);
    }
}
