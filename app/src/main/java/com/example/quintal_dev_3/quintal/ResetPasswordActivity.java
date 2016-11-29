package com.example.quintal_dev_3.quintal;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends ProgressDialogActivity {
    
    private EditText inputEmail;
    private Button buttonReset;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        
        inputEmail = (EditText) findViewById(R.id.etEmail_reset);
        buttonReset = (Button) findViewById(R.id.bReset_password);
        
        mAuth = FirebaseAuth.getInstance();
        
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                String email = inputEmail.getText().toString().trim();
                
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplication(), "Enter your registered email address", Toast.LENGTH_SHORT).show();
                }
                
                showProgressDialog();
                mAuth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ResetPasswordActivity.this, "We have send instruction to your email to reset your password", Toast.LENGTH_SHORT).show();
                                } else {
                                    hideProgressDialog();
                                }
                            }
                        });
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
