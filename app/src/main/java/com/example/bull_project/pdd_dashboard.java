package com.example.bull_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.time.Instant;

public class pdd_dashboard extends AppCompatActivity {
    CardView phe_complaint , phe_suggestion , phe_call , phe_newconnection;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdd_dashboard);
        //code for phe complaint
        phe_complaint = findViewById(R.id.phe_complaint);
        phe_complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(pdd_dashboard.this,pdd_complaint.class);
                startActivity(i);

            }
        });
        // end code

//        ===============HOOKS ======================
        phe_suggestion = findViewById(R.id.phe_suggestion);
        toolbar=findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav);


        phe_suggestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(pdd_dashboard.this,pdd_suggestion.class);
                startActivity(i);

            }
        });
        // end code

//        code to make a call
        phe_call = findViewById(R.id.phe_call);
        phe_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:9906669886"));
                startActivity(i);
            }
        });

        phe_newconnection = findViewById(R.id.phe_newconnection);
        phe_newconnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(pdd_dashboard.this,pdd_newconnection.class);
                startActivity(i);

            }
        });

        //        Navigation drawer toggle button

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id)
                {
                    case R.id.nav_home:
                        Intent ii = new Intent(pdd_dashboard.this, dashboard.class);
                        startActivity(ii);
                        finish();
                        break;
                    case R.id.nav_profile:
                        Intent profile = new Intent(pdd_dashboard.this,user_profile.class);
                        startActivity(profile);
                        break;
                    case R.id.nav_contact_us:
                        Intent contact_us = new Intent(pdd_dashboard.this,contact_us.class);
                        startActivity(contact_us);
                        break;
                    case R.id.nav_helpline:
                        Intent help = new Intent(pdd_dashboard.this,helpline.class);
                        startActivity(help);
                        break;
                    case R.id.nav_about_us:
                        Intent about_us = new Intent(pdd_dashboard.this,about_us.class);
                        startActivity(about_us);
                        break;
                    case R.id.nav_logout:
                        Intent i = new Intent(pdd_dashboard.this, Login.class);
                        startActivity(i);
                        finish();
                        break;
                    default:
                        return true;

                }

                return false;
            }
        });

    }
}