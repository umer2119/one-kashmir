package com.example.bull_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    EditText full_name , user_name,email,phone_number,password;
    Button go,already_have_account;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";//For Validation
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    DatabaseReference registerdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

//        =======HOOKS===========
        full_name = findViewById(R.id.name);
        user_name = findViewById(R.id.username);
        email = findViewById(R.id.email);
        phone_number = findViewById(R.id.phoneNo);
        password = findViewById(R.id.password);
        go = findViewById(R.id.go);
        already_have_account = findViewById(R.id.already_have_account);
        progressDialog=new ProgressDialog(SignUp.this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();


        already_have_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(SignUp.this,Login.class);
                startActivity(ii);
                finish();
            }
        });

//         Go function

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerforAuth();

            }

            private void PerforAuth() {

                String Email = email.getText().toString();
                String Pass = password.getText().toString();
                String userName = user_name.getText().toString();
                String phoneNo = phone_number.getText().toString();
                String fullName = full_name.getText().toString();

//                Real Time DataBase
//                registerdb = FirebaseDatabase.getInstance().getReference().child("UserRegisted");
                registerdb= FirebaseDatabase.getInstance().getReference("UserRegisted");
                class registerUser{
                    String Email = email.getText().toString();
//                    String userName = user_name.getText().toString();
                    String phoneNo = phone_number.getText().toString();
                    String fullName = full_name.getText().toString();
                    String userName=Email.split("[@.';/]")[0];

                    public String getU2() {
                        return userName;
                    }

                    public String getEmail() {
                        return Email;
                    }

                    public String getFullName() {
                        return fullName;
                    }

                    public String getPhoneNo() {
                        return phoneNo;
                    }

//                    public String getUserName() {
//                        return userName;
//                    }
                }

//                registerUser registeruser= new registerUser();
//                registerdb.push().setValue(registeruser);


//                End Real Time Database



                if (!Email.matches(emailPattern)){
                    email.setError("enter valid email");
                }
                else if(Pass.isEmpty() || Pass.length()<6){
                    password.setError("enter proper password");
                }
                else if(phoneNo.length()>10||phoneNo.length()<10){
                    phone_number.setError("phone number should be 10 digits");
                }
                else if(userName.isEmpty() || phoneNo.isEmpty() ||  fullName.isEmpty()){
                    Toast.makeText(SignUp.this, "Every Field Required ", Toast.LENGTH_SHORT).show();
                }
                else{
                    progressDialog.setMessage("Registration.....");
                    progressDialog.setTitle("Registration");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();


                    mAuth.createUserWithEmailAndPassword(Email, Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

// To push data and give sort data in database on the bases of UserName
                                registerUser registeruser= new registerUser();
//                                registerdb.push().setValue(registeruser);
                                registerdb.child(registeruser.userName).setValue(registeruser);

                                progressDialog.dismiss();
                                Toast.makeText(SignUp.this, "Registration sucessfull", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(SignUp.this, Login.class);
                                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(i);

                            }else {
                                progressDialog.dismiss();
                                Toast.makeText(SignUp.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }



            }

        });
    }


}