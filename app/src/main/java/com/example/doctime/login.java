package com.example.doctime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public  class login extends AppCompatActivity {

    Button loginbutton,signupbutton;

    TextInputLayout emailInputLayout,passwordInputLayout;
    EditText emailInput,passwordInput;

    ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginbutton = findViewById(R.id.loginButton);
        signupbutton = findViewById(R.id.signupButton);

        emailInputLayout = findViewById(R.id.emailInputLayout);
        passwordInputLayout = findViewById(R.id.passwordInputLayout);

        emailInput = emailInputLayout.getEditText();
        passwordInput = passwordInputLayout.getEditText();

        progressBar = findViewById(R.id.progressBar);

        //initializing Firebase Auth
        mAuth = FirebaseAuth.getInstance();



        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) ){
                    Toast.makeText(login.this,"Enter fields",Toast.LENGTH_SHORT).show();

                } else if (password.length()<6) {

                    Toast.makeText(login.this,"password too short!",Toast.LENGTH_SHORT).show();

                }
                else {
                    loginUser(email,password);
                }


            }

            private void loginUser(String email, String password) {

                progressBar.setVisibility(View.VISIBLE);
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Login successful",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Login Failed..",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);

            }
        });



    }
}
