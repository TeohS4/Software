package com.example.stopsmoking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MoneySaved extends AppCompatActivity {

    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_saved);

        // initializing our edittext and button
        EditText smokeAmt = findViewById(R.id.idSmokePackAmt);
        TextView total = findViewById(R.id.idTotal);
        back = findViewById(R.id.money_back);

        Button sendDatabtn = findViewById(R.id.idBtnSendData);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBack();
            }
        });

        // adding on click listener for our button.
        sendDatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from our edittext fields.
                String amt= smokeAmt.getText().toString();
                int finalValue=Integer.parseInt(amt);
                // below line is for checking weather the
                // edittext fields are empty or not.
                if (TextUtils.isEmpty(amt) ) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(MoneySaved.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.
                    //addDatatoFirebase(amt);
                    finalValue=finalValue*15;
                    total.setText("RM "+finalValue+" saved.");
                    //Toast.makeText(MoneySaved.this, amt, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void openBack(){
        Intent intent = new Intent(this,Dashboard.class);
        startActivity(intent);
    }
}