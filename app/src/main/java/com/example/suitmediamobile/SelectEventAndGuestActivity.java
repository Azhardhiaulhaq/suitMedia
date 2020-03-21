package com.example.suitmediamobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SelectEventAndGuestActivity extends AppCompatActivity {
    private TextView InputNamaTV;
    private Button EventBtn;
    private Button GuestBtn;
    private int GET_GUEST = 1;
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
    }

    public void getGuest(View view) {
        Intent getGuest = new Intent(this,GuestActivity.class);
        startActivityForResult(getGuest,GET_GUEST);
    }

    public void onSaveInstanceState(Bundle outState){
        outState.putString("username",InputNamaTV.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int aRequestCode, int aResultCode, Intent aData){
        if (aRequestCode == GET_GUEST){
            if(aResultCode == RESULT_OK){
                String name = aData.getExtras().getString("guestName");
                String birthDate = aData.getExtras().getString("guestBirthDate");
                GuestBtn.setText(name);
                String[] arrBirthDate = birthDate.split("-",3);
                int date = Integer.parseInt(arrBirthDate[2]);
                String toastString;
                if (date % 2 == 0){
                    toastString = "blackberry";
                } else if (date % 3 == 0){
                    toastString = "android";
                } else if (date %2 == 0 && date % 3 == 0){
                    toastString = "iOS";
                } else {
                    toastString = "feature phone";
                }
                Toast toast = Toast.makeText(getApplicationContext(),toastString,Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

}
