package com.example.doctime;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {

    Button loginbutton,signupbutton;
    TextInputLayout emailInputLayout,passwordInputLayout,nameInputLayout;
    EditText emailInput,passwordInput,nameInput;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        loginbutton = findViewById(R.id.loginButton);
        signupbutton = findViewById(R.id.signupButton);

        emailInputLayout = findViewById(R.id.emailInputLayout);
        passwordInputLayout = findViewById(R.id.passwordInputLayout);
        nameInputLayout = findViewById(R.id.nameInputLayout);

        emailInput = emailInputLayout.getEditText();
        passwordInput = passwordInputLayout.getEditText();
        nameInput  = nameInputLayout.getEditText();

        //initializing Firebase Auth
        mAuth = FirebaseAuth.getInstance();



        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signup.this, login.class);
                startActivity(intent);

            }
        });

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();
                String name = nameInput.getText().toString();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(name)){
                    Toast.makeText(signup.this,"Enter fields",Toast.LENGTH_SHORT).show();

                } else if (password.length()<6) {

                    Toast.makeText(signup.this,"password too short!",Toast.LENGTH_SHORT).show();

                }
                else {
                    signupUser(email,password,name);
                    startActivity(new Intent(signup.this, login.class));
                }


            }
        });


    }

    private void signupUser(String email, String password, String name) {
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(signup.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(signup.this, "Signup successful", Toast.LENGTH_SHORT).show();
                    clearInputFields();
                    startActivity(new Intent(signup.this, login.class));
                    finish();
                }
                else {
                    Toast.makeText(signup.this, "Signup failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
    }

    private void clearInputFields() {
    }
}