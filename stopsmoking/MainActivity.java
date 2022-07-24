package com.example.stopsmoking;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.Login;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase db;
    DatabaseReference reference;
    FirebaseAuth mAuth;

    ImageView googleBtn;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    MaterialButton adminBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        googleBtn = findViewById(R.id.google_btn);

        TextView email = (TextView)  findViewById(R.id.email);
        TextView password =(TextView)  findViewById(R.id.password);
        MaterialButton loginBtn = (MaterialButton)  findViewById(R.id.loginBtn);
        TextView createBtn = findViewById(R.id.createNew);
        adminBtn = findViewById(R.id.adminBtn);

        mAuth = FirebaseAuth.getInstance();

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        gsc = GoogleSignIn.getClient(this,gso);

        //what happens when user click the button
        googleBtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             SignIn();
                                         }
                                     });


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String emailText = email.getText().toString();
                final String passwordText = password.getText().toString();

                if (emailText.isEmpty() || passwordText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all the details", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.signInWithEmailAndPassword(emailText, passwordText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, HomePage.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "Wrong Email or Password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });

        adminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdminLogin.class);
                startActivity(intent);
            }
        });
    }
    //BELOW IS FUNCTION
    //function for sign in using google account
    private void SignIn() {
        Intent intent = gsc.getSignInIntent();
        startActivityForResult(intent,100);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==100){
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                navigateToHome();
            }catch (ApiException e){
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void navigateToHome(){
        finish();
        Intent intent = new Intent(MainActivity.this,HomePage.class);
        startActivity(intent);
    }
}
