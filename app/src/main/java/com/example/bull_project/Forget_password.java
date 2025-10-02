package com.example.bull_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forget_password extends AppCompatActivity {
    EditText email;
    Button sendlink;
//    private ProgressBar progressBar;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        email=findViewById(R.id.email);
        sendlink=findViewById(R.id.sendlink);


        sendlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=email.getText().toString();

//                progressBar.setVisibility(View.VISIBLE);

                try {
                    FirebaseAuth.getInstance().sendPasswordResetEmail(Email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
//
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Forget_password.this, "Email sent", Toast.LENGTH_SHORT).show();

                                    }
                                    else {
                                        Toast.makeText(Forget_password.this, "Account Not Found", Toast.LENGTH_SHORT).show();
                                    }
//                                progressBar.setVisibility(View.GONE);
                                }
                            });
                }catch (Exception e){
                    Toast.makeText(Forget_password.this, ""+e, Toast.LENGTH_SHORT).show();
                }


            }
        });



    }
}