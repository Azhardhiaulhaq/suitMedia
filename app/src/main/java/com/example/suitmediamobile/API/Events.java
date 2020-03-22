package com.example.suitmediamobile.API;

public class Events {
    private String eventName;
    private String eventDate;
    private String eventURL;
    private String eventDescription;

    public Events(String Name, String Date, String URL, String Description){
        this.eventName = Name;
        this.eventDate = Date;
        this.eventURL = URL;
        this.eventDescription = Description;
    }

    public String getEventName() {return this.eventName;}
    public String getEventDate() {return this.eventDate;}
    public String getEventURL() {return this.eventURL;}
    public String getEventDescription() {return this.eventDescription;}

}
