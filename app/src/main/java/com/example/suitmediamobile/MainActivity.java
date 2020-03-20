package com.example.suitmediamobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText InsertNameET;
    private Button NextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi Layout
        InsertNameET = (EditText) findViewById(R.id.InsertNamaET);
        NextBtn = (Button) findViewById(R.id.NextBtn);
    }

    public void sendName(View view) {
        String name = InsertNameET.getText().toString();
        Intent sendName = new Intent(this,SelectEventAndGuestActivity.class);
        sendName.putExtra("username",name);
        startActivity(sendName);
    }
}
