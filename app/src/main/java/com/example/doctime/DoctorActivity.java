package com.example.doctime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DoctorActivity extends AppCompatActivity {

    BottomNavigationView nav_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        nav_view = findViewById(R.id.nav_view);

        nav_view.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                if (item.getItemId() == R.id.home_btn) {
                    intent = new Intent(DoctorActivity.this, HomeActivity.class);
                } else if (item.getItemId() == R.id.appointment_btn) {
                    intent = new Intent(DoctorActivity.this, Appointment.class);
                } else if (item.getItemId() == R.id.doctor_btn) {
                    intent = new Intent(DoctorActivity.this, DoctorActivity.class);
                } else if (item.getItemId() == R.id.profile_btn) {
                    intent = new Intent(DoctorActivity.this, Profile.class);
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