package com.example.stopsmoking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.stopsmoking.HomePage;

public class SendMail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mail);
        getSupportActionBar().hide();

        Button form;
        Button back;

            form = (Button) findViewById(R.id.helpform);
            form.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    String UriText = "mailto:" + Uri.encode("") + "?subject=" +
                            Uri.encode("HelpForm")  + Uri.encode("");
                    Uri uri = Uri.parse(UriText);
                    intent.setData(uri);
                    startActivity(Intent.createChooser(intent,"send email"));

                }
            });

            back = findViewById(R.id.backform);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openHomePage();
                }
            });

        }
        public void openHomePage(){
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);
        }
}
