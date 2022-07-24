package com.example.stopsmoking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.stopsmoking.Dashboard;

public class Stopwatch2 extends AppCompatActivity {

    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch2);

        back = findViewById(R.id.stopwatch2_back);
        chronometer = findViewById(R.id.count_time);
        chronometer.setFormat("Time: %s");
        chronometer.setBase(SystemClock.elapsedRealtime());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBackForm();
            }
        });

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 10000){
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    Toast.makeText(Stopwatch2.this, "Bing!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void startChronometer(View v){
        if (!running){
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
        }
    }

    public void pauseChronometer(View v){
        if (running){
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }

    public void resetChronometer(View v){
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }

    public void openBackForm(){
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
}