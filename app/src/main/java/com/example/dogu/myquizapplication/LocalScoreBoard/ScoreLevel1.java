package com.example.dogu.myquizapplication.LocalScoreBoard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.dogu.myquizapplication.LeaderBoard.LeaderBoardAcSec1B;
import com.example.dogu.myquizapplication.R;

public class ScoreLevel1 extends AppCompatActivity {

    LinearLayout beginner;
    LinearLayout intermediate;
    LinearLayout expert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_level1);
        setTitle("Hukuk Skor");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        beginner=(LinearLayout)findViewById(R.id.begin);


        beginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),LeaderBoardAcSec1B.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
