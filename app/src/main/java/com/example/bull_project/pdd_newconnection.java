package com.example.bull_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class pdd_newconnection extends AppCompatActivity {

    Button phe_payment , phe_submit;
    String[] dist={"Baramulla", "Srinagar", "Budgam", "Bandipora"};
    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapter_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdd_newconnection);


        autoCompleteTextView=findViewById(R.id.auto_complete);
        adapter_items=new ArrayAdapter<String>(this, R.layout.list, dist);
        autoCompleteTextView.setAdapter(adapter_items);

        phe_payment = findViewById(R.id.phe_payment);
        phe_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://billsahuliyat.jkpdd.net/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        phe_submit = findViewById(R.id.submit_phe_newconection);
        phe_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(pdd_newconnection.this , pdd_dashboard.class);
                startActivity(i);
                finish();

            }
        });


    }
}