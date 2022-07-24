package com.example.stopsmoking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class leaderboard_recycler extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Versions> versionsList;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard_recycler);

        recyclerView = findViewById(R.id.recyclerView);
        back = findViewById(R.id.leaderboard_back);

        initData();
        setRecyclerView();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBack();
            }
        });
    }

    private void setRecyclerView() {
        VersionsAdapter versionsAdapter = new VersionsAdapter(versionsList);
        recyclerView.setAdapter(versionsAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {

        versionsList = new ArrayList<>();

        versionsList.add(new Versions("1. Mike", "016-3223 222", "Level 12", "No smoking for more than 10 days"));
        versionsList.add(new Versions("2. Najib", "Unknown", "Level 9", "No smoking for more than 8 days"));
        versionsList.add(new Versions("3. Elon Musk", "Unknown", "Level 6", "No smoking for more than 5 days"));
        versionsList.add(new Versions("4. John Snown", "255 2233222", "Level 1", "Just started"));

    }

    public void openBack(){
        Intent intent = new Intent(this,HomePage.class);
        startActivity(intent);
    }
}