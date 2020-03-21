package com.example.suitmediamobile.API;

public class Events {
    private String eventName;
    private String eventDate;
    private String eventURL;

    public Events(String Name, String Date, String URL){
        this.eventName = Name;
        this.eventDate = Date;
        this.eventURL = URL;
    }

    public String getEventName() {return this.eventName;}
    public String getEventDate() {return this.eventDate;}
    public String getEventURL() {return this.eventURL;}

}
