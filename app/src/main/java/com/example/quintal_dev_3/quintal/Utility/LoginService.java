package com.example.quintal_dev_3.quintal.Utility;


import com.example.quintal_dev_3.quintal.model.ProfileModel;
import com.example.quintal_dev_3.quintal.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by quintal-dev-3 on 30/11/16.
 */

public interface LoginService {
    @POST("api/login/")
    Call<ProfileModel> login(@Body User user);
}
