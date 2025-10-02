package com.example.bull_project;

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

public class tourist_destination extends AppCompatActivity {

    Intent i;

    CardView gulmarg,wallur,dal_lake,pehalgam,mugal_garden,yousmarg;

    //    Objects for Toggle orr navigation bar
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_destination);

        // ==============HOOKS================================================================
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav);
        toolbar=findViewById(R.id.toolbar);
        gulmarg = findViewById(R.id.gulmarg_card);
        pehalgam = findViewById(R.id.pehalgam_card);
        wallur = findViewById(R.id.walur_card);
        dal_lake = findViewById(R.id.dal_lake_card);
        mugal_garden = findViewById(R.id.mugal_card);
        yousmarg = findViewById(R.id.yousmarg_card);

        gulmarg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(tourist_destination.this, gulmarg.class);
                startActivity(i);
            }
        });





        //  ===================  Navigation drawer toggle button
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //        =============NAVIGATION DRAWER EVENT LISTENER==========================

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id)
                {
                    case R.id.nav_home:
                        Intent ii = new Intent(tourist_destination.this, dashboard.class);
                        startActivity(ii);
                        finish();
                        break;
                    case R.id.nav_profile:
                        Toast.makeText(tourist_destination.this,"WELCOME TO PROFILE",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_contact_us:
                        Toast.makeText(tourist_destination.this,"CONTACT US",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_helpline:
                        Toast.makeText(tourist_destination.this,"HELPLINE",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_about_us:
                        Toast.makeText(tourist_destination.this,"UMER FAROOQ",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_logout:
                        Intent i = new Intent(tourist_destination.this, Login.class);
                        startActivity(i);
                        finish();
                        break;
                    default:
                        return true;

                }

                return false;
            }
        });

//        =============================tourism_destination===================







    }
}