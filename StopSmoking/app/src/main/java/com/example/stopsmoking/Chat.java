package com.example.stopsmoking;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class Chat extends AppCompatActivity {

    EditText etPhone,etMessage;
    Button btSend;
    Button form;
    private ImageView backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //Assign Variable
        etPhone = findViewById(R.id.et_phone);
        etMessage = findViewById(R.id.et_message);
        btSend = findViewById(R.id.bt_send);
        form = (Button) findViewById(R.id.helpform);
        backbutton = findViewById(R.id.back_button_1);


        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                String UriText = "mailto:" + Uri.encode("tzixuan123@gmail.com") + "?subject=" +
                        Uri.encode("Chat")  + Uri.encode("");
                Uri uri = Uri.parse(UriText);
                intent.setData(uri);
                startActivity(Intent.createChooser(intent,"send email"));

            }
        });

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBackbutton();
            }
        });



        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check condition
                if (ContextCompat.checkSelfPermission(Chat.this
                        , Manifest.permission.SEND_SMS)
                    == PackageManager.PERMISSION_GRANTED){

                    //When permission is granted
                    //Create method
                    sendMessage();

                }else{
                    //When permission is not granted
                    //Request permission
                    ActivityCompat.requestPermissions(Chat.this,new String[]{Manifest.permission.SEND_SMS},100);
                }
            }
        });
    }

    private void sendMessage(){
        //Get values from edit text
        String sPhone = etPhone.getText().toString().trim();
        String sMessage = etMessage.getText().toString().trim();

        //Check condition
        if (!sPhone.equals("") && !sMessage.equals("")){
            //When both edit text value not equal to blank
            //Initialize sms manager
            SmsManager smsManager = SmsManager.getDefault();

            //Send text message
            smsManager.sendTextMessage(sPhone,null,sMessage,null,null);

            //Display toast
            Toast.makeText(getApplicationContext(),"SMS sent successfully",Toast.LENGTH_LONG).show();

        }else{
            //When edit text value is blank
            //Display toast
            Toast.makeText(getApplicationContext(),"Enter value first.",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        //Check condition
        if (requestCode == 100 && grantResults.length > 0 && grantResults[0]
        == PackageManager.PERMISSION_GRANTED){
            //When permission is granted
            //Call method
            sendMessage();
        }else{
            //When permission is denied
            //Display toast
            Toast.makeText(getApplicationContext(),"Permission Denied!", Toast.LENGTH_SHORT).show();
        }
    }

    public void openBackbutton(){
        Intent intent = new Intent(this,HomePage.class);
        startActivity(intent);
    }
}
