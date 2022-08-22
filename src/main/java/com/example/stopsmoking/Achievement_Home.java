package com.example.stopsmoking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Achievement_Home extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement_home);

        listView = findViewById(R.id.listView);

        ArrayList<Achievement> arrayList = new ArrayList<>();

        arrayList.add(new Achievement(R.drawable.ic_achievement,"3 Days Without Smoke","This person has not smoked for 3 days in a row"));
        arrayList.add(new Achievement(R.drawable.ic_achievement,"5 Days Without Smoke","This person has not smoked for 5 days in a row"));
        arrayList.add(new Achievement(R.drawable.ic_achievement,"1 Week Without Smoke","This person has not smoked for a week"));
        arrayList.add(new Achievement(R.drawable.ic_achievement,"1 Month Without Smoke","This person has not smoked for a month"));

        AchievementAdapter achievementAdapter = new AchievementAdapter(this,R.layout.list_row,arrayList);

        listView.setAdapter(achievementAdapter);
    }
}