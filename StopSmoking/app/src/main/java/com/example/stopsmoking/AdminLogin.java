package com.example.stopsmoking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class AdminLogin extends AppCompatActivity {

    EditText username, password;
    MaterialButton loginBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        getSupportActionBar().hide();

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);
        backBtn = findViewById(R.id.back);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameText = username.getText().toString();
                String passwordText = password.getText().toString();

                if(usernameText.isEmpty()||passwordText.isEmpty()){
                    Toast.makeText(AdminLogin.this, "Please fill in all the details", Toast.LENGTH_SHORT).show();
                }else if("admin".equals(usernameText)&&"admin".equals(passwordText)) {
                    Intent intent = new Intent(AdminLogin.this, AdminPage.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(AdminLogin.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
                }
            }

        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminLogin.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}