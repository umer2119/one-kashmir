package com.example.bull_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class user_profile extends AppCompatActivity {

    DatabaseReference reference;

      EditText name , email, phone, address;
//      DatabaseReference userRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);



        name=findViewById(R.id.profile_name);
        email=findViewById(R.id.profile_email1);
        phone=findViewById(R.id.profile_phone);
        address=findViewById(R.id.profile_address);


//        user = FirebaseAuth.getInstance().getCurrentUser();
//        db.getDatabase().getReference("Re")
//
//        name.setText(user.getDisplayName());
//        email.setText(user.getEmail());




        String user= Login.getValue();



        try {


            reference = FirebaseDatabase.getInstance().getReference("UserRegisted");
            reference.child(user).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {


                    if (task.isSuccessful()) {

                        if (task.getResult().exists()) {

                            Toast.makeText(user_profile.this, "Successfully Read", Toast.LENGTH_SHORT).show();
                            DataSnapshot dataSnapshot = task.getResult();
                            String Email = String.valueOf(dataSnapshot.child("email").getValue());
                            String Name = String.valueOf(dataSnapshot.child("fullName").getValue());
                            String Phone = String.valueOf(dataSnapshot.child("phoneNo").getValue());
                            String userName = String.valueOf(dataSnapshot.child("u2").getValue());
                            email.setText(Email);
                            name.setText(Name);
                            phone.setText(Phone);
                            address.setText(userName);




                        } else {

                            Toast.makeText(user_profile.this, "User Doesn't Exist", Toast.LENGTH_SHORT).show();

                        }
                    } else {

                        Toast.makeText(user_profile.this, "Failed to read", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }catch (Exception e){
            Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
        }


    }
}


