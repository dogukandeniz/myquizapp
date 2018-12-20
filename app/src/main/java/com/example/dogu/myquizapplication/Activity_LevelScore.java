package com.example.dogu.myquizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.dogu.myquizapplication.DbHelper.DbHelper;
import com.example.dogu.myquizapplication.LocalScoreBoard.ScoreActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_LevelScore extends AppCompatActivity {

    LinearLayout yourScore;
    FirebaseAuth mAuth;
    DatabaseReference mUserRefDatabase;
    ChildEventListener mChildEventListener;
    DbHelper dbHelper = new DbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__level_score);
        setTitle("Scores");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setAuthInstance();
        setDatabaseInstance();

        yourScore = (LinearLayout)findViewById(R.id.inter);

        int compMarksB=dbHelper.getScoreCompFundaB();
        int hardwareMarksB=dbHelper.getScoreHardwareB();
        int osMarksB=dbHelper.getScoreOSB();
        int finalMarks=dbHelper.getScoreRandom();

        String userId = mAuth.getCurrentUser().getUid();
        mUserRefDatabase.child("users").child(userId).child("compMarksB").setValue(compMarksB);

        mUserRefDatabase.child("users").child(userId).child("hardwareMarksB").setValue(hardwareMarksB);

        mUserRefDatabase.child("users").child(userId).child("osMarksB").setValue(osMarksB);

        mUserRefDatabase.child("users").child(userId).child("finalMarks").setValue(finalMarks);


        yourScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),ScoreActivity.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });




    }

    private void setAuthInstance() {
        mAuth = FirebaseAuth.getInstance();
    }

    private void setDatabaseInstance() {
        mUserRefDatabase = FirebaseDatabase.getInstance().getReference();
    }


    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
