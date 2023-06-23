package com.example.myrlgarage.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myrlgarage.R;
import com.example.myrlgarage.databinding.ActivityLoginBinding;
import com.example.myrlgarage.models.MessageUtility;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.loginBtn.setOnClickListener(v -> loginUser());
        binding.signupTextViewBtn.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, CreateAccountActivity.class)));
    }

    void loginUser(){
        String email = binding.emailEditText.getText().toString();
        String password = binding.passwordEditText.getText().toString();

        boolean isValidated = validate(email, password);
        if(!isValidated){
            return;
        }

        loginAccountInFirebase(email, password);
    }

    void loginAccountInFirebase(String email, String password){
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        changeInProgress(true);
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                changeInProgress(false);
                if(task.isSuccessful()){
                    //login uspješan
                    if(firebaseAuth.getCurrentUser().isEmailVerified()){
                        //prebacivanje na main activity
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    } else{
                        MessageUtility.showToast(LoginActivity.this, "Email not verified");
                    }
                } else{
                    //login neuspješan
                    MessageUtility.showToast(LoginActivity.this, task.getException().getLocalizedMessage());
                }
            }
        });


    }

    void changeInProgress(boolean inProgress){
        if(inProgress){
            binding.progressBar.setVisibility(View.VISIBLE);
            binding.loginBtn.setVisibility(View.GONE);
        } else{
            binding.progressBar.setVisibility(View.GONE);
            binding.loginBtn.setVisibility(View.VISIBLE);
        }
    }

    boolean validate(String email, String password){
        //validacija podataka na login formi

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.emailEditText.setError("Invalid email");
            return false;
        }
        if(password.length() < 8){
            binding.passwordEditText.setError("Password must be at least 8 characters long");
            return false;
        }

        return true;
    }
}