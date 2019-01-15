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
        String userId = mAuth.getCurrentUser().getUid();

        int compMarksB=dbHelper.getScoreHukuk(userId);
        int hardwareMarksB=dbHelper.getScoreIktisat(userId);
        int osMarksB=dbHelper.getScoreEczacilik(userId);
        int finalMarks=dbHelper.getScoreMuhendislik(userId);

        int countEczacilik=dbHelper.getEczacilikScoreCount(userId);
        int countHukuk=dbHelper.getHukukScoreCount(userId);
        int countIktisat=dbHelper.getIktisatScoreCount(userId);
        int countMuhendislik=dbHelper.getMuhendislikScoreCount(userId);



        //Firebase'ye baglanıp ilgili child yani dügümlere countlarını ve skorlarını giriyoruz.
        mUserRefDatabase.child("users").child(userId).child("hukukB").setValue(compMarksB);
        mUserRefDatabase.child("users").child(userId).child("countHukuk").setValue(countHukuk);

        mUserRefDatabase.child("users").child(userId).child("eczacilikB").setValue(osMarksB);
        mUserRefDatabase.child("users").child(userId).child("countEczacilik").setValue(countEczacilik);
        mUserRefDatabase.child("users").child(userId).child("iktitasB").setValue(hardwareMarksB);
        mUserRefDatabase.child("users").child(userId).child("countIktisat").setValue(countIktisat);
        mUserRefDatabase.child("users").child(userId).child("muhendislikB").setValue(finalMarks);
        mUserRefDatabase.child("users").child(userId).child("countMuhendislik").setValue(countMuhendislik);

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
