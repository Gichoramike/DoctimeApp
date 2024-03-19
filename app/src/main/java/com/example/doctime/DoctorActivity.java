package com.example.doctime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class DoctorActivity extends AppCompatActivity {

    BottomNavigationView nav_view;
    Button schedulebtn1,schedulebtn2,schedulebtn3,schedulebtn4,schedulebtn5;

    Button btnConfirmDate,btnConfirmTime;
    BottomSheetDialog bottomSheetDialogDate;
    BottomSheetDialog bottonSheetDialogTime;

    TimePicker timePicker;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        nav_view = findViewById(R.id.nav_view);
        schedulebtn1 = findViewById(R.id.scheduleBtn1);
        schedulebtn2 = findViewById(R.id.scheduleBtn2);
        schedulebtn3 = findViewById(R.id.scheduleBtn3);
        schedulebtn4 = findViewById(R.id.scheduleBtn4);
        schedulebtn5 = findViewById(R.id.scheduleBtn5);


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

        schedulebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScheduleBottomSheet();
            }
        });

        schedulebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScheduleBottomSheet();
            }
        });

        schedulebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScheduleBottomSheet();
            }
        });

        schedulebtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScheduleBottomSheet();
            }
        });

        schedulebtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScheduleBottomSheet();
            }
        });


    }

    private void showScheduleBottomSheet() {
        BottomSheetDialog bottomSheetDialogDate = new BottomSheetDialog(DoctorActivity.this);
        View bottomsheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_date, null);
        bottomSheetDialogDate.setContentView(bottomsheetView);

        datePicker = bottomSheetDialogDate.findViewById(R.id.date_picker);
        Button btnConfirmDate = bottomsheetView.findViewById(R.id.btnConfirmDate);

        btnConfirmDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialogDate.dismiss();
                showTimeBottomSheet();
            }
        });
        bottomSheetDialogDate.show();

    }

    private void showTimeBottomSheet() {
        bottonSheetDialogTime = new BottomSheetDialog(DoctorActivity.this);
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_time,null);
        bottonSheetDialogTime.setContentView(bottomSheetView);

        timePicker = bottomSheetView.findViewById(R.id.time_picker);
        btnConfirmTime = bottomSheetView.findViewById(R.id.btnConfirmTime);

        btnConfirmTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottonSheetDialogTime.dismiss();
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();

                int hour;
                int minute;

                if (android.os.Build.VERSION.SDK_INT >= 23) {
                    hour = timePicker.getHour();
                    minute = timePicker.getMinute();
                } else {
                    hour = timePicker.getCurrentHour();
                    minute = timePicker.getCurrentMinute();
                }

                String dateTime = String.format("%02d/%02d/%d %02d:%02d", day, month + 1, year, hour, minute);
                showConfirmationDialog(dateTime);
            }
        });
        bottonSheetDialogTime.show();

    }

    private void showConfirmationDialog(String dateTime) {
        new MaterialAlertDialogBuilder(DoctorActivity.this)
                .setTitle("Confirmation")
                .setMessage("Selcted Date and Time: "+dateTime)
                .setIcon(R.drawable.confirm_icon)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(DoctorActivity.this, DoctorActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                })
                .setCancelable(false)
                .show();
    }
}