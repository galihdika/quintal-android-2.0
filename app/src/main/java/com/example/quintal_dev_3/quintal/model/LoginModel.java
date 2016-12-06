package com.example.quintal_dev_3.quintal.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by quintal-dev-3 on 06/12/16.
 */

public class LoginModel implements Serializable {
    @SerializedName("profile")
    private ProfileModel profile;

    public LoginModel(ProfileModel profile) {
        this.profile = profile;
    }

    public ProfileModel getProfile() {
        return profile;
    }

    public void setProfile(ProfileModel profile) {
        this.profile = profile;
    }
}
