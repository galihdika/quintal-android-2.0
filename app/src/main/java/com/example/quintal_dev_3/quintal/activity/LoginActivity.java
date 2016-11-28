package com.example.quintal_dev_3.quintal.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import com.example.quintal_dev_3.quintal.R;
import com.example.quintal_dev_3.quintal.adapter.HttpHandler;
import com.example.quintal_dev_3.quintal.adapter.JsonParser;
import com.example.quintal_dev_3.quintal.adapter.SessionManager;
import com.example.quintal_dev_3.quintal.model.ProfileModel;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getName();

    SessionManager session;

    private EditText emailText;
    private EditText passwordText;
    private Button loginButton;
//    private View progressView;
//    private View loginForm;

    //Create json data container
    ArrayList<HashMap<String, String>> profileData;

    private static String url = "https://holidayapi.com/v1/holidays/327a0996-9cff-4fcc-98b3-ac723f305f99";

    private static final String TAG_STATUS = "status";
    private static final String TAG_HOLIDAYS = "holidays";
    private static final String TAG_NAME = "name";
    private static final String TAG_DATE = "date";
    private static final String TAG_OBSERVED = "observed";
    private static final String TAG_PUBLIC = "public";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new SessionManager(getApplicationContext());

        Intent intent = new Intent(this, SplashScreen.class);
        startActivity(intent);

        emailText = (EditText) findViewById(R.id.etEmail);
        passwordText = (EditText) findViewById(R.id.etPassword);
        loginButton = (Button) findViewById(R.id.bLogin);
//        progressView = findViewById(R.id.login_progress);
//        loginForm = findViewById(R.id.login_form);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                url += "email=" + emailText.getText().toString() + "password=" + passwordText.getText().toString();
                if (!validate()) {
                    onLoginFailed();
                    return;
                }
                new GetProfile().execute();
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Login Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    private class GetProfile extends AsyncTask<Void, Void, Void> {

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setIndeterminate(false);
            progressDialog.setMessage("Authenticating...");
            progressDialog.setCancelable(true);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            //Getting Json from file
            StringBuffer sb = new StringBuffer();
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(getAssets().open(
                        "json.json")));
                String temp;
                while ((temp = br.readLine()) != null)
                    sb.append(temp);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close(); // stop reading
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String jsonString = sb.toString();
            JSONObject json = null;
            try {
                json = new JSONObject(jsonString);
                Log.e(TAG, "get Json object");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            //Getting Json from url api
            //JsonParser jsonParser = new JsonParser();
            //JSONObject json = jsonParser.getJSONFromUrl(url);

            Log.e(TAG, "Response from URL" + json);
            if (json != null) {
                try {
                    Log.e(TAG, "Getting json");
                    JSONArray loginStorage = json.getJSONArray("login");
                    for (int i = 0; i < loginStorage.length(); i++) {
                        JSONObject in = loginStorage.getJSONObject(i);
                        String name = in.getString("nama");
                        String email = in.getString("email");
                        session.createLoginSession(name, email);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
            super.onPostExecute(v);
            login();
            progressDialog.dismiss();

        }
    }

    public void login() {
        Log.d(TAG, "Login");

        loginButton.setEnabled(false);

        final String email = emailText.getText().toString();
        final String password = passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.


        //ProfileModel Teacher = new ProfileModel();
        //Possibility of role
        boolean isTeacher = true;
        boolean isStudent = true;
        String roleTeacher = "Teacher"; //get from json
        String roleStudent = "Student"; //get from json
        new Handler().post(
                new Runnable() {
                    public void run() {

                        // On complete call either onLoginSuccess or onLoginFailed
                        if (email.contentEquals("example@quintal.id") && password.contentEquals("quintal123")) {

                            onLoginSuccess();
                        } else {
                            onLoginFailed();
                        }
                    }
                });
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        loginButton.setEnabled(true);
        Intent intent = new Intent(this, UserAreaActivity.class);
        startActivity(intent);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("enter a valid email address");
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            passwordText.setError(null);
        }

        return valid;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //loginDataBaseAdapter.close();
    }
}

