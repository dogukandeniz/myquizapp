package com.example.dogu.myquizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dogu.myquizapplication.DbHelper.DbHelper;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {
    int score=0, scoreECZACILIK =0, scoreHUKUK =0, scoreIKTISAT =0, scoreMUHENDISLIK =0;

    DbHelper dbHelper = new DbHelper(this);
    Button btnWrongQstns;

    public ArrayList<String> wrongQuests = new ArrayList<String>();
    public ArrayList<String> selectedAnswers = new ArrayList<String>();
    public ArrayList<String> actualAnswers = new ArrayList<String>();

    private ImageView img;
    private TextView tvPerc;
    String tableName="",catName="",userID="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        img = (ImageView) findViewById(R.id.imageView);
        btnWrongQstns = (Button) findViewById(R.id.btnWrongQstns);

        //get text view
        TextView txtCorrectAns = (TextView) findViewById(R.id.txtCorrectAns);
        //get score
        final Bundle b = getIntent().getExtras();
        if (b.containsKey("scoreEczacilik")) {
            scoreECZACILIK = b.getInt("scoreEczacilik");
            userID = b.getString("user_id");
            tableName=b.getString("section");
            catName=b.getString("category");
            dbHelper.insertScoreEczacilik(scoreECZACILIK,tableName,catName,userID);
            score = scoreECZACILIK;
        } else if (b.containsKey("scoreHukuk")) {
            userID = b.getString("user_id");
            scoreHUKUK = b.getInt("scoreHukuk");
            tableName=b.getString("section");
            catName=b.getString("category");
            dbHelper.insertScoreHukuk(scoreHUKUK,tableName,catName,userID);
            score = scoreHUKUK;
        } else if (b.containsKey("scoreIktisat")) {
            userID = b.getString("user_id");
            scoreIKTISAT = b.getInt("scoreIktisat");
            tableName=b.getString("section");
            catName=b.getString("category");
            dbHelper.insertScoreIktisat(scoreIKTISAT,tableName,catName,userID);
            score = scoreIKTISAT;
        } else if (b.containsKey("scoreMuhendislik")){
            userID = b.getString("user_id");
            scoreMUHENDISLIK = b.getInt("scoreMuhendislik");
            tableName=b.getString("section");
            catName=b.getString("category");
            dbHelper.insertScoreMuhendislik(scoreMUHENDISLIK,tableName,catName,userID);
            score = scoreMUHENDISLIK;

        }

        txtCorrectAns.setText("Total Answered : 10" + "\n" + "Correct Answered : " + score + "\nWrong Answered : " + (10 - score));

        wrongQuests = getIntent().getStringArrayListExtra("wrongQuestions");
        selectedAnswers = getIntent().getStringArrayListExtra("selectedAnswer");
        actualAnswers = getIntent().getStringArrayListExtra("actualAnswer");

        double perc = score*3.33;
        DecimalFormat df = new DecimalFormat("##.###");
        tvPerc = (TextView) findViewById(R.id.tvPerc);
        tvPerc.setText(""+df.format(perc)+" %");

        btnWrongQstns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultsActivity.this, WrongQuestion.class);
                //Bundle b = new Bundle();
                intent.putStringArrayListExtra("wrongQuestions", wrongQuests);
                intent.putStringArrayListExtra("selectedAnswer", selectedAnswers);
                intent.putStringArrayListExtra("actualAnswer", actualAnswers);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}
