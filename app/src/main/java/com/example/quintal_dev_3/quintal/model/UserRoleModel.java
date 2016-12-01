package com.example.quintal_dev_3.quintal.model;

import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

/**
 * Created by quintal-dev-3 on 01/12/16.
 */

public class UserRoleModel {

    @SerializedName("profile")
    private ProfileModel profile;

    @SerializedName("role")
    private RoleModel role;

    @SerializedName("created_by")
    private UserModel createdBy;

    @SerializedName("created_date")
    private Timestamp createdDate;

    @SerializedName("modified_by")
    private UserModel modifiedBy;

    @SerializedName("modified_date")
    private Timestamp modifiedDate;

    public UserRoleModel(ProfileModel profile, RoleModel role, UserModel createdBy, Timestamp createdDate, UserModel modifiedBy, Timestamp modifiedDate) {
        this.profile = profile;
        this.role = role;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }


}
