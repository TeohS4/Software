package com.example.stopsmoking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddProTips extends AppCompatActivity {

    Button addTips;
    EditText tipsName, tipsDesc;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    aProTips protips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pro_tips);

        addTips = findViewById(R.id.addTip);
        tipsName = findViewById(R.id.tipsTitle);
        tipsDesc = findViewById(R.id.tipsDes);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("protips");

        protips = new aProTips();

        addTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = tipsName.getText().toString();
                String desc = tipsDesc.getText().toString();

                if (name.isEmpty() || desc.isEmpty()) {
                    Toast.makeText(AddProTips.this, "Please fill in all the details", Toast.LENGTH_SHORT).show();
                } else {
                    addDatatoFirebase(name, desc);
                    Toast.makeText(AddProTips.this, "Tips Submitted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void addDatatoFirebase(String name, String desc) {

        protips.setName(name);
        protips.setDesc(desc);
        reference.push().setValue(protips);

        // after adding this data we are showing toast message.
        Toast.makeText(AddProTips.this, "Tips Added", Toast.LENGTH_SHORT).show();
    }
}