package com.example.stopsmoking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Add_Achievement extends AppCompatActivity {

    ImageView backbutton;
    Button addGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_achievement);

        backbutton = findViewById(R.id.back_button);
        addGoal = findViewById(R.id.addGoalButton);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBackPage();
            }
        });

        addGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Add_Achievement.this,"Achievement Added",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openBackPage(){
        Intent intent = new Intent(this, AdminPage.class);
        startActivity(intent);
    }
}

