package com.example.bull_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pdd_suggestion extends AppCompatActivity {
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdd_suggestion);

//        submit = findViewById(R.id.submit_pdd_complaint);
        submit = findViewById(R.id.submit_pdd_feedback);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(pdd_suggestion.this, pdd_dashboard.class);
                startActivity(i);
                finish();
            }
        });


    }
}