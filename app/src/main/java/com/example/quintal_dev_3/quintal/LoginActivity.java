package com.example.quintal_dev_3.quintal;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.quintal_dev_3.quintal.parent.HomeParentActivty;
import com.example.quintal_dev_3.quintal.student.activity.HomeActivity;
import com.example.quintal_dev_3.quintal.adapter.SessionManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class LoginActivity extends ProgressDialogActivity {
    private static final String TAG = LoginActivity.class.getName();

    SessionManager session;

    private EditText emailText;
    private EditText passwordText;
    private Button loginButton;

    boolean isStudent;
    boolean isParent;
    boolean isTeacher;

    private String url = "quintal.id";

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Get Firebase auth Instance
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    onLoginSuccess();
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };

        //Save the cuurent data to session
        session = new SessionManager(getApplicationContext());

        Intent intent = new Intent(this, SplashScreen.class);
        startActivity(intent);

        emailText = (EditText) findViewById(R.id.etEmail);
        passwordText = (EditText) findViewById(R.id.etPassword);
        loginButton = (Button) findViewById(R.id.bLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String email = emailText.getText().toString();
                final String password = passwordText.getText().toString();

                if (!validate()) {
                    onLoginFailed();
                    return;
                }

                Log.e(TAG, "button clicked");
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Log.e(TAG, "login failed");
                                    Toast.makeText(LoginActivity.this, getString(R.string.login_failed), Toast.LENGTH_LONG).show();
                                } else {
                                    Log.e(TAG, "login succes");
                                    new GetProfile().execute();
                                    onLoginSuccess();
                                }
                            }
                        });
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        hideProgressDialog();
    }

    private class GetProfile extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showProgressDialog();
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
//            login();
            hideProgressDialog();

        }
    }

//    public void login() {
//        Log.d(TAG, "Login");
//
//        loginButton.setEnabled(false);
//
//        final String email = emailText.getText().toString();
//        final String password = passwordText.getText().toString();
//
//        // TODO: Implement your own authentication logic here.
//
//
//        //ProfileModel Teacher = new ProfileModel();
//        //Possibility of role from json
//
//        new Handler().post(
//                new Runnable() {
//                    public void run() {
//
//                        // On complete call either onLoginSuccess or onLoginFailed
//                        if (email.contentEquals("example@quintal.id") && password.contentEquals("quintal123")) {
//                            onLoginSuccess();
//                        } else {
//                            onLoginFailed();
//                        }
//                    }
//                });
//    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        if (isStudent) {
            onLoginSuccessToStudent();
        } else if (isParent) {
            onLoginSuccessToParent();
        } else if (isTeacher) {
            onLoginSuccessToTeacher();
        }
        //for testing
        Intent intent = new Intent(this, UserAreaActivity.class);
        startActivity(intent);
        finish();
    }

    public void onLoginSuccessToStudent() {
        loginButton.setEnabled(true);
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void onLoginSuccessToParent() {
        loginButton.setEnabled(true);
        Intent intent = new Intent(this, HomeParentActivty.class);
        startActivity(intent);
        finish();
    }

    public void onLoginSuccessToTeacher() {

    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (email.isEmpty()) {
            emailText.setError("email is required");
            valid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("enter a valid email address");
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (password.isEmpty()) {
            passwordText.setError("password is required");
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
