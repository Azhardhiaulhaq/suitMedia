package com.example.suitmediamobile.API;

import com.squareup.moshi.Json;

public class Guest {
    @Json(name="id") String guestID;
    @Json(name="name") String guestName;
    @Json(name="birthdate") String guestBirthDate;

    public Guest(String ID, String Name, String BirthDate){
        this.guestID = ID;
        this.guestName = Name;
        this.guestBirthDate = BirthDate;
    }

    public String getGuestID() { return this.guestID ;}
    public String getGuestName() {return this.guestName;}
    public String getGuestBirthDate(){return this.guestBirthDate;}

}
