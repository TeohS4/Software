package com.example.stopsmoking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Settings extends AppCompatActivity {

    AppCompatButton edit_profile;
    ImageView back_button;
    ImageView to_about;
    ImageView facebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        edit_profile = findViewById(R.id.edit_profile_button);
        back_button = findViewById(R.id.setting_back);
        to_about = findViewById(R.id.to_about1);
        facebook = findViewById(R.id.join_facebook);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFacebook();
            }
        });

        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEdit_form();
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBackbutton();
            }
        });

        to_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTo_About();

            }
        });
    }

    public void openFacebook(){
        Intent intent = new Intent(this,join_facebook.class);
        startActivity(intent);
    }

    public void openEdit_form(){
        Intent intent = new Intent(this,EditProfile.class);
        startActivity(intent);
    }

    public void openBackbutton(){
        Intent intent = new Intent(this,HomePage.class);
        startActivity(intent);
    }

    public void openTo_About(){
        Intent intent = new Intent(this,AboutUs.class);
        startActivity(intent);
    }

}