package com.example.myrlgarage.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myrlgarage.R;
import com.example.myrlgarage.databinding.ActivityCreateAccountBinding;
import com.example.myrlgarage.databinding.ActivityLoginBinding;
import com.example.myrlgarage.models.MessageUtility;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAccountActivity extends AppCompatActivity {
    ActivityCreateAccountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateAccountBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.createAccountBtn.setOnClickListener(v -> createAccount());
        binding.loginTextViewBtn.setOnClickListener(v -> finish());

    }

    void createAccount(){
        String email = binding.emailEditText.getText().toString();
        String password = binding.passwordEditText.getText().toString();
        String confirmPassword = binding.confirmPasswordEditText.getText().toString();

        boolean isValidated = validate(email, password, confirmPassword);
        if(!isValidated){
            return;
        }

        createAccountInFirebase(email, password);

    }

    void createAccountInFirebase(String email, String password){
        changeInProgress(true);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(CreateAccountActivity.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        changeInProgress(false);
                        if(task.isSuccessful()){
                            //sign up uspješan
                            MessageUtility.showToast(CreateAccountActivity.this, "Account created successfully. " +
                                    "Check your inbox for verification mail.");
                            firebaseAuth.getCurrentUser().sendEmailVerification();
                            firebaseAuth.signOut();
                            finish();
                        } else{
                            //sign up neuspješan
                            MessageUtility.showToast(CreateAccountActivity.this, task.getException().getLocalizedMessage());
                        }
                    }
                }
        );


    }

    void changeInProgress(boolean inProgress){
        if(inProgress){
            binding.progressBar.setVisibility(View.VISIBLE);
            binding.createAccountBtn.setVisibility(View.GONE);
        } else{
            binding.progressBar.setVisibility(View.GONE);
            binding.createAccountBtn.setVisibility(View.VISIBLE);
        }
    }

    boolean validate(String email, String password, String confirmPassword){
        //validacija podataka na sign up formi

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.emailEditText.setError("Invalid email");
            return false;
        }
        if(password.length() < 8){
            binding.passwordEditText.setError("Password must be at least 8 characters long");
            return false;
        }
        if(!password.equals(confirmPassword)){
            binding.confirmPasswordEditText.setError("Passwords don't match");
            return false;
        }

        return true;
    }

}