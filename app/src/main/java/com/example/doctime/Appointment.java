package com.example.doctime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TimePicker;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Appointment extends AppCompatActivity {

    BottomNavigationView nav_view;

//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);


        nav_view = findViewById(R.id.nav_view);
//        date_picker = findViewById(R.id.date_picker);




        nav_view.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                if (item.getItemId() == R.id.home_btn) {
                    intent = new Intent(Appointment.this, HomeActivity.class);
                } else if (item.getItemId() == R.id.appointment_btn) {
                    intent = new Intent(Appointment.this, Appointment.class);
                } else if (item.getItemId() == R.id.doctor_btn) {
                    intent = new Intent(Appointment.this, DoctorActivity.class);
                } else if (item.getItemId() == R.id.profile_btn) {
                    intent = new Intent(Appointment.this, Profile.class);
                }
                if (intent != null) {
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

//        time_picker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
//
//            }
//        });
    }
}