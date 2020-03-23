package com.example.suitmediamobile.API;

import android.os.Parcel;
import android.os.Parcelable;

public class Events implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public Events createFromParcel(Parcel in){
            return new Events(in);
        }

        @Override
        public Events[] newArray(int i) {
            return new Events[i];
        }
    };
    private String eventName;
    private String eventDate;
    private String eventURL;
    private String eventDescription;
    private double latitude;
    private double longitude;

    public Events(Parcel in){
        this.eventName = in.readString();
        this.eventDate = in.readString();
        this.eventDescription = in.readString();
        this.eventURL = in.readString();
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
    }
    public Events(String Name, String Date, String URL, String Description, double lat, double longit){
        this.eventName = Name;
        this.eventDate = Date;
        this.eventURL = URL;
        this.eventDescription = Description;
        this.latitude = lat;
        this.longitude = longit;

    }

    public String getEventName() {return this.eventName;}
    public String getEventDate() {return this.eventDate;}
    public String getEventURL() {return this.eventURL;}
    public String getEventDescription() {return this.eventDescription;}
    public double getLatitude() {return this.latitude;}
    public double getLongitude(){return this.longitude;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.eventName);
        parcel.writeString(this.eventDate);
        parcel.writeString(this.eventURL);
        parcel.writeString(this.eventDescription);
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);

    }
}
