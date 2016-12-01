package com.example.quintal_dev_3.quintal.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by quintal-dev-3 on 30/11/16.
 */

public class User {

    @SerializedName("username")
    String username;

    @SerializedName("password")
    String password;

    @SerializedName("role")
    String role;

    public User(String email, String password) {
        this.username = email;
        this.password = password;
    }
}
