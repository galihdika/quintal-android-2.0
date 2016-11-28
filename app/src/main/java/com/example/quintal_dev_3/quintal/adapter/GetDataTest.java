package com.example.quintal_dev_3.quintal.adapter;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by quintal-dev-3 on 23/11/16.
 */

public class GetDataTest {
    public GetDataTest() throws JSONException {
    }
    private static String url = "https://holidayapi.com/v1/holidays";

    private static final String TAG_STATUS = "status";
    private static final String TAG_HOLIDAYS = "holidays";
    private static final String TAG_NAME = "name";
    private static final String TAG_DATE = "date";
    private static final String TAG_OBSERVED = "observed";
    private static final String TAG_PUBLIC = "publics";


    JsonParser jsonParser = new JsonParser();
    JSONObject jsonObject = jsonParser.getJSONFromUrl(url);

    JSONArray jsonArray = jsonObject.getJSONArray(TAG_STATUS);

}
