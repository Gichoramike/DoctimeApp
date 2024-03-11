package com.example.doctime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class signup extends AppCompatActivity {

    Button loginbutton,signupbutton;
    TextInputLayout usernameInputLayout,passwordInputLayout,confirmInputLayout;
    EditText usernameInput,passwordInput,confirmInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        loginbutton = findViewById(R.id.loginButton);
        signupbutton = findViewById(R.id.signupButton);

        usernameInputLayout = findViewById(R.id.usernameInputLayout);
        passwordInputLayout = findViewById(R.id.passwordInputLayout);
        confirmInputLayout = findViewById(R.id.passwordInputLayout);

        usernameInput = usernameInputLayout.getEditText();
        passwordInput = passwordInputLayout.getEditText();
        confirmInput  = confirmInputLayout.getEditText();

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signup.this, HomeActivity.class);
                startActivity(intent);

            }
        });

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}