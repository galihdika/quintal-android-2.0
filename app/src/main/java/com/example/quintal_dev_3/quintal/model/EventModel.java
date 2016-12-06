package com.example.quintal_dev_3.quintal.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by quintal-dev-3 on 05/12/16.
 */

public class EventModel implements Serializable {

    @SerializedName("id")
    private int id;

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

    @SerializedName("is_active")
    private boolean active;

    @SerializedName("created_date")
    private Timestamp createdDate;

    @SerializedName("modified_date")
    private Timestamp modifiedDate;

    @SerializedName("institution")
    private InstitutionModel institution;

    @SerializedName("section")
    private SectionModel section;

    @SerializedName("created_by")
    private UserModel createdBy;

    @SerializedName("modified_by")
    private UserModel modifiedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public InstitutionModel getInstitution() {
        return institution;
    }

    public void setInstitution(InstitutionModel institution) {
        this.institution = institution;
    }

    public SectionModel getSection() {
        return section;
    }

    public void setSection(SectionModel section) {
        this.section = section;
    }

    public UserModel getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserModel createdBy) {
        this.createdBy = createdBy;
    }

    public UserModel getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(UserModel modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
