package com.example.bull_project;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    Button callSignUp , go ,forget_password;
    static  EditText email, pass;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;



    //For Phone Permission variable
    private int PHONE_PERMISSION = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//TO HIDE STATUS BAR
        setContentView(R.layout.activity_login);

        requestPhonePermission();


//        ============HOOOKS========

        callSignUp = findViewById(R.id.signUP_screen);
        go = findViewById(R.id.go_1);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        forget_password = findViewById(R.id.forget_password);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();


        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this,Forget_password.class);
                startActivity(i);

            }
        });


        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this,SignUp.class);
                startActivity(i);

            }
        });





        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerformLogin();
            }
        });




    }

    private void PerformLogin() {
        String Email = email.getText().toString();
        String Pass = pass.getText().toString();


        if (!Email.matches(emailPattern)){
            email.setError("enter valid email");
        }
        else if(Pass.isEmpty() || Pass.length()<6){
            pass.setError("enter proper password");
        }else {
            progressDialog.setMessage("Logging in.....");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            mAuth.signInWithEmailAndPassword(Email, Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();

                        Toast.makeText(Login.this, "Login Successfull", LENGTH_SHORT).show();
                        Intent i = new Intent(Login.this, dashboard.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(Login.this,go,"dash_img1");
                        startActivity(i,options.toBundle());
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(Login.this, "Sorry Inavlid Email or Password", LENGTH_SHORT).show();
                    }
                }
            });

        }

    }

    public static String getValue(){
        String[] User=email.getText().toString().split("@");

        return User[0];
    }


    //    =======================REQUEST PERMISSION=================

    private void requestPhonePermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)){
            new AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("permission needed ")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActivityCompat.requestPermissions(Login.this, new String[] {Manifest.permission.CALL_PHONE},PHONE_PERMISSION );
//                            ActivityCompat.requestPermissions(Login.this, new String[] {Manifest.permission.SEND_SMS},PHONE_PERMISSION );

                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).create().show();

        }else{
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE},PHONE_PERMISSION );

        }
    }



}