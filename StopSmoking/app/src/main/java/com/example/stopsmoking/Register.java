package com.example.stopsmoking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    FirebaseDatabase db;
    DatabaseReference reference;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        final EditText regUsername = findViewById(R.id.username);
        final EditText regEmail = findViewById(R.id.email);
        final EditText regPassword = findViewById(R.id.password);
        final EditText regPhone = findViewById(R.id.phone);

        final MaterialButton registerBtn = findViewById(R.id.registerBtn);
        final TextView login = findViewById(R.id.login);

        mAuth = FirebaseAuth.getInstance();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = regUsername.getText().toString();
                String email = regEmail.getText().toString();
                String password = regPassword.getText().toString();
                String phone = regPhone.getText().toString();

                if(username.isEmpty()||email.isEmpty()||password.isEmpty()||phone.isEmpty()){
                    Toast.makeText(Register.this,"Please fill in all the details",Toast.LENGTH_SHORT).show();
                }
                else {
                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){

                                Users user = new Users(username,email,password,phone);
                                //Insert into realtime database
                                FirebaseDatabase.getInstance().getReference("users")
                                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                .setValue(user);

                                Toast.makeText(Register.this,"Registered",Toast.LENGTH_SHORT).show();
                                //return to login page after register successful
                                startActivity(new Intent(Register.this,MainActivity.class));
                        }
                            else{
                                Toast.makeText(Register.this,"Failed to register",Toast.LENGTH_SHORT).show();
                            }
                    }
                    });
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }//on create
}//public class