package com.example.quintal_dev_3.quintal.Utility;

import com.example.quintal_dev_3.quintal.model.InitialDataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by quintal-dev-3 on 06/12/16.
 */

public interface InitialDataService {
    @GET("api/initial_data/{profileId}")
    Call<InitialDataModel> initialData (@Path("profileId") int profileId);
}
