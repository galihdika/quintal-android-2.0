package com.example.quintal_dev_3.quintal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import android.content.Intent;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.quintal_dev_3.quintal.Utility.GlobalVariables;
import com.example.quintal_dev_3.quintal.Utility.LoginService;
import com.example.quintal_dev_3.quintal.model.ProfileModel;
import com.example.quintal_dev_3.quintal.model.RoleModel;
import com.example.quintal_dev_3.quintal.model.User;
import com.example.quintal_dev_3.quintal.model.UserModel;
import com.example.quintal_dev_3.quintal.model.UserRoleModel;
import com.example.quintal_dev_3.quintal.parent.HomeParentActivty;
import com.example.quintal_dev_3.quintal.student.activity.HomeActivity;
import com.example.quintal_dev_3.quintal.adapter.SessionManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends ProgressDialogActivity {

    private static final String TAG = LoginActivity.class.getName();

    SessionManager session;

    private EditText emailText;
    private EditText passwordText;
    private Button loginButton;
    private Button resetButton;

    private ProfileModel profileModel;
    private UserRoleModel userRoleModel;
    private static String role;

//    private FirebaseAuth mAuth;
//    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        //Get Firebase auth Instance
//        mAuth = FirebaseAuth.getInstance();
//        mAuthListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if (user != null) {
//                    // User is signed in
//                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
//                    onLoginSuccess();
//                } else {
//                    // User is signed out
//                    Log.d(TAG, "onAuthStateChanged:signed_out");
//                }
//            }
//        };
//
//        //Save the current data to session
//        session = new SessionManager(getApplicationContext());

        Intent intent = new Intent(this, SplashScreen.class);
        startActivity(intent);

        emailText = (EditText) findViewById(R.id.etEmail);
        passwordText = (EditText) findViewById(R.id.etPassword);
        loginButton = (Button) findViewById(R.id.bLogin);
        resetButton = (Button) findViewById(R.id.bReset_password_login);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String email = emailText.getText().toString();
                final String password = passwordText.getText().toString();

                //pre-authentication of email and password
                if (!validate()) {
                    onLoginFailed();
                    return;
                }

                showProgressDialog(getString(R.string.authentication));

                Gson gson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                        .create();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(getString(R.string.base_url))
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();

                LoginService service = retrofit.create(LoginService.class);

                User user = new User(email, password);

                Call<ProfileModel> profileModelCall = service.login(user);

                profileModelCall.enqueue(new Callback<ProfileModel>() {

                    @Override
                    public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {

                        int statusCode = response.code();

                        //Store json data into Global Variable
                        profileModel = response.body();
                        GlobalVariables globalVariables = ((GlobalVariables)getApplicationContext());
                        globalVariables.downloadAppData();
                        globalVariables.setProfileModel(profileModel);
                        Log.d(TAG, "onResponse: " + statusCode);

                        if (response.isSuccessful()) {
                            userRoleModel = profileModel.getUserRoleSet().get(0);
                            role = userRoleModel.getRole().getName();
                            //Determining user role
                            onLoginSuccess();
                            Log.d(TAG, "role: " + role);
                        } else {
                            Log.e(TAG, "error body: ");
                        }
                        hideProgressDialog();
                    }

                    @Override
                    public void onFailure(Call<ProfileModel> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                        hideProgressDialog();
                        onLoginFailed();
                    }
                });

//                Log.e(TAG, "button clicked");
//                mAuth.signInWithEmailAndPassword(email, password)
//                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
//
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (!task.isSuccessful()) {
//                                    Log.e(TAG, "login failed");
//                                    Toast.makeText(LoginActivity.this, getString(R.string.login_failed), Toast.LENGTH_LONG).show();
//                                } else {
//                                    Log.e(TAG, "login success");
//                                    new GetProfile().execute();
//                                    onLoginSuccess();
//                                }
//                            }
//                        });
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ResetPasswordActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
//        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
//        if (mAuthListener != null) {
//            mAuth.removeAuthStateListener(mAuthListener);
//        }
    }

    @Override
    public void onResume() {
        super.onResume();
        hideProgressDialog();
    }

//    private class GetProfile extends AsyncTask<Void, Void, Void> {
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            showProgressDialog("Authenthicating...");
//        }
//
//        @Override
//        protected Void doInBackground(Void... arg0) {
//
//            //Getting Json from file
//            StringBuffer sb = new StringBuffer();
//            BufferedReader br = null;
//            try {
//                br = new BufferedReader(new InputStreamReader(getAssets().open(
//                        "json.json")));
//                String temp;
//                while ((temp = br.readLine()) != null)
//                    sb.append(temp);
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    br.close(); // stop reading
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            String jsonString = sb.toString();
//            JSONObject json = null;
//            try {
//                json = new JSONObject(jsonString);
//                Log.e(TAG, "get Json object");
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            //Getting Json from url api
//            //JsonParser jsonParser = new JsonParser();
//            //JSONObject json = jsonParser.getJSONFromUrl(url);
//
//            Log.e(TAG, "Response from URL" + json);
//            if (json != null) {
//                try {
//                    Log.e(TAG, "Getting json");
//                    JSONArray loginStorage = json.getJSONArray("login");
//                    for (int i = 0; i < loginStorage.length(); i++) {
//                        JSONObject in = loginStorage.getJSONObject(i);
//                        String name = in.getString("nama");
//                        String email = in.getString("email");
//                        session.createLoginSession(name, email);
//                    }
//                } catch (final JSONException e) {
//                    Log.e(TAG, "Json parsing error: " + e.getMessage());
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(getApplicationContext(),
//                                    "Json parsing error: " + e.getMessage(),
//                                    Toast.LENGTH_LONG).show();
//                        }
//                    });
//                }
//            } else {
//                Log.e(TAG, "Couldn't get json from server.");
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getApplicationContext(),
//                                "Couldn't get json from server. Check LogCat for possible errors!",
//                                Toast.LENGTH_LONG).show();
//                        finish();
//                    }
//                });
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void v) {
//            super.onPostExecute(v);
//            hideProgressDialog();
//        }
//    }

    @Override
    public void onBackPressed() {
        // disable going back
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {

        if (role.equals("Student")) {
            onLoginSuccessToStudent();
        } else if (role.equals("Parent")) {
            onLoginSuccessToParent();
        } else if (role.equals("Teacher")) {
            onLoginSuccessToTeacher();
        }
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
        Toast.makeText(getBaseContext(), R.string.login_failed, Toast.LENGTH_SHORT).show();
        loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (email.isEmpty()) {
            emailText.setError(getString(R.string.email_required));
            valid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError(getString(R.string.enter_valid_email));
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (password.isEmpty()) {
            passwordText.setError(getString(R.string.password_required));
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

