package com.example.doctime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;

public class Speciality extends AppCompatActivity {

    MaterialCardView card_general,card_dentist,card_pediatric,card_optha,card_cardiologist,card_ear;

    BottomNavigationView nav_view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speciality);

        card_general = findViewById(R.id.card_general);
        card_dentist = findViewById(R.id.card_dentist);
        card_pediatric = findViewById(R.id.card_pediatric);
        card_optha = findViewById(R.id.card_optha);
        card_cardiologist = findViewById(R.id.card_cardiologist);
        card_ear = findViewById(R.id.card_ear);

        nav_view = findViewById(R.id.nav_view);

        card_general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Speciality.this, General_Doctors.class);
                startActivity(intent);
            }
        });

        card_dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Speciality.this, Dentist_Doctors.class);
                startActivity(intent);
            }
        });

        card_pediatric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Speciality.this, Pediatric_Doctors.class);
                startActivity(intent);
            }
        });

        card_optha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Speciality.this, Optha_Doctors.class);
                startActivity(intent);
            }
        });

        card_cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Speciality.this, Cardiologist_Doctors.class);
                startActivity(intent);
            }
        });

        card_ear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Speciality.this, Ear_Doctors.class);
                startActivity(intent);
            }
        });

        nav_view.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                if (item.getItemId() == R.id.home_btn) {
                    intent = new Intent(Speciality.this, HomeActivity.class);
                } else if (item.getItemId() == R.id.appointment_btn) {
                    intent = new Intent(Speciality.this, Appointment.class);
                } else if (item.getItemId() == R.id.doctor_btn) {
                    intent = new Intent(Speciality.this, DoctorActivity.class);
                } else if (item.getItemId() == R.id.profile_btn) {
                    intent = new Intent(Speciality.this, Profile.class);
                }
                if (intent != null) {
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }
}