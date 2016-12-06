package com.example.quintal_dev_3.quintal.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by quintal-dev-3 on 01/12/16.
 */

public class RoleModel implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("main_role")
    private MainRoleModel mainRole;

    @SerializedName("institution")
    private InstitutionModel institution;

    @SerializedName("created_by")
    private UserModel createdBy;

    @SerializedName("created_date")
    private Timestamp createdDate;

    @SerializedName("modified_by")
    private UserModel modifiedBy;

    @SerializedName("modified_date")
    private Timestamp modifiedDate;

    public RoleModel(String name, String description, InstitutionModel institution, MainRoleModel mainRole, UserModel createdBy, Timestamp createdDate, UserModel modifiedBy, Timestamp modifiedDate) {
        this.name = name;
        this.description = description;
        this.institution = institution;
        this.mainRole = mainRole;
        this.createdBy = createdBy;
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

    public MainRoleModel getMainRole() {
        return mainRole;
    }

    public void setMainRole(MainRoleModel mainRole) {
        this.mainRole = mainRole;
    }

    public InstitutionModel getInstitution() {
        return institution;
    }

    public void setInstitution(InstitutionModel institution) {
        this.institution = institution;
    }

    public UserModel getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserModel createdBy) {
        this.createdBy = createdBy;
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

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
