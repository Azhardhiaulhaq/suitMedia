package com.example.suitmediamobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
        NextBtn.setBackgroundResource(R.drawable.homebutton);
    }

    public void sendName(View view) {
        String message;
        String name = InsertNameET.getText().toString();
        if (isPalindrom(name)){
            message = "is Palindrom";
        } else {
            message = "not Palindrom";
        }
        final Intent sendName = new Intent(this,SelectEventAndGuestActivity.class);
        sendName.putExtra("username",name);

        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Check Palindrom")
                .setMessage(message)
                .setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(sendName);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }

    public Boolean isPalindrom (String sentence){
        String lowSentence = sentence.toLowerCase();
        Boolean isPalindrom = true;
        int i = lowSentence.length()-1;
        int j = 0;
        while(i > j){
            if (lowSentence.charAt(i) != lowSentence.charAt(j)){
                isPalindrom = false;
            }
            i--;
            j++;
        }
        return isPalindrom;
    }

}
