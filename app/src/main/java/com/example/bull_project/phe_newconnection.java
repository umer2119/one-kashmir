package com.example.bull_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class phe_newconnection extends AppCompatActivity {

    Button phe_payment , phe_submit;
    String[] dist={"Baramulla", "Srinagar", "Budgam", "Bandipora"};
    AutoCompleteTextView autoCompleteTextView;
    EditText name,email,address,id_proof;
    DatabaseReference request_new_connection;


    ArrayAdapter<String> adapter_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phe_newconnection);

//        HOOK for dropdown list
        autoCompleteTextView=findViewById(R.id.auto_complete);


        adapter_items=new ArrayAdapter<String>(this, R.layout.list, dist);
        autoCompleteTextView.setAdapter(adapter_items);


//        HOOKS
        phe_payment = findViewById(R.id.phe_payment);
        name = findViewById(R.id.username);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        id_proof = findViewById(R.id.id_proof);



        phe_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://jkphedwaterbilling.com/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        phe_submit = findViewById(R.id.submit_phe_newconection);

        phe_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RequestForNewConnection();
            }

            public void RequestForNewConnection(){

                request_new_connection = FirebaseDatabase.getInstance().getReference().child("PheNewConnection");

                String Email = email.getText().toString();
                String Name = name.getText().toString();
                String Address=address.getText().toString();
                String Idproof = id_proof.getText().toString();
                String District =autoCompleteTextView.getText().toString();


                class registerComplaint{
                    String Email = email.getText().toString();
                    String Name = name.getText().toString();
                    String Address=address.getText().toString();
                    String District =autoCompleteTextView.getText().toString();
                    String Idproof =id_proof.getText().toString();


                    public String getUser() {
                        return Name;
                    }

                    public String getEmail() {
                        return Email;
                    }


                    public String getAddress() {
                        return Address;
                    }

                    public String getDistrict() {
                        return District;
                    }

                    public String getIdproof() {
                        return Idproof;
                    }

                }
                if(Name.isEmpty() || Email.isEmpty() || Address.isEmpty() ||District.isEmpty() || Idproof.isEmpty())
                {
                    Toast.makeText(phe_newconnection.this, "Every Field Must Be Filled", Toast.LENGTH_SHORT).show();
                }
                else{
//                    progressDialog.setMessage("Registration.....");
//                    progressDialog.setTitle("Registration");
//                    progressDialog.setCanceledOnTouchOutside(false);
//                    progressDialog.show();
                    registerComplaint COMPLAINT = new registerComplaint();
                    request_new_connection.push().setValue(COMPLAINT);

                    Toast.makeText(phe_newconnection.this, "Application Sent Successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(phe_newconnection.this,phe_dashboard.class);
                    startActivity(i);
                    finish();
                }

            }
        });


    }
}