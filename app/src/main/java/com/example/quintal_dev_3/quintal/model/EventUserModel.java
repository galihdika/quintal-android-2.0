package com.example.quintal_dev_3.quintal.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by quintal-dev-3 on 06/12/16.
 */

public class EventUserModel implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("user")
    private int user;

    @SerializedName("event_title")
    private String eventTitle;

    @SerializedName("event_description")
    private String eventDescription;

    @SerializedName("event_from")
    private Timestamp eventFrom;

    @SerializedName("event_to")
    private Timestamp eventTo;

    @SerializedName("event_type")
    private String eventType;

    public EventUserModel(int id, int user, String eventTitle, String eventDescription, Timestamp eventFrom, Timestamp eventTo, String eventType) {
        this.id = id;
        this.user = user;
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventFrom = eventFrom;
        this.eventTo = eventTo;
        this.eventType = eventType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Timestamp getEventFrom() {
        return eventFrom;
    }

    public void setEventFrom(Timestamp eventFrom) {
        this.eventFrom = eventFrom;
    }

    public Timestamp getEventTo() {
        return eventTo;
    }

    public void setEventTo(Timestamp eventTo) {
        this.eventTo = eventTo;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
