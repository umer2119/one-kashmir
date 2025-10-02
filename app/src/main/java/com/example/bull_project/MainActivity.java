package com.example.bull_project;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;


    // Variables
    Animation topAnim , bottomAnim;
    ImageView img1,img2;
    TextView umer , majid ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//TO HIDE STATUS BAR
        setContentView(R.layout.activity_main);

        //Animations
        topAnim  = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim  = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //TO set annimations on the image or hooks
        img1 = findViewById(R.id.map_image);
        img2 = findViewById(R.id.one_kashmir);
        umer = findViewById(R.id.umer);
        majid = findViewById(R.id.majid);

        img1.setAnimation(topAnim);
        img2.setAnimation(bottomAnim);
        umer.setAnimation(topAnim);
        majid.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this , Login.class);
                Pair[] pairs =     new Pair[2];
                pairs[0] = new Pair<View,String>(img1,"logo_image") ;
                pairs[1] = new Pair<View,String>(img2,"logo_text") ;
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                startActivity(i,options.toBundle());
                finish();
            }
        },SPLASH_SCREEN);

    }
}