package com.example.doctime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class login extends AppCompatActivity {

    Button loginbutton,signupbutton;

    TextInputLayout usernameInputLayout,passwordInputLayout;
    EditText usernameInput,passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginbutton = findViewById(R.id.loginButton);
        signupbutton = findViewById(R.id.signupButton);

        usernameInputLayout = findViewById(R.id.emailInputLayout);
        passwordInputLayout = findViewById(R.id.passwordInputLayout);

        usernameInput = usernameInputLayout.getEditText();
        passwordInput = passwordInputLayout.getEditText();



        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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