package com.example.quintal_dev_3.quintal.Utility;


import com.example.quintal_dev_3.quintal.model.User;
import com.example.quintal_dev_3.quintal.model.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by quintal-dev-3 on 30/11/16.
 */

public interface LoginService {
    @POST("/login")
    Call<UserModel> login(@Body User user);
}
