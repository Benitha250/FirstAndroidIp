package com.example.firstandroidip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.email) EditText email;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.registerTextView) TextView mRegisterTextView;
    @BindView(R.id.LoginButton) Button Login_Button;
    private FirebaseAuth mAuth;
    final  String TAG = "LoginActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();


        Login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logIn(email.getText().toString(), password.getText().toString());
            }
        });

        mRegisterTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
                startActivity(intent);
            }
        });
    }

    private void logIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Log.d(TAG, "signInWithEmail: success");
                        FirebaseUser user = mAuth.getCurrentUser();

                        Toast.makeText(LoginActivity.this, "Authentication successful  " +user.getEmail(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, ProfileActivity.class));
                        finish();

                    }
                    else{
                        Log.v(TAG, "signInWithEmail: failure", task.getException());
                        Toast.makeText(LoginActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    @Override
    protected void onStart() {
        super.onStart();

       FirebaseUser user = mAuth.getCurrentUser();
       if (user != null){
           startActivity(new Intent(LoginActivity.this, ProfileActivity.class));
           finish();
       }
    }
}
