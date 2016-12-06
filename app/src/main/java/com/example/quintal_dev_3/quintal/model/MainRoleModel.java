package com.example.quintal_dev_3.quintal.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by quintal-dev-3 on 01/12/16.
 */

public class MainRoleModel implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("created_date")
    private Timestamp createdDate;

    @SerializedName("modified_by")
    private UserModel modifiedBy;

    @SerializedName("modified_date")
    private Timestamp modifiedDate;

    public MainRoleModel(String name, String description, Timestamp createdDate, UserModel modifiedBy, Timestamp modifiedDate) {
        this.name = name;
        this.description = description;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public UserModel getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(UserModel modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Timestamp ModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
