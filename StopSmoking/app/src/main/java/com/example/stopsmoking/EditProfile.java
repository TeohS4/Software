package com.example.stopsmoking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfile extends AppCompatActivity {
    FirebaseDatabase db;
    DatabaseReference reference;
    FirebaseAuth mAuth;

    ImageView backbutton;
    Button updatebutton;
    EditText username,email,password,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        backbutton = findViewById(R.id.back_profile);
        updatebutton = findViewById(R.id.btn_update);

        username = findViewById(R.id.edit_username);
        email = findViewById(R.id.edit_password);
        password = findViewById(R.id.edit_password);
        phone = findViewById(R.id.edit_phone);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBack();
            }
        });

        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String editUsername = username.getText().toString();
                String editEmail = email.getText().toString();
                String editPassword = password.getText().toString();
                String editPhone = phone.getText().toString();

                if (editUsername.isEmpty()||editEmail.isEmpty()||editPassword.isEmpty()||editPhone.isEmpty()){
                    showToast("Please fill in all the details");
                } else {


                    showToast("Update Successfully");
                    openBackMain();
                }
            }
        });

    }
//functions
    private void showToast(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
    public void openBack(){
        Intent intent = new Intent(this,Settings.class);
        startActivity(intent);
    }
    public void openBackMain(){
        Intent intent = new Intent(this,HomePage.class);
        startActivity(intent);
    }
}