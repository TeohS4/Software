package com.example.stopsmoking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.stopsmoking.HomePage;
import com.example.stopsmoking.LifeWon;
import com.example.stopsmoking.MoneySaved;
import com.example.stopsmoking.ProTips;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Dashboard extends AppCompatActivity {

    ImageView back;
    private Button watch;
    private Button Msaved;
    private Button Lwon;
    private Button Ptips;
    private Button Achievement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        back = findViewById(R.id.back_form1);
        watch = findViewById(R.id.expand_1);
        Msaved = findViewById(R.id.money_saved);
        Lwon = findViewById(R.id.life_won);
        Ptips = findViewById(R.id.pro_tips);
        Achievement = findViewById(R.id.achivement);

        Achievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAchievementPage();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStopwatch();
            }
        });

        Msaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMoneySaved();
            }
        });

        Lwon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLifeWon();
            }
        });

        Ptips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProTips();
            }
        });
    }

    private void showToast(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
    public void openActivity2(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void openStopwatch(){
        Intent intent = new Intent(this,Stopwatch.class);
        startActivity(intent);
    }

    public void openMoneySaved(){
        Intent intent = new Intent(this, MoneySaved.class);
        startActivity(intent);
    }

    public void openLifeWon(){
        Intent intent = new Intent(this, LifeWon.class);
        startActivity(intent);
    }

    public void openProTips(){
        Intent intent = new Intent(this, ProTips.class);
        startActivity(intent);
    }

    public void openAchievementPage(){
        Intent intent = new Intent(this,Achievement_Home.class);
        startActivity(intent);
    }
}