package com.example.stopsmoking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AdminPage extends AppCompatActivity {

    ImageView backbutton;
    CardView add_achievement;
    CardView proTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        getSupportActionBar().hide();

        backbutton = findViewById(R.id.back_button);
        add_achievement = findViewById(R.id.cardAchievement);
        proTips = findViewById(R.id.cardProTips);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBack();
            }
        });

        add_achievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAchievement();
            }
        });

        proTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminPage.this,AddProTips.class);
                startActivity(intent);
            }
        });
    }

    public void openBack(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void openAchievement(){
        Intent intent = new Intent(this,Add_Achievement.class);
        startActivity(intent);
    }
}