package com.example.stopsmoking;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProTips extends AppCompatActivity {

    ImageView backform;

    TextView detailsText_1;
    TextView detailsText_2;
    TextView detailsText_3;

    LinearLayout layout_1;
    LinearLayout layout_2;
    LinearLayout layout_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_tips);

        backform = findViewById(R.id.back_form2);

        detailsText_1 = findViewById(R.id.details_1);
        layout_1 = findViewById(R.id.layout_1);
        layout_1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        detailsText_2 = findViewById(R.id.details_2);
        layout_2 = findViewById(R.id.layout_2);
        layout_2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        detailsText_3 = findViewById(R.id.details_3);
        layout_3 = findViewById(R.id.layout_3);
        layout_3.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        backform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }

    public void expand_1(View view) {
        int v = (detailsText_1.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout_1,new AutoTransition());
        detailsText_1.setVisibility(v);
    }

    public void expand_2(View view){
        int v = (detailsText_2.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout_2,new AutoTransition());
        detailsText_2.setVisibility(v);
    }

    public void expand_3(View view){
        int v = (detailsText_3.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout_3,new AutoTransition());
        detailsText_3.setVisibility(v);
    }

    public void openActivity2(){
        Intent intent = new Intent(this,HomePage.class);
        startActivity(intent);
    }
}