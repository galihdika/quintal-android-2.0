package com.example.quintal_dev_3.quintal.Utility;

import android.app.Application;

import com.example.quintal_dev_3.quintal.model.ProfileModel;
import com.loopj.android.http.AsyncHttpClient;

/**
 * Created by Danny Saksono on 8/04/2016.
 */
public class GlobalVariables extends Application {

    private ProfileModel profileModel;

    public ProfileModel getProfileModel() {
        return profileModel;
    }

    public void setProfileModel(ProfileModel profileModel) {
        this.profileModel = profileModel;
    }

    public void downloadAppData() {
        downloadActivities();
    }

    public void downloadActivities() {
        AsyncHttpClient client = new AsyncHttpClient();
        
    }
}
