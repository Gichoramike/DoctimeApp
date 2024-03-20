package com.example.doctime;

import static com.example.doctime.R.id.home_btn;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar; // Import the Toolbar class
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.doctime.databinding.ActivityHomeBinding;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.search.SearchBar;

public class HomeActivity extends AppCompatActivity {


//    private ActivityHomeBinding binding;
//    SearchBar search_bar;
    Button btnViewAll;

    CardView card_general,card_dentist,card_pediatric;
    BottomNavigationView nav_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        search_bar = findViewById(R.id.search_bar);
        card_general = findViewById(R.id.card_general);
        card_dentist = findViewById(R.id.card_dentist);
        card_pediatric = findViewById(R.id.card_pediatric);

        btnViewAll = findViewById(R.id.btnViewAll);
        nav_view = findViewById(R.id.nav_view);


        nav_view.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                if (item.getItemId() == R.id.home_btn) {
                    intent = new Intent(HomeActivity.this, HomeActivity.class);
                } else if (item.getItemId() == R.id.appointment_btn) {
                    intent = new Intent(HomeActivity.this, Appointment.class);
                } else if (item.getItemId() == R.id.doctor_btn) {
                    intent = new Intent(HomeActivity.this, DoctorActivity.class);
                } else if (item.getItemId() == R.id.profile_btn) {
                    intent = new Intent(HomeActivity.this, Profile.class);
                }
                if (intent != null) {
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, Speciality.class);
                startActivity(intent);

            }
        });






        card_general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, General_Doctors.class);
                startActivity(intent);
            }
        });

        card_dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this, Dentist_Doctors.class);
                startActivity(intent);
            }
        });

        card_pediatric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, Pediatric_Doctors.class);
                startActivity(intent);
            }
        });


    }
}
