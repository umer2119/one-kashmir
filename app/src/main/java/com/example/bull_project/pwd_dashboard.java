package com.example.bull_project;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class pwd_dashboard extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    CardView pwd_complaint;




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwd_dashboard);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav);
        toolbar=findViewById(R.id.toolbar);
        pwd_complaint = findViewById(R.id.phe_complaint);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        pwd_complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(pwd_dashboard.this,pwd_complaint.class);
                startActivity(ii);
            }
        });




//        =============NAVIGATION DRAWER EVENT LISTENER==========================

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id)
                {
                    case R.id.nav_home:
                        Intent i = new Intent(pwd_dashboard.this, dashboard.class);
                        startActivity(i);
                        finish();
                        break;
                    case R.id.nav_profile:
                        Intent profile = new Intent(pwd_dashboard.this,user_profile.class);
                        startActivity(profile);
                        break;
                    case R.id.nav_contact_us:
                        Intent contact_us = new Intent(pwd_dashboard.this,contact_us.class);
                        startActivity(contact_us);
                        break;
                    case R.id.nav_helpline:
                        Intent help = new Intent(pwd_dashboard.this,helpline.class);
                        startActivity(help);
                        break;
                    case R.id.nav_about_us:
                        Intent about_us = new Intent(pwd_dashboard.this,about_us.class);
                        startActivity(about_us);
                        break;
                    case R.id.nav_logout:
                        Intent ii = new Intent(pwd_dashboard.this, Login.class);
                        startActivity(ii);
                        finish();
                        break;
                    default:
                        return true;

                }

                return false;
            }
        });

//        ================================================================================================================




    }
}