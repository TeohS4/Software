package com.example.stopsmoking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomePage extends AppCompatActivity {
    TextView email;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    FirebaseDatabase db;
    DatabaseReference reference;
    FirebaseAuth mAuth;

    CardView homeBtn;
    CardView achievementBtn;
    CardView leaderboardBtn;
    CardView getHelpBtn;
    CardView settingsBtn;
    CardView logOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.textEmail);

        homeBtn = findViewById(R.id.cardHome);
        achievementBtn = findViewById(R.id.cardChat);
        leaderboardBtn = findViewById(R.id.cardLeaderboard);
        getHelpBtn = findViewById(R.id.cardHelp);
        settingsBtn = findViewById(R.id.cardSettings);
        logOutBtn = findViewById(R.id.cardLogoutBtn);

        FirebaseUser mUser = mAuth.getCurrentUser();
        if (mUser!=null) {
            //Display user email from registered firebase account
            email.setText(mUser.getEmail());
        }

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        gsc = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account!=null){
            //Display user email from google account
            String userEmail = account.getEmail();
            email.setText(userEmail);
        }

        //what happens when user click the button
        getHelpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, GetHelp.class));
            }
        });

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this,Dashboard.class);
                startActivity(intent);
            }
        });

        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this,Settings.class);
                startActivity(intent);
            }
        });

        achievementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChat();
            }
        });

        leaderboardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLeaderboard();
            }
        });
    }

    //function for sign out
    void signOut(){
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                mAuth.signOut();
                finish();
                startActivity(new Intent(HomePage.this, MainActivity.class));
            }
        });
    }

    public void openChat(){
        Intent intent = new Intent(this,Chat.class);
        startActivity(intent);
    }

    public void openLeaderboard(){
        Intent intent = new Intent(this,leaderboard_recycler.class);
        startActivity(intent);
    }
}