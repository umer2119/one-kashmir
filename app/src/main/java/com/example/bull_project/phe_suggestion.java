package com.example.bull_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class phe_suggestion extends AppCompatActivity {
     Button submit;
     EditText name,email,suggestion;
     DatabaseReference register_suggestion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phe_suggestion);

        //HOOKS
        submit = findViewById(R.id.submit_phe_suggestion);
        name = findViewById(R.id.username);
        email = findViewById(R.id.email);
        suggestion = findViewById(R.id.suggestion);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                submitSuggesstion();

            }
            public void submitSuggesstion(){

                register_suggestion = FirebaseDatabase.getInstance().getReference().child("PheSuggestions");

                String Email = email.getText().toString();
                String Name = name.getText().toString();
                String Suggestion = suggestion.getText().toString();

                class registerComplaint{
                    String Email = email.getText().toString();
                    String Name = name.getText().toString();
                    String Suggestion =suggestion.getText().toString();


                    public String getUser() {
                        return Name;
                    }

                    public String getEmail() {
                        return Email;
                    }

                    public String getSuggestion() {
                        return Suggestion;
                    }

                }
                if(Name.isEmpty() || Email.isEmpty()  || Suggestion.isEmpty())
                {
                    Toast.makeText(phe_suggestion.this, "Every Field Must Be Filled", Toast.LENGTH_SHORT).show();
                }
                else{
//                    progressDialog.setMessage("Registration.....");
//                    progressDialog.setTitle("Registration");
//                    progressDialog.setCanceledOnTouchOutside(false);
//                    progressDialog.show();
                    registerComplaint COMPLAINT = new registerComplaint();
                    register_suggestion.push().setValue(COMPLAINT);

                    Toast.makeText(phe_suggestion.this, "Thank you for Your Feedback.", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(phe_suggestion.this, phe_dashboard.class);
                    startActivity(i);
                    finish();


                }

            }

        });

    }
}