//package com.example.bull_project;
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.ActionBarDrawerToggle;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.cardview.widget.CardView;
//import androidx.drawerlayout.widget.DrawerLayout;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Toast;
//import android.widget.Toolbar;
//import com.google.android.material.navigation.NavigationView;
//import androidx.core.content.ContextCompat;
//import androidx.core.view.GravityCompat;
//import android.Manifest;
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.content.pm.PackageManager;
//import android.os.Handler;
//
//
//
//
//
//
//
//
//
//
//
//public class dashboard extends AppCompatActivity {
//
//    Toolbar toolbar;
//    DrawerLayout drawerLayout;
//    NavigationView navigationView;
//
//
//    CardView phe_card ;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dashboard);
//
//
//
//
//        phe_card = findViewById(R.id.phe_1);
//        phe_card.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(dashboard.this,phe_dashboard.class);
//                startActivity(i);
//            }
//        });
//
//
//
//
//        //===================HOOKS ================================
//
//        drawerLayout = findViewById(R.id.drawer);
//        navigationView = findViewById(R.id.nav);
//        toolbar = findViewById(R.id.toolbar);
////        ============================================================
//
//
//
//
//
//
//
//////        navigation drawer toggle button
//
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//
//
//
//
//
//
//
//
//
//
//
//
//
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id = item.getItemId();
//                switch (id)
//                {
//                    case R.id.nav_home:
//                        Toast.makeText(dashboard.this,"home",Toast.LENGTH_LONG).show();
//                        break;
//                    case R.id.nav_profile:
//                        Toast.makeText(dashboard.this,"WELCOME TO PROFILE",Toast.LENGTH_LONG).show();
//                        break;
//                    case R.id.nav_contact_us:
//                        Toast.makeText(dashboard.this,"CONTACT US",Toast.LENGTH_LONG).show();
//                        break;
//                    case R.id.nav_helpline:
//                        Toast.makeText(dashboard.this,"HELPLINE",Toast.LENGTH_LONG).show();
//                        break;
//                    case R.id.nav_about_us:
//                        Toast.makeText(dashboard.this,"UMER FAROOQ",Toast.LENGTH_LONG).show();
//                        break;
//                    case R.id.nav_logout:
//                        Intent i = new Intent(dashboard.this, Login.class);
//                        startActivity(i);
//                        finish();
//                        break;
//                    default:
//                        return true;
//
//                }
//
//                return false;
//            }
//        });
//
//
//
//    }
//}
//
//
//
//


package com.example.bull_project;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class dashboard extends AppCompatActivity {


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    CardView phe_card , pdd_card,pwd_card, tourism_card ,about_us ,disaster ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

//        ========================HOOKS
        phe_card = findViewById(R.id.phe_1);
        pdd_card = findViewById(R.id.pdd_1);
        tourism_card = findViewById(R.id.tourism_1);
        pwd_card = findViewById(R.id.pwd_1);
        about_us = findViewById(R.id.about_us_from_main);
        disaster = findViewById(R.id.disaster);

        //        ========= FOR About Us ====================
        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                about_us.setCardBackgroundColor(14);
                Intent i = new Intent(dashboard.this,about_us.class);
                startActivity(i);
            }
        });




        //        ========= FOR Disaster ====================
        disaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disaster.setCardBackgroundColor(23);
                Uri uri = Uri.parse("https://jksdma.org/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });




        //        ========= FOR PWD ====================
        pwd_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pwd_card.setCardBackgroundColor(12);
                Intent i = new Intent(dashboard.this,pwd_dashboard.class);
                startActivity(i);
            }
        });


//        ========= FOR PHE ====================
        phe_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phe_card.setCardBackgroundColor(21);
                Intent i = new Intent(dashboard.this,phe_dashboard.class);
                startActivity(i);
            }
        });

        //        ========= FOR Pdd ====================
        pdd_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pdd_card.setCardBackgroundColor(11);
                Intent i = new Intent(dashboard.this,pdd_dashboard.class);
                startActivity(i);
            }
        });

        //        ========= FOR Tourism ====================
        tourism_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tourism_card.setCardBackgroundColor(24);
                Intent i = new Intent(dashboard.this,tourism_dashboard.class);
                startActivity(i);
            }
        });




//        ==============HOOKS================================================================

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav);
        toolbar=findViewById(R.id.toolbar);

//        =====================================================================================


//            Navigation drawer toggle button

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


//        ============================================================================================================================




//        =============NAVIGATION DRAWER EVENT LISTENER==========================

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id)
                {
                    case R.id.nav_home:
                        Toast.makeText(dashboard.this,"Home",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_profile:
                        Intent profile = new Intent(dashboard.this,user_profile.class);
                        startActivity(profile);
                        break;
                    case R.id.nav_contact_us:
                        Intent contact_us = new Intent(dashboard.this,contact_us.class);
                        startActivity(contact_us);
                        break;
                    case R.id.nav_helpline:
                        Intent help = new Intent(dashboard.this,helpline.class);
                        startActivity(help);

                        break;
                    case R.id.nav_about_us:
                        Intent about_us = new Intent(dashboard.this,about_us.class);
                        startActivity(about_us);
                        break;
                    case R.id.nav_logout:
                        Intent ii = new Intent(dashboard.this, Login.class);
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


    //    ===============MISS TOUCH PREVENTION=====================================
    boolean mbackpressed=false;
    @Override
    public void onBackPressed() {


        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else if (drawerLayout.isDrawerOpen(GravityCompat.END)){
            drawerLayout.closeDrawer(GravityCompat.END);
        }
        else {
            if (mbackpressed == true) {
                super.onBackPressed();
            } else {
                mbackpressed = true;
                Toast.makeText(this, "Click again to exit", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mbackpressed = false;
                    }
                }, 2000);
            }
        }



    }


}