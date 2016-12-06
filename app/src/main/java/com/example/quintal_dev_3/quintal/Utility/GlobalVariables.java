package com.example.quintal_dev_3.quintal.Utility;

import android.app.Application;

import com.example.quintal_dev_3.quintal.model.InitialDataModel;
import com.example.quintal_dev_3.quintal.model.LoginModel;
import com.example.quintal_dev_3.quintal.model.ProfileModel;
import com.loopj.android.http.AsyncHttpClient;

/**
 * Created by Danny Saksono on 8/04/2016.
 */
public class GlobalVariables extends Application {

    private LoginModel loginModel;
    private InitialDataModel initialDataModel;

    public LoginModel getLoginModel() {
        return loginModel;
    }

    public void setLoginModel(LoginModel loginModel) {
        this.loginModel = loginModel;
    }

    public InitialDataModel getInitialDataModel() {
        return initialDataModel;
    }

    public void setInitialDataModel(InitialDataModel initialDataModel) {
        this.initialDataModel = initialDataModel;
    }
}
